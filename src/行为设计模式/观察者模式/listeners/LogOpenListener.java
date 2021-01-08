package 行为设计模式.观察者模式.listeners;

import java.io.File;

/**
 * <pre>
 * Description:
 *          具体订阅者会对其注册的发布者所发出的更新消息做出响应。
 *          观察者B，收到通知后在日志中记录一条消息
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class LogOpenListener implements EventListener {

    private File log;

    public LogOpenListener(String fileName) {
        this.log = new File(fileName);
    }

    /**
     * @Description:
     *          发布者有open或save动作时，观察者调用相关处理方法
     * @Author Zepp Deng [2021-01-07 15:23]
     * @param eventType
     * @param file
     */
    @Override
    public void update(String eventType, File file) {
        System.out.println("editor执行了方法：" + eventType + "；数据：" + file + ";记录日志：" + log);
    }
}
