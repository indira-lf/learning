package mediator;

/**
 * @author
 * @time 2022/8/20 21:42
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        HU8778 hu8778 = new HU8778();
        SC8633 sc8633 = new SC8633();

        ControlTower controlTower = new ControlTower();
        hu8778.setControlTower(controlTower);
        sc8633.setControlTower(controlTower);
        hu8778.fly();
        sc8633.fly();
    }
}
