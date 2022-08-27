package behavioral;

/**
 * @author
 * @time 2022/8/26 22:49
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Teacher lei = new Teacher("Lei");
        Teacher feng = new Teacher("Feng");
        Teacher li = new Teacher("Li");

        lei.setNext(feng);
        feng.setNext(li);

        lei.handleRequest();
    }
}
