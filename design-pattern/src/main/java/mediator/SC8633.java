package mediator;

/**
 * @author
 * @time 2022/8/20 21:31
 * @Description- TODO
 */
public class SC8633 extends Captain {

    ControlTower controlTower;

    public void setControlTower(ControlTower controlTower) {
        this.controlTower = controlTower;
    }

    @Override
    void fly() {
        System.out.println("SC8633请求起飞...");
        controlTower.acceptRequest(this,"fly");
    }

    @Override
    void land() {
        System.out.println("SC8633请求降落...");
        controlTower.acceptRequest(this,"land");
    }

    @Override
    void success() {
        System.out.println("完成...");
        controlTower.acceptRequest(this,"success");
    }
}
