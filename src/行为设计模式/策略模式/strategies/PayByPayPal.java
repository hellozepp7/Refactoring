package 行为设计模式.策略模式.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description:
 *           使用 PayPal 支付
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public class PayByPayPal implements PayStrategy{

    //账号密码支付
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    //是否校验通过签名
    private boolean signedIn;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    /**
     * @Description:
     *          校验
     * @Author Zepp Deng [2021-01-27 11:11]
     */
    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("输入邮箱: ");
                email = READER.readLine();
                System.out.print("输入密码: ");
                password = READER.readLine();
                if (verify()) {
                    System.out.println("验证通过");
                } else {
                    System.out.println("验证失败");
                }
            }
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
        if (signedIn){
            System.out.println("使用PayPal支付成功，金额：" + paymentAmount);
            return true;
        }
        return false;
    }

    /**
     * @Description:
     *          校验
     * @Author Zepp Deng [2021-01-27 11:02]
     * @Return boolean
     */
    private boolean verify() {
        this.signedIn = email.equals(DATA_BASE.get(password));
        return signedIn;
    }

}
