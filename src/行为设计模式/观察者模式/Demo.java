package 行为设计模式.观察者模式;

import 行为设计模式.观察者模式.editor.Editor;
import 行为设计模式.观察者模式.listeners.EmailNotificationListener;
import 行为设计模式.观察者模式.listeners.LogOpenListener;

/**
 * <pre>
 * Description:
 *      观察者模式，行为设计模式
 *      允许一个对象将其状态的改变通知其他对象
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class Demo {

    public static void main(String[] args) {

        //初始化发布者，即被观察对象，此时会在构造函数存入需要监听的事件
        Editor editor = new Editor();
        //存入监听事件对应的监听类，后面是监听类各自实现方法需要的参数，可有可无按业务而定
        editor.eventManager.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.eventManager.subscribe("save", new EmailNotificationListener("admin@example.com"));

        //执行会被不同观察者类监听的具体方法
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
