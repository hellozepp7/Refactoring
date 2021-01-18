package 行为设计模式.迭代器模式;

import 行为设计模式.迭代器模式.profile.Profile;
import 行为设计模式.迭代器模式.social_networks.Facebook;
import 行为设计模式.迭代器模式.social_networks.LinkedIn;
import 行为设计模式.迭代器模式.social_networks.SocialNetwork;
import 行为设计模式.迭代器模式.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * Description:
 *          迭代器模式，行为设计模式
 *          不暴露集合底层表现形式 （列表、 栈和树等） 的情况下遍历集合中所有的元素
 *          该例通过facebook和Linda两种方式遍历档案数据，档案集合为name,email与分类型集合的map三个属性
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public class Demo {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        //创建遍历接口
        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        } else {
            network = new Facebook(createTestProfiles());
        }
        //用于生成不同人物关系的迭代器
        SocialSpammer spammer = new SocialSpammer(network);
        //迭代器根据不同需求遍历集合
        spammer.sendSpamToFriends("anna.smith@bing.com",
                "这是朋友关系的档案");
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                "这是同事关系的档案");
    }

    /**
     * @Description:
     *          模拟数据，email为key，value以:分隔，左边是关系类型右边是关系email
     * @Author Zepp Deng [2021-01-18 17:06]
     * @Return List<Profile>
     */
    private static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }


}
