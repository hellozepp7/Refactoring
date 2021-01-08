package 行为设计模式.责任链模式.middleware;

/**
 * <pre>
 * Description:
 *          基础验证接口
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public abstract class Middleware {

    private Middleware next;

    public Middleware linkWith(Middleware next){
        this.next = next;
        return next;
    }

    /**
     * @Description:
     *          不同责任链处理类实现各自检查方法
     * @Author Zepp Deng [2021-01-08 11:22]
     * @param email
     * @param password
     * @Return boolean
     */
    public abstract boolean check(String email, String password);

    /**
     * @Description:
     *          根据责任链一直向下调用check方法
     *          即执行所以处理者
     * @Author Zepp Deng [2021-01-08 10:53]
     * @param email
     * @param password
     * @Return boolean
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }

}
