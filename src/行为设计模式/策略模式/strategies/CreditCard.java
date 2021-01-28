package 行为设计模式.策略模式.strategies;

/**
 * <pre>
 * Description:
 *          信用卡类
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public class CreditCard {

    //消费额度
    private int amount;
    private String number;
    //卡过期时间
    private String date;
    //安全号码
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
