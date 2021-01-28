package 结构型模式.外观模式;

import 结构型模式.外观模式.facade.VideoConversionFacade;

import java.io.File;

/**
 * <pre>
 * Description:
 *          外观是一种结构型设计模式
 *          能为复杂系统、 程序库或框架提供一个简单有限的接口
 *          此例模仿视频文件创建流程
 * @author Zepp Deng
 * @date 2021/1/28
 * </pre>
 */
public class Demo {

    public static void main(String[] args) {

        VideoConversionFacade converter = new VideoConversionFacade();
        //创建ogg音频类型的YouTube视频mp4文件
        File file = converter.convertVideo("youtubevideo.ogg","mp4");


    }

}
