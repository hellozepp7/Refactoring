package 结构型模式.外观模式.some_complex_media_library;

import java.io.File;

/**
 * <pre>
 * Description:
 *          混音器
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class AudioMixer {

    public File fix(VideoFile file){
        System.out.println("混音器修复音频中...");
        return new File("tmp");
    }

}
