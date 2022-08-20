package mediator;

/**
 * @author
 * @time 2022/8/20 21:28
 * @Description- TODO
 */
public class HU8778 extends Captain {
    ControlTower controlTower;

    public void setControlTower(ControlTower controlTower) {
        this.controlTower = controlTower;
    }

    @Override
    void fly() {
        System.out.println("HU8778请求起飞...");
        controlTower.acceptRequest(this,"fly");
    }

    @Override
    void land() {
        System.out.println("HU8778请求降落...");
        controlTower.acceptRequest(this,"land");
    }

    @Override
    void success() {
        System.out.println("完成...");
        controlTower.acceptRequest(this,"success");
    }
}
