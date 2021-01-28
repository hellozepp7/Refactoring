package 行为设计模式.策略模式.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * Description:
 *          使用信用卡支付
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public class PayByCreditCard implements PayStrategy{

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * @Description:
     *          校验
     * @Author Zepp Deng [2021-01-27 11:11]
     */
    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("请输入卡号: ");
            String number = READER.readLine();
            System.out.print("请输入卡过期年月: ");
            String date = READER.readLine();
            System.out.print("请输入安全号码: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);
            //实现校验逻辑

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @Description:
     *          支付操作
     * @Author Zepp Deng [2021-01-27 11:16]
     * @param paymentAmount
     * @Return boolean
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (null != card) {
            System.out.println("使用引用卡支付成功，金额：" + paymentAmount);
            //扣款
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
        return false;
    }
}
