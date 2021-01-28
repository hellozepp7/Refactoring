package 行为设计模式.策略模式.strategies;

/**
 * <pre>
 * Description:
 *          通用的支付方法接口
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public interface PayStrategy {

    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
