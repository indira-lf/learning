package state;

/**
 * @author
 * @time 2022/8/18 22:25
 * @Description- 干饭状态
 */
public class BeefNoodleState implements TeamState {
    @Override
    public void playGame() {
        System.out.println("干饭人....");
    }

    @Override
    public TeamState next() {
        System.out.println("VocationState");
        return new VocationState();
    }
}
