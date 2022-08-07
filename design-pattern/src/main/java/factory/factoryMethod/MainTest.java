package factory.factoryMethod;

/**
 * @author
 * @time 2022/8/7 16:32
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractCarFactory carFactory = new WuLinRacingCarFactory();
        AbstractCat abstractCat = carFactory.newCar();
        abstractCat.run();

        carFactory = new WuLinMiniCarFactory();
        AbstractCat abstractCat1 = carFactory.newCar();
        abstractCat1.run();
    }
}
