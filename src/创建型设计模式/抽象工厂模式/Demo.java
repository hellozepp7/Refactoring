package 创建型设计模式.抽象工厂模式;

import 创建型设计模式.抽象工厂模式.app.Application;
import 创建型设计模式.抽象工厂模式.factories.GUIFactory;
import 创建型设计模式.抽象工厂模式.factories.MacOSFactory;
import 创建型设计模式.抽象工厂模式.factories.WindowsFactory;

/**
 * <pre>
 * Description:
 *          抽象工厂模式，创建型设计模式
 *          创建一系列相关的对象，而无需指定其具体类
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class Demo {

    /**
     * @Description:
     *          根据不同的系统生成不同的app
     *          app根据不同的系统实现不同的具体工厂
     * @Author Zepp Deng [2021-01-07 17:24]
     * @Return Application
     */
    public static Application configureApplication(){

        Application app;
        GUIFactory factory;

        if (System.getProperty("os.name").toLowerCase().contains("windows 10")) {
            factory = new WindowsFactory();
            app = new Application(factory);
        } else {
            factory = new MacOSFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }

}
