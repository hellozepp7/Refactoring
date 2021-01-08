package 行为设计模式.责任链模式;

import 行为设计模式.责任链模式.middleware.Middleware;
import 行为设计模式.责任链模式.middleware.RoleCheckMiddleware;
import 行为设计模式.责任链模式.middleware.ThrottlingMiddleware;
import 行为设计模式.责任链模式.middleware.UserExistsMiddleware;
import 行为设计模式.责任链模式.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * Description:
 *          责任链模式，行为设计模式
 *          将请求沿着处理者链进行发送。收到请求后，每个处理者均可对请求进行处理，或将其传递给链上的下个处理者。
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class Demo {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void main(String[] args) throws IOException {
        //初始化组装责任链
        init();
        //输入参数
        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            //按链路校验
            success = server.logIn(email, password);
        }while (!success);
        System.out.println(success);
    }

    /**
     * @Description:
     *          初始化组装责任链与设置给业务服务
     * @Author Zepp Deng [2021-01-08 11:44]
     */
    private static void init() {
        //服务注册两个待校验用户
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        //组装责任链，可以初始化组装好，也可以在每个处理者中判断是否组装下一个
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server)).linkWith(new RoleCheckMiddleware());

        //校验服务使用该责任链
        server.setMiddleware(middleware);
    }
}
