package state;

/**
 * @author
 * @time 2022/8/18 22:22
 * @Description- 竞赛状态
 */
public class MatchState implements TeamState {
    @Override
    public void playGame() {
        System.out.println("全力以赴打比赛...");
    }

    @Override
    public TeamState next() {
        System.out.println("BeefNoodleState");
        return new BeefNoodleState();
    }
}
