package proxy.cglib;

import proxy.statics.ManTikTok;

/**
 * @author
 * @time 2022/8/13 14:04
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {

        FengTikTok fengTikTok = new FengTikTok();
        FengTikTok proxy = CgLibProxy.creatProxy(fengTikTok);
        proxy.tiktokhaha();
    }
}
