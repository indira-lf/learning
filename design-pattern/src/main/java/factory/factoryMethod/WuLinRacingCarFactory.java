package factory.factoryMethod;

/**
 * @author
 * @time 2022/8/7 17:22
 * @Description- TODO
 */
public class WuLinRacingCarFactory extends AbstractCarFactory{
    @Override
    public AbstractCat newCar() {
        return new RacingCar();
    }
}
