package 行为设计模式.迭代器模式.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Description:
 *          社交档案
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public class Profile {

    private String name;
    private String email;
    private Map<String, List<String>> contacts = new HashMap<>();

    /**
     * @Description:
     *          模拟档案集合，
     * @Author Zepp Deng [2021-01-18 17:18]
     * @param email
     * @param name
     * @param contacts
     * @Return Profile
     */
    public Profile(String email, String name, String ...contacts){
        this.email = email;
        this.name = name;
        for(String contact : contacts){
            String[] parts = contact.split(":");
            String contactType = "friend", contactEmail;
            if (parts.length == 1){
                contactEmail = parts[0];
            }else {
                contactType = parts[0];
                contactEmail = parts[1];
            }
            if (!this.contacts.containsKey(contactType)){
                this.contacts.put(contactType,new ArrayList<>());
            }
            this.contacts.get(contactType).add(contactEmail);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    /**
     * @Description:
     *          获取不同类型的人脉档案
     * @Author Zepp Deng [2021-01-18 15:55]
     * @param contactType
     * @Return List<String>
     */
    public List<String> getContacts(String contactType){
        if (!this.contacts.containsKey(contactType)){
            this.contacts.put(contactType,new ArrayList<>());
        }
        return contacts.get(contactType);
    }

}
