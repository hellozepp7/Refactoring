package 结构型模式.适配器模式.round;

/**
 * <pre>
 * Description:
 *          圆钉
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class RoundPeg {

    //半径
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
