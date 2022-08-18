package state;

/**
 * @author
 * @time 2022/8/18 22:26
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        SKTTeam sktTeam = new SKTTeam();
        BeefNoodleState state = new BeefNoodleState();
        sktTeam.setTeamState(state);

        sktTeam.startGame();
        sktTeam.nextState();
        sktTeam.startGame();
        sktTeam.nextState();
        sktTeam.startGame();
        sktTeam.nextState();
    }
}
