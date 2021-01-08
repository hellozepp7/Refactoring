package 创建型设计模式.工厂模式.factory;

import 创建型设计模式.工厂模式.buttons.Button;
import 创建型设计模式.工厂模式.buttons.WindowsButton;

/**
 * <pre>
 * Description:
 *          具体创建者将重写工厂方法以改变其所返回的产品类型
 *          具体创建者B
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class WindowsDialog extends Dialog {

    /**
     * @Description:
     *          创建者B通过工厂方法创建产品B
     * @Author Zepp Deng [2021-01-07 16:00]
     * @Return Button
     */
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}
