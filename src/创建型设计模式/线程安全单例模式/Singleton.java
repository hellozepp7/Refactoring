package 创建型设计模式.线程安全单例模式;

/**
 * <pre>
 * Description:
 *
 * @author Zepp Deng
 * @date 2021/1/18
 * </pre>
 */
public final class Singleton {

    //保存单例实例的成员变量必须被声明为静态类型
    private static volatile Singleton instance ;

    public String value;

    /**
     * @Description:
     *          私有构造函数,防止使用new运算符直接调用
     * @Author Zepp Deng [2021-01-18 11:56]
     * @param value
     * @Return Singleton
     */
    private Singleton(String value){
        this.value = value;
    }

    /**
     * @Description:
     *          不能用new来实例化对象，只能调用getInstance方法来得到对象
     * @Author Zepp Deng [2021-01-18 11:55]
     * @param value
     * @Return Singleton
     */
    public static Singleton getInstance(String value){
        if (null != instance){
            return instance;
        }
        //多线程可能会同时调用构建方法并获取多个单例类的实例
        //必须在创建首个单例对象时对线程进行同步
        synchronized (Singleton.class){
            if (null == instance){
                instance = new Singleton(value);
            }
            return instance;
        }
    }

}
