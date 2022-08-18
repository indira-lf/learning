package state;

/**
 * @author
 * @time 2022/8/18 22:24
 * @Description- 度假状态
 */
public class VocationState implements TeamState {
    @Override
    public void playGame() {
        System.out.println("度假ing...");
    }

    @Override
    public TeamState next() {
        System.out.println("null");
        return new MatchState();
    }
}
