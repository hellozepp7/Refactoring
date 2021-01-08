package 行为设计模式.观察者模式.editor;

import 行为设计模式.观察者模式.publisher.EventManager;

import java.io.File;

/**
 * <pre>
 * Description:
 *           具体发布者， 由其他对象追踪
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class Editor {

    public EventManager eventManager;
    private File file;

    /**
     * @Description:
     *          具体发布者构造函数，初始化发布者
     * @Author Zepp Deng [2021-01-07 14:58] 
     * @Return Editor
     */
    public Editor(){
        this.eventManager = new EventManager("open","save");
    }

    /**
     * @Description:
     *          发布者open动作，eventManager监听open事件
     * @Author Zepp Deng [2021-01-07 15:04]
     * @param filePath
     */
    public void openFile(String filePath){
        this.file = new File(filePath);
        eventManager.notify("open",file);
    }

    /**
     * @Description:
     *          发布者save动作，eventManager监听save事件
     * @Author Zepp Deng [2021-01-07 15:04]
     * @throws Exception
     */
    public void saveFile() throws Exception {
        if (null != file){
            eventManager.notify("save",file);
        }else {
            throw new Exception("执行file先open再save");
        }
    }

}
