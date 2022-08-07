package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 19:12
 * @Description- TODO
 */
public abstract class WuLinMaskFactory extends WuLinFactory{
    @Override
    AbstractCat newCar() {
        return null;
    }

    abstract AbstractMask newMask();
}
