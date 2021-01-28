package 结构型模式.外观模式.some_complex_media_library;

/**
 * <pre>
 * Description:
 *          比特阅读器
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class BitrateReader {

    public static VideoFile read(VideoFile file, Codec codec){
        System.out.println("比特阅读器读取文件中...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("比特阅读器写入文件中...");
        return buffer;
    }

}
