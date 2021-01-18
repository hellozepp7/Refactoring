package 行为设计模式.迭代器模式.social_networks;

import 行为设计模式.迭代器模式.iterators.FacebookIterator;
import 行为设计模式.迭代器模式.iterators.ProfileIterator;
import 行为设计模式.迭代器模式.profile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Description:
 *
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public class Facebook implements SocialNetwork{
    private List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    /**
     * @Description:
     *          创建查询朋友关系档案的迭代器
     * @Author Zepp Deng [2021-01-18 16:25]
     * @param profileEmail
     * @Return ProfileIterator
     */
    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this,"friends",profileEmail);
    }

    /**
     * @Description:
     *          创建查询同事关系档案的迭代器
     * @Author Zepp Deng [2021-01-18 16:25]
     * @param profileEmail
     * @Return ProfileIterator
     */
    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this,"coworkers",profileEmail);
    }

    /**
     * @Description:
     *          查询该email下制定类型的关系档案集合
     * @Author Zepp Deng [2021-01-18 16:49]
     * @param profileEmail
     * @param contactType
     * @Return List<String>
     */
    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
        //模拟网络延迟
        simulateNetworkLatency();
        Profile profile = findProfile(profileEmail);
        if (null != profile){
            return profile.getContacts(contactType);
        }
        return null;
    }

    /**
     * @Description:
     *          查询该email下所有档案
     * @Author Zepp Deng [2021-01-18 16:50]
     * @param profileEmail
     * @Return Profile
     */
    public Profile requestProfileFromFacebook(String profileEmail) {
        //模拟网络延迟
        simulateNetworkLatency();
        return findProfile(profileEmail);
    }

    /**
     * @Description:
     *          查询该email的档案，未区分类型
     * @Author Zepp Deng [2021-01-18 16:48]
     * @param profileEmail
     * @Return Profile
     */
    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
