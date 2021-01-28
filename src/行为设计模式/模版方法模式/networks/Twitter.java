package 行为设计模式.模版方法模式.networks;

/**
 * <pre>
 * Description:
 *          另一个社交网络
 * @author Zepp Deng
 * @date 2021/1/25
 * </pre>
 */
public class Twitter extends Network {

    public Twitter(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }


    @Override
    protected boolean logIn(String userName, String passWord) {
        System.out.println("\n检查账号信息：");
        System.out.println("名称: " + this.userName);
        System.out.print("密码: ");
        for (int i = 0; i < this.passWord.length(); i++) {
            System.out.print("*");
        }
        //模拟网络延时请求
        simulateNetworkLatency();
        System.out.println("\n\n登陆推特成功");
        return true;
    }

    /**
     * @Description:
     *          模拟网络延时请求
     * @Author Zepp Deng [2021-01-25 15:49]
     */
    private void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.println("Message: '" + new String(data) + "' was posted on Twitter");
        return true;
    }

    @Override
    protected void logOut() {

    }


}
