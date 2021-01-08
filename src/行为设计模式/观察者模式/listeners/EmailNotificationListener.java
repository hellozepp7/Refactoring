package 行为设计模式.观察者模式.listeners;

import java.io.File;

/**
 * <pre>
 * Description:
 *          具体订阅者会对其注册的发布者所发出的更新消息做出响应。
 *          观察者A，负责收到通知后发送邮件
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class EmailNotificationListener implements EventListener {

    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    /**
     * @Description:
     *          发布者有open或save动作时，观察者调用相关处理方法
     * @Author Zepp Deng [2021-01-07 15:16]
     * @param eventType
     * @param file
     */
    @Override
    public void update(String eventType, File file) {
        System.out.println("editor执行了方法：" + eventType + "；数据：" + file + ";发送邮件通知：" + email);
    }
}
