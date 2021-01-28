package 行为设计模式.模版方法模式;

import 行为设计模式.模版方法模式.networks.Facebook;
import 行为设计模式.模版方法模式.networks.Network;
import 行为设计模式.模版方法模式.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * Description:
 *          模版方法是一种行为设计模式
 *          它在基类中定义了一个算法的框架， 允许子类在不修改结构的情况下重写算法的特定步骤
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("输入用户名: ");
        String userName = reader.readLine();
        System.out.print("输入密码: ");
        String password = reader.readLine();
        System.out.print("输入信息: ");
        String message = reader.readLine();

        System.out.println("\n选择社交平台：\n" + "1 - 脸书\n" + "2 - 推特");
        int choice = Integer.parseInt(reader.readLine());
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);

    }

}
