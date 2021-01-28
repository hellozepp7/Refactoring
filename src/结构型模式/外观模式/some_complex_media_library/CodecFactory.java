package 结构型模式.外观模式.some_complex_media_library;

/**
 * <pre>
 * Description:
 *      解码器工厂
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class CodecFactory {

    /**
     * @Description:
     *          创建解码器
     * @Author Zepp Deng [2021-01-28 14:19]
     * @param file
     * @Return Codec
     */
    public static Codec extract(VideoFile file){
        String type = file.getCodecType();
        if (type.equals("mp4")){
            System.out.println("提取MP4音频");
            return new MPEG4CompressionCodec();
        }else{
            System.out.println("提取Ogg音频");
            return new OggCompressionCodec();
        }
    }

}
