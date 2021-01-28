package 结构型模式.外观模式.some_complex_media_library;

/**
 * <pre>
 * Description:
 *          MP4压缩编码
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class MPEG4CompressionCodec implements Codec{

    public MPEG4CompressionCodec(){
        System.out.println("创建MP4格式视频文件");
    }

    public String type = "mp4";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
