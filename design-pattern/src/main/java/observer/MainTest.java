package observer;

/**
 * @author
 * @time 2022/8/21 7:43
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        MMTikToker mmTikToker = new MMTikToker();
        RobotFans robotFans = new RobotFans();
        robotFans.follow(mmTikToker);
        HumanFans humanFans = new HumanFans();
        humanFans.follow(mmTikToker);
        mmTikToker.startSell();

        mmTikToker.endSell();
    }
}
