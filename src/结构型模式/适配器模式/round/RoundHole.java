package 结构型模式.适配器模式.round;

/**
 * <pre>
 * Description:
 *          圆孔
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class RoundHole {

    //半径
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * @Description:
     *          是否适配
     * @Author Zepp Deng [2021-01-08 16:57]
     * @param peg
     * @Return boolean
     */
    public boolean fits(RoundPeg peg){
        return radius >= peg.getRadius();
    }

}
