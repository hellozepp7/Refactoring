package 创建型设计模式.抽象工厂模式.factories;

import 创建型设计模式.抽象工厂模式.buttons.Button;
import 创建型设计模式.抽象工厂模式.checkboxes.Checkbox;

/**
 * <pre>
 * Description:
 *          抽象工厂
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public interface GUIFactory {

    Button createButton();
    Checkbox createCheckbox();
}
