package 行为设计模式.迭代器模式.iterators;

import 行为设计模式.迭代器模式.profile.Profile;
import 行为设计模式.迭代器模式.social_networks.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Description:
 *           在 Facebook 档案上实现迭代
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public class FacebookIterator implements ProfileIterator{

    private Facebook facebook;
    private String type;
    private String email;
    //迭代器对象会独立于其他迭代器来对集合进行遍历。因此它必须保存迭代器的状态
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> profiles = new ArrayList<>();

    public FacebookIterator(Facebook facebook, String type, String email) {
        this.facebook = facebook;
        this.type = type;
        this.email = email;
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    private void lazyLoad() {
        if (emails.size() == 0){
            List<String> profiles = facebook.requestProfileFriendsFromFacebook(this.email, this.type);
            for (String profile : profiles){
                this.emails.add(profile);
                this.profiles.add(null);
            }
        }
    }

    /**
     * @Description:
     *          每个具体迭代器类都会自行实现通用迭代器接口
     * @Author Zepp Deng [2021-01-18 16:08]
     * @Return Profile
     */
    @Override
    public Profile getNext() {
        if (!hasNext()){
            return null;
        }
        String friendEmail = emails.get(currentPosition);
        Profile friendProfile = profiles.get(currentPosition);
        if (friendProfile == null){
            friendProfile = facebook.requestProfileFromFacebook(friendEmail);
            profiles.add(friendProfile);
        }
        currentPosition++;
        return friendProfile;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
