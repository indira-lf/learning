package factory.factoryMethod;

/**
 * @author
 * @time 2022/8/7 16:51
 * @Description- 具体产品
 */
public class VanCar extends AbstractCat {

    public VanCar(){
        this.engine = "单杆采油机";
    }

    @Override
    public void run() {
        System.out.println(engine+"--->哒哒哒...");
    }
}
