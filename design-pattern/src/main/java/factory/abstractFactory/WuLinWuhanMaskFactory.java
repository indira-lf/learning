package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 19:01
 * @Description- TODO
 */
public class WuLinWuhanMaskFactory extends WuLinMaskFactory{

    @Override
    AbstractMask newMask() {
        return new N95Mask();
    }
}
