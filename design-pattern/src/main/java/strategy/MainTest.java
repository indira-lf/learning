package strategy;

/**
 * @author
 * @time 2022/8/18 21:43
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        TeamGNR teamGNR = new TeamGNR();
        teamGNR.setGameStrategy(new UziStrategy());
        teamGNR.startGame();
    }
}
