package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 17:46
 * @Description- TODO
 */
public class CommonMask extends AbstractMask{

    public CommonMask() {
        price = 1;
    }

    @Override
    public void protectedMe() {
        System.out.println("普通口罩请及时更换");

    }
}
