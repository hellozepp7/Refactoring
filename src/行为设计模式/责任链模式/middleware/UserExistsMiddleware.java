package 行为设计模式.责任链模式.middleware;

import 行为设计模式.责任链模式.server.Server;

/**
 * <pre>
 * Description:
 *          责任链处理者B
 *          检查用户登录信息
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class UserExistsMiddleware extends Middleware {

    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }
    @Override
    public boolean check(String email, String password) {
        System.out.println("B校验用户登录信息");
        if (!server.hasEmail(email)) {
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            return false;
        }
        //调用下一个处理者
        return checkNext(email, password);
    }
}
