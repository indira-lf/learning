package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 19:11
 * @Description- TODO
 */
public abstract class WuLinCarFactory extends WuLinFactory{
    abstract AbstractCat newCar();

    @Override
    AbstractMask newMask() {
        return null;
    }
}
