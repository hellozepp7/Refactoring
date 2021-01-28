package 结构型模式.外观模式.facade;

import 结构型模式.外观模式.some_complex_media_library.AudioMixer;
import 结构型模式.外观模式.some_complex_media_library.BitrateReader;
import 结构型模式.外观模式.some_complex_media_library.Codec;
import 结构型模式.外观模式.some_complex_media_library.CodecFactory;
import 结构型模式.外观模式.some_complex_media_library.MPEG4CompressionCodec;
import 结构型模式.外观模式.some_complex_media_library.OggCompressionCodec;
import 结构型模式.外观模式.some_complex_media_library.VideoFile;

import java.io.File;

/**
 * <pre>
 * Description:
 *           外观提供了进行视频转换的简单接口
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class VideoConversionFacade {

    /**
     * @Description:
     *          进行视频转换流程
     * @Author Zepp Deng [2021-01-28 14:28]
     * @param fileName
     * @param format
     * @Return File
     */
    public File convertVideo(String fileName, String format){
        System.out.println("视频转换：转换已开始");
        //初始化视频信息
        VideoFile file = new VideoFile(fileName);
        //创建解码器
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec = format.equals("mp4") ? new MPEG4CompressionCodec() : new OggCompressionCodec();
        //比特阅读器读取与写入文件
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        //混音器修复视频文件
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("视频转换：转换完成.");
        return result;
    }

}
