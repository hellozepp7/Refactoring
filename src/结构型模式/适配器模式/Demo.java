package 结构型模式.适配器模式;

import 结构型模式.适配器模式.adapters.SquarePegAdapter;
import 结构型模式.适配器模式.round.RoundHole;
import 结构型模式.适配器模式.round.RoundPeg;
import 结构型模式.适配器模式.square.SquarePeg;

/**
 * <pre>
 * Description:
 *          适配器模式，构造型模式
 * @author Zepp Deng
 * @date 2021/1/8
 * </pre>
 */
public class Demo {

    public static void main(String[] args) {

        //圆孔
        RoundHole hole = new RoundHole(5);
        //圆钉
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("圆钉适配圆孔成功");
        }

        //方钉小
        SquarePeg smallSqPeg = new SquarePeg(2);
        //方钉大
        SquarePeg largeSqPeg = new SquarePeg(20);

        //方钉转圆钉适配器
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);

        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("小方钉适配圆孔成功");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("大方钉适配圆孔失败");
        }
    }
}
