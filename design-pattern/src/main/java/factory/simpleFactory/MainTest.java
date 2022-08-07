package factory.simpleFactory;

/**
 * @author
 * @time 2022/8/7 16:32
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        WuLinSimpleFactory factory = new WuLinSimpleFactory();
        AbstractCat mini = factory.newCar("mini");
        AbstractCat var = factory.newCar("var");
        mini.run();
        var.run();
    }
}
