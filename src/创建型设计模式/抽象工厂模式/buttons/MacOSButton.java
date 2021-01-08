package 创建型设计模式.抽象工厂模式.buttons;

/**
 * <pre>
 * Description:
 *          mac系统的button产品
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public class MacOSButton implements Button {

    @Override
    public void paint() {
        //TODO button产品具体
        System.out.println("mac系统的button产品");
    }
}
