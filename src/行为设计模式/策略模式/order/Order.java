package 行为设计模式.策略模式.order;

import 行为设计模式.策略模式.strategies.PayStrategy;

/**
 * <pre>
 * Description:
 *          订单类
 * @author Zepp Deng
 * @date 2021/1/27
 * </pre>
 */
public class Order {

    private int totalCost = 0;

    private boolean isClosed = false;

    /**
     * @Description:
     *          校验
     * @Author Zepp Deng [2021-01-27 11:24]
     * @param strategy
     */
    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
        // 从策略中收集和存储支付数据

    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        this.isClosed = true;
    }
}
