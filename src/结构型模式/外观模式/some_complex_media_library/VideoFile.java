package 结构型模式.外观模式.some_complex_media_library;

/**
 * <pre>
 * Description:
 *          视频类
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class VideoFile {

    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }

}
