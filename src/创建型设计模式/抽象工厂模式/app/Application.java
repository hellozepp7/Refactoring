package 创建型设计模式.抽象工厂模式.app;

import 创建型设计模式.抽象工厂模式.buttons.Button;
import 创建型设计模式.抽象工厂模式.checkboxes.Checkbox;
import 创建型设计模式.抽象工厂模式.factories.GUIFactory;

/**
 * <pre>
 * Description:
 *          客户端代码,即需要产品的app
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class Application {

    private Button button;
    private Checkbox checkbox;

    /**
     * @Description:
     *         仅通过抽象类型（GUIFactory、Button 和 Checkbox）使用工厂和产品
     *         无需修改任何工厂或产品子类就能将其传递给客户端代码
     * @Author Zepp Deng [2021-01-07 17:15]
     * @param factory
     * @Return Application
     */
    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    /**
     * @Description:
     *          各自产品执行各自的实现方法
     * @Author Zepp Deng [2021-01-07 17:15]
     */
    public void paint(){
        button.paint();
        checkbox.paint();
    }

}
