package 行为设计模式.迭代器模式.iterators;

import 行为设计模式.迭代器模式.profile.Profile;
import 行为设计模式.迭代器模式.social_networks.LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Description:
 *           在领英档案上实现迭代
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public class LinkedInIterator implements ProfileIterator{

    private LinkedIn linkedIn;
    private String type;
    private String email;
    //迭代器对象会独立于其他迭代器来对集合进行遍历。因此它必须保存迭代器的状态
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> contacts = new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    /**
     * @Description:
     *          遍历查询是否还有元素在集合中
     * @Author Zepp Deng [2021-01-18 17:36]
     * @Return boolean
     */
    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    private void lazyLoad() {
        if (emails.size() == 0) {
            List<String> profiles = linkedIn.requestRelatedContactsFromLinkedInAPI(this.email, this.type);
            for (String profile : profiles) {
                this.emails.add(profile);
                this.contacts.add(null);
            }
        }
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }
        String friendEmail = emails.get(currentPosition);
        Profile friendContact = contacts.get(currentPosition);
        if (null == friendContact){
            friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
            contacts.set(currentPosition,friendContact);
        }
        currentPosition++;
        return friendContact;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
