package 结构型模式.代理模式.downloader;

import 结构型模式.代理模式.some_cool_media_library.ThirdPartyYouTubeLib;
import 结构型模式.代理模式.some_cool_media_library.Video;

import java.util.HashMap;

/**
 * <pre>
 * Description:
 *          媒体下载应用
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class YouTubeDownloader {

    //模拟YouTube下载器
    private ThirdPartyYouTubeLib youtubeService;

    /**
     * @Description:
     *          构造函数选取原下载器还是缓存代理类
     * @Author Zepp Deng [2021-01-08 15:17]
     * @param youtubeService
     * @Return YouTubeDownloader
     */
    public YouTubeDownloader(ThirdPartyYouTubeLib youtubeService) {
        this.youtubeService = youtubeService;
    }

    /**
     * @Description:
     *          下载指定video
     *          可能基于原下载器也可能使用代理类实现
     * @Author Zepp Deng [2021-01-08 14:59]
     * @param videoId
     */
    public void renderVideoPage(String videoId) {
        Video video = youtubeService.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.id);
        System.out.println("Title: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("-------------------------------\n");
    }

    /**
     * @Description:
     *          下载流行video
     *          可能基于原下载器也可能使用代理类实现
     * @Author Zepp Deng [2021-01-08 15:00]
     */
    public void renderPopularVideos() {
        HashMap<String, Video> list = youtubeService.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " & Title: " + video.title);
        }
        System.out.println("-------------------------------\n");
    }

}
