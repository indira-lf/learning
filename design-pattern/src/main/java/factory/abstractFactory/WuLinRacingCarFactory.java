package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 18:56
 * @Description- 具体工厂
 */
public class WuLinRacingCarFactory extends  WuLinCarFactory{
    @Override
    AbstractCat newCar() {
        return new RacingCar();
    }
}
