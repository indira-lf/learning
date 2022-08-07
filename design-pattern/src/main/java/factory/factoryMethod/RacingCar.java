package factory.factoryMethod;

/**
 * @author
 * @time 2022/8/7 17:16
 * @Description- TODO
 */
public class RacingCar extends AbstractCat{

    public RacingCar(){
        this.engine = "v8发动机";
    }

    @Override
    public void run() {
        System.out.println(engine+"嗖~~~");
    }
}
