package 行为设计模式.策略模式;

import 行为设计模式.策略模式.order.Order;
import 行为设计模式.策略模式.strategies.PayByCreditCard;
import 行为设计模式.策略模式.strategies.PayByPayPal;
import 行为设计模式.策略模式.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description:
 *          策略模式是一种行为设计模式
 *          你定义一系列算法， 并将每种算法分别放入独立的类中， 以使算法的对象能够相互替换。
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public class Demo {

    //产品价格map
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //订单
    private static Order order = new Order();
    //支付接口
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        //进入购买流程
        while (!order.isClosed()) {
            //产品价格
            int cost;
            //是否继续购买
            String continueChoice;
            do {
                System.out.print("请选择购买产品:" + "\n" +
                        "1 - 机箱" + "\n" +
                        "2 - CPU处理器" + "\n" +
                        "3 - 硬盘" + "\n" +
                        "4 - 内存" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                //获取产品价格
                cost = priceOnProducts.get(choice);
                System.out.print("请输入购买数量: ");
                int count = Integer.parseInt(reader.readLine());
                //产品总价格
                order.setTotalCost(cost * count);
                System.out.print("是否继续购买其他产品？ Y/N: ");
                continueChoice = reader.readLine();
            }while (continueChoice.equalsIgnoreCase("Y"));

            //选择支付接口
            if (strategy == null) {
                System.out.println("请选择支付方式:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - 信用卡");
                String paymentMethod = reader.readLine();
                strategy = paymentMethod.equals("1") ? new PayByPayPal() : new PayByCreditCard();
            }
            //校验
            order.processOrder(strategy);
            System.out.print("需支付 " + order.getTotalCost() + " 元，取消或继续支付？ P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                //根据选择的支付方式付款
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("消费成功.");
                } else {
                    System.out.println("消费失败.");
                }
            }
            //支付流程结束
            order.setClosed();
        }
    }

}
