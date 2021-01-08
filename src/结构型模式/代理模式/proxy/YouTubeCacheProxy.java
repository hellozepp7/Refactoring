package 结构型模式.代理模式.proxy;

import 结构型模式.代理模式.some_cool_media_library.ThirdPartyYouTubeClass;
import 结构型模式.代理模式.some_cool_media_library.ThirdPartyYouTubeLib;
import 结构型模式.代理模式.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * <pre>
 * Description:
 *          ThirdPartyYouTubeClass提供了视频下载类。 但是该类的效率非常低。
 *          如果客户端程序多次请求同一视频， ThirdPartyYouTubeClass会反复下载该视频， 而不会将首次下载的文件缓存下来复用
 *          代理类实现和原ThirdPartyYouTubeLib相同的接口， 并将所有工作委派给原ThirdPartyYouTubeLib。
 *          不过， 代理类会保存所有的文件下载记录， 如果程序多次请求同一文件， 它会返回缓存的文件
 *          ——————————————————————————————————————————
 *          此类即缓存代理类
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    //模拟YouTube下载器
    private ThirdPartyYouTubeLib youtubeService;
    //缓存流行视频
    private HashMap<String, Video> cachePopular = new HashMap<>();
    //缓存所有视频
    private HashMap<String, Video> cacheAll = new HashMap<>();

    /**
     * @Description:
     *          获取原下载器，即需要被代理的类
     * @Author Zepp Deng [2021-01-08 15:20]
     * @Return YouTubeCacheProxy
     */
    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("从缓存代理类中获取流行视频缓存");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (null == video)
        {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId,video);
        }else {
            System.out.println("从缓存代理类中获取指定视频缓存");
        }
        return video;
    }
}
