package proxy.statics;

/**
 * @author
 * @time 2022/8/13 13:27
 * @Description- 静态代理和装饰器几乎没有区别
 */
public class MainTest {
    public static void main(String[] args) {
        TikTokProxy proxy = new TikTokProxy(new FengTikTok());
        proxy.tiktok();
    }
}
