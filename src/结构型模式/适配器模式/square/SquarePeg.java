package 结构型模式.适配器模式.square;

/**
 * <pre>
 * Description:
 *          方钉
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class SquarePeg {

    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth(){
        return width;
    }

    /**
     * @Description:
     *          获取面积
     * @Author Zepp Deng [2021-01-08 17:04]
     * @Return double
     */
    public double getSquare(){
        return Math.pow(this.width, 2);
    }

}
