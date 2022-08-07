package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 19:03
 * @Description- TODO
 * 抽象成接口：只有方法
 * 抽象成抽象类：有些属性要向下传递
 */
public class MainTest {
    public static void main(String[] args) {

        WuLinRacingCarFactory carFactory = new WuLinRacingCarFactory();
        AbstractCat abstractCat = carFactory.newCar();
        abstractCat.run();


        WuLinFactory wuLinFactory = new WuLinWuhanMaskFactory();

        AbstractMask abstractMask = wuLinFactory.newMask();
        abstractMask.protectedMe();

        wuLinFactory = new WuLinHangZhouMaskFactory();
        AbstractMask abstractMask1 = wuLinFactory.newMask();
        abstractMask1.protectedMe();
    }
}
