package adapter.clazz;

import adapter.MoviePlayer;
import adapter.Player;

/**
 * @author
 * @time 2022/8/9 22:14
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {

        MoviePlayer player = new MoviePlayer();

        JPMoviePlayerAdapter playerAdapter = new JPMoviePlayerAdapter(player);

        playerAdapter.play();
    }
}
