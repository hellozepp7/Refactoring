package 行为设计模式.责任链模式.server;

import 行为设计模式.责任链模式.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description:
 *          授权目标主业务流程
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class Server {

    //email-passWord
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    public void setMiddleware(Middleware middleware){
        this.middleware = middleware;
    }

    /**
     * @Description:
     *          添加用户
     * @Author Zepp Deng [2021-01-08 11:41]
     * @param email
     * @param password
     */
    public void register(String email, String password) {
        users.put(email, password);
    }

    /**
     * @Description:
     *          执行校验需要被责任链处理的参数
     * @Author Zepp Deng [2021-01-08 11:31]
     * @param email
     * @param password
     * @Return boolean
     */
    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            //TODO 具体业务代码

            return true;
        }
        return false;
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
