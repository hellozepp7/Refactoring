package 行为设计模式.责任链模式.middleware;

/**
 * <pre>
 * Description:
 *          责任链处理者C
 *          检查用户角色
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class RoleCheckMiddleware extends Middleware {

    /**
     * @Description:
     *          校验成功返回
     * @Author Zepp Deng [2021-01-08 11:31]
     * @param email
     * @param password
     * @Return boolean
     */
    @Override
    public boolean check(String email, String password) {
        System.out.println("C校验用户角色");
        if (email.equals("admin@example.com")) {
            return true;
        }
        //调用下一个处理者
        return checkNext(email, password);
    }
}
