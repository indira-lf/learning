package factory.factoryMethod;

/**
 * @author
 * @time 2022/8/7 17:21
 * @Description- TODO
 */
public class WuLinVanCarFactory extends AbstractCarFactory{
    @Override
    public AbstractCat newCar() {
        return new VanCar();
    }
}
