package 结构型模式.代理模式.some_cool_media_library;

/**
 * <pre>
 * Description:
 *          视频文件
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class Video {

    public String id;
    public String title;
    public String data;

    Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }
}
