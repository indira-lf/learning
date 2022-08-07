package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 19:00
 * @Description- TODO
 */
public class WuLinVanCarFactory extends WuLinCarFactory{
    @Override
    AbstractCat newCar() {
        return new VanCar();
    }

}
