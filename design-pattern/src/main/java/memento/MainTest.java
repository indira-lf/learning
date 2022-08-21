package memento;

/**
 * @author
 * @time 2022/8/22 7:14
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        FengGamer fengGamer = new FengGamer();
        fengGamer.playGame();

        fengGamer.saveGameRecord();
    }
}
