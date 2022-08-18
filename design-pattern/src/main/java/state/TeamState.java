package state;

/**
 * @author
 * @time 2022/8/18 22:21
 * @Description- 抽象状态
 */
public interface TeamState {

    // 玩游戏
    void playGame();

    //下一个状态
    TeamState next();
}
