package 行为设计模式.迭代器模式.spammer;

import 行为设计模式.迭代器模式.iterators.ProfileIterator;
import 行为设计模式.迭代器模式.profile.Profile;
import 行为设计模式.迭代器模式.social_networks.SocialNetwork;

/**
 * <pre>
 * Description:
 *          消息发送应用
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public class SocialSpammer {

    public SocialNetwork network;
    public ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    /**
     * @Description:
     *          遍历所有的该email下的朋友关系档案，并发送消息
     * @Author Zepp Deng [2021-01-18 17:44]
     * @param profileEmail
     * @param message
     */
    public void sendSpamToFriends(String profileEmail, String message){
        //创建朋友关系的迭代器
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()){
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    /**
     * @Description:
     *          遍历所有的该email下的同事关系档案，并发送消息
     * @Author Zepp Deng [2021-01-18 17:44]
     * @param profileEmail
     * @param message
     */
    public void sendSpamToCoworkers(String profileEmail, String message){
        //创建同事关系的迭代器
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()){
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    private void sendMessage(String email, String message) {
        System.out.println(email + message);
    }


}
