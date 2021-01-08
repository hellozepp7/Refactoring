package 创建型设计模式.工厂模式.buttons;

/**
 * <pre>
 * Description:
 *      通用产品接口
 * @author Zepp Deng
 * @date 2021/1/7
 * </pre>
 */
public interface  Button {

    //产品接口中将声明所有具体产品都必须实现的操作
    void render();
    void onClick();

}
