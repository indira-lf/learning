package proxy.statics;

/**
 * @author
 * @time 2022/8/13 13:22
 * @Description- 代理对象和被代理对象实现一个接口
 */
public class TikTokProxy implements ManTikTok {

    private ManTikTok manTikTok; //被代理对象

    public TikTokProxy(ManTikTok manTikTok) {
        this.manTikTok = manTikTok;
    }

    @Override
    public void tiktok() {
        System.out.println("渲染直播间....");
        System.out.println("666");
        manTikTok.tiktok();
        System.out.println("eueueu");
    }
}
