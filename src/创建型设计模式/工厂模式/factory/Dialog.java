package 创建型设计模式.工厂模式.factory;

import 创建型设计模式.工厂模式.buttons.Button;

/**
 * <pre>
 * Description:
 *      基础创建者
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public abstract class Dialog {

    /**
     * @Description:
     *          子类可通过重写工厂方法render()
     *          使其返回不同类型的产品来间接修改业务逻辑
     * @Author Zepp Deng [2021-01-07 15:55]
     */
    public void renderWindow(){
        // 调用工厂方法创建一个产品对象
        Button okButton = createButton();
        // 不同创建者使用不同产品的方法
        okButton.render();
    }

    protected abstract Button createButton();

}
