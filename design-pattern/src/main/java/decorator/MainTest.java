package decorator;

/**
 * @author
 * @time 2022/8/11 21:51
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        MeiYanDecorator decorator = new MeiYanDecorator(new LeiTikTok());
        decorator.tiktok();
    }
}
