package 行为设计模式.迭代器模式.social_networks;

import 行为设计模式.迭代器模式.iterators.ProfileIterator;

/**
 * <pre>
 * Description:
 *          定义通用的社交网络接口
 *          集合接口必须声明一个用于生成迭代器的工厂方法。如果程序中有不同类型的迭代器，也可以声明多个方法
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public interface SocialNetwork {

    // 迭代器创建朋友关系代码
    ProfileIterator createFriendsIterator(String profileEmail);

    // 迭代器创建同事关系代码
    ProfileIterator createCoworkersIterator(String profileEmail);
}
