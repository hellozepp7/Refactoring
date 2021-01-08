package 行为设计模式.观察者模式.publisher;

import 行为设计模式.观察者模式.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Description:
 *      基础发布者
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class EventManager {

    //观察者集合，key为具体观察方法即事件
    Map<String, List<EventListener>> listenerMap = new HashMap<>();

    /**
     * @Description:
     *          基础发布者构造函数
     * @Author Zepp Deng [2021-01-07 14:43]
     * @param operations 可变长度参数列表
     * @Return EventManager
     */
    public EventManager(String... operations){
        for (String operation : operations){
            this.listenerMap.put(operation,new ArrayList<>());
        }
    }

    /**
     * @Description:
     *          为具体监听事件添加订阅者
     * @Author Zepp Deng [2021-01-07 14:45]
     * @param eventType
     * @param listener
     */
    public void subscribe(String eventType, EventListener listener){
        List<EventListener> listeners = listenerMap.get(eventType);
        listeners.add(listener);
    }

    /**
     * @Description:
     *          删除具体监听事件中的某个订阅者
     * @Author Zepp Deng [2021-01-07 14:45]
     * @param eventType
     * @param listener
     */
    public void unSubscribe(String eventType, EventListener listener){
        List<EventListener> listeners = listenerMap.get(eventType);
        listeners.remove(listener);
    }

    /**
     * @Description:
     *          基础发布者接收监听，遍历订阅者执行update方法
     * @Author Zepp Deng [2021-01-07 14:51]
     * @param eventType
     * @param file
     */
    public void notify(String eventType, File file){
        List<EventListener> users = listenerMap.get(eventType);
        for (EventListener listener : users){
            listener.update(eventType,file);
        }
    }

}
