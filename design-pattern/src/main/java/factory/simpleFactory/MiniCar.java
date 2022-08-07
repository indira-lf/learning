package factory.simpleFactory;

/**
 * @author
 * @time 2022/8/7 16:54
 * @Description- TODO
 */
public class MiniCar extends AbstractCat{

    public MiniCar(){
        this.engine = "四缸水平对置发动机";
    }
    @Override
    public void run() {
        System.out.println(engine + "--->嘟嘟嘟...");
    }


}
