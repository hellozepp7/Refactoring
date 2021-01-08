package 结构性模式.代理模式.some_cool_media_library;

import java.util.HashMap;

/**
 * <pre>
 * Description:
 *          远程服务接口
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public interface ThirdPartyYouTubeLib {

    HashMap<String,Video> popularVideos();

    Video getVideo(String videoId);

}
