package 创建型设计模式.工厂模式;

import 创建型设计模式.工厂模式.factory.Dialog;
import 创建型设计模式.工厂模式.factory.HtmlDialog;
import 创建型设计模式.工厂模式.factory.WindowsDialog;

/**
 * <pre>
 * Description:
 *          工厂模式,创建型设计模式
 *          解决了在不指定具体类的情况下创建产品对象的问题。
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class Demo {

    private static Dialog dialog;

    public static void main(String[] args) {
        //根据未知原因判断创建者类型
        configure();
        //创建者创建不同产品调用各自方法
        runBusinessLogic();
    }

    /**
     * @Description:
     *          根据不同业务场景自动选择不同的具体创建者
     * @Author Zepp Deng [2021-01-07 16:09]
     */
    static void configure() {
        //模拟不同系统
        if (System.getProperty("os.name").equals("Windows 10")){
            dialog = new WindowsDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * @Description:
     *         根据不同的创建者创造不同的产品，并执行不同的方法
     *         此时模拟不同系统创建不同的弹窗，实现不同的按钮点击事件
     * @Author Zepp Deng [2021-01-07 16:12]
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }

}
