package factory.simpleFactory;

/**
 * @author
 * @time 2022/8/7 16:49
 * @Description- 简单工厂
 * 1、产品数极少
 */
public class WuLinSimpleFactory {
    public AbstractCat newCar(String type) {
        if ("var".equals(type)){
            return new VanCar();
        } else if ("mini".equals(type)){
            return new MiniCar();
        }

        //更多的产品，违反开闭原则，应该直接扩展出一个类来造
        return null;
    }
}
