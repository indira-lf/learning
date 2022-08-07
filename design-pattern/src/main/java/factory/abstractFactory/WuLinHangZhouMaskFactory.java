package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 19:02
 * @Description- TODO
 */
public class WuLinHangZhouMaskFactory extends  WuLinMaskFactory{

    @Override
    AbstractMask newMask() {
        return new CommonMask();
    }
}
