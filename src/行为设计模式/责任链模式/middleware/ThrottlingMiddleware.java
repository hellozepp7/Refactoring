package 行为设计模式.责任链模式.middleware;

/**
 * <pre>
 * Description:
 *           责任链处理者A
 *           检查请求数量限制
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class ThrottlingMiddleware extends Middleware {

    //每分钟请求数量
    private int requestPerMinute;
    //请求数量
    private int request;
    //当前时间
    private long currentTime;

    /**
     * @Description:
     *         初始化每分钟请求数与当前时间
     * @Author Zepp Deng [2021-01-08 11:23]
     * @param requestPerMinute
     * @Return ThrottlingMiddleware
     */
    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password) {
        System.out.println("A校验请求数量限制");
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        //调用下一个处理者
        return checkNext(email, password);
    }
}
