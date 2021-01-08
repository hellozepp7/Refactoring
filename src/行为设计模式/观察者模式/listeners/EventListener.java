package 行为设计模式.观察者模式.listeners;

import java.io.File;

/**
 * <pre>
 * Description:
 *       通用观察者接口
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public interface  EventListener {

    /**
     * @Description:
     *          发布者接收事件后，调用该方法通知所有订阅者
     *          即观察者通过该方法实现监听
     * @Author Zepp Deng [2021-01-07 15:10]
     * @param eventType
     * @param file
     */
    void update(String eventType, File file);
}
