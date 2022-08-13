package proxy.statics;

/**
 * @author
 * @time 2022/8/13 13:27
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        TikTokProxy proxy = new TikTokProxy(new FengTikTok());
        proxy.tiktok();
    }
}
