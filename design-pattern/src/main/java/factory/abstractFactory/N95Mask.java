package factory.abstractFactory;

/**
 * @author
 * @time 2022/8/7 17:44
 * @Description- 具体产品
 */
public class N95Mask extends AbstractMask{

    public N95Mask() {
        this.price = 15;
    }

    @Override
    public void protectedMe() {
        System.out.println("N95口罩超级贵");
    }
}
