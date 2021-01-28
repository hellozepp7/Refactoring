package 行为设计模式.模版方法模式.networks;

/**
 * <pre>
 * Description:
 *          基础社交网络类
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public abstract class Network {

    String userName;
    String passWord;

    /**
     * @Description:
     *          登陆账号并发送消息
     * @Author Zepp Deng [2021-01-25 17:47]
     * @param message
     * @Return boolean
     */
    public boolean post(String message){
        if (logIn(this.userName,this.passWord)){
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean sendData(byte[] data);

    protected abstract void logOut();

    protected abstract boolean logIn(String userName, String passWord);
}
