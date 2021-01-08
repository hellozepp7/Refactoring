package 创建型设计模式.工厂模式.buttons;

import 创建型设计模式.工厂模式.buttons.Button;

/**
 * <pre>
 * Description:
 *          具体产品B
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class WindowsButton implements Button {


    @Override
    public void render() {
        // TODO 产品B自己的具体渲染初始化操作
        System.out.println("win10系统创建按钮");
        onClick();
    }

    @Override
    public void onClick() {
        //TODO 产品B具体点击操作
        System.out.println("win10点击按钮");
    }
}
