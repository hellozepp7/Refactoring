package 创建型设计模式.抽象工厂模式.factories;

import 创建型设计模式.抽象工厂模式.buttons.Button;
import 创建型设计模式.抽象工厂模式.buttons.MacOSButton;
import 创建型设计模式.抽象工厂模式.checkboxes.Checkbox;
import 创建型设计模式.抽象工厂模式.checkboxes.MacOSCheckbox;

/**
 * <pre>
 * Description:
 *          mac系统产品具体工厂
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
