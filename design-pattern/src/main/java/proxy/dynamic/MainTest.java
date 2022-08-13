package proxy.dynamic;

/**
 * @author
 * @time 2022/8/13 13:33
 * @Description- jdk动态代理，要求被代理对象必须有接口
 */
public class MainTest {
    public static void main(String[] args) {

        ManTikTok proxy = JDKTikTokProxy.getProxy(new FengTikTok());

        proxy.tiktok();
    }
}
