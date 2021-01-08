package 创建型设计模式.抽象工厂模式.factories;

import 创建型设计模式.抽象工厂模式.buttons.Button;
import 创建型设计模式.抽象工厂模式.buttons.WindowsButton;
import 创建型设计模式.抽象工厂模式.checkboxes.Checkbox;
import 创建型设计模式.抽象工厂模式.checkboxes.WindowsCheckbox;

/**
 * <pre>
 * Description:
 *          windows系统产品具体工厂
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class WindowsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
