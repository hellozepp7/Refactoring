package 结构型模式.外观模式.some_complex_media_library;

/**
 * <pre>
 * Description:
 *          Ogg压缩
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class OggCompressionCodec implements Codec{

    public OggCompressionCodec(){
        System.out.println("创建Ogg格式视频文件");
    }

    public String type = "ogg";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
