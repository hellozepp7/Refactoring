package 结构型模式.适配器模式.adapters;

import 结构型模式.适配器模式.round.RoundPeg;
import 结构型模式.适配器模式.square.SquarePeg;

/**
 * <pre>
 * Description:
 *          方钉到圆孔的适配器
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class SquarePegAdapter extends RoundPeg {

    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    /**
     * @Description:
     *          方钉转圆钉
     * @Author Zepp Deng [2021-01-08 17:28]
     * @Return double
     */
    @Override
    public double getRadius() {
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }

}
