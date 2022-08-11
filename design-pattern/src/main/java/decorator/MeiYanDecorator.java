package decorator;

/**
 * @author
 * @time 2022/8/11 21:43
 * @Description- 美颜装饰器
 */
public class MeiYanDecorator implements TikTokDecorator {

    private ManTikTok manTikTok;

    public MeiYanDecorator(ManTikTok manTikTok){
        this.manTikTok = manTikTok;
    }

    @Override
    public void tiktok(){
        enable();
        manTikTok.tiktok();
    }


    /**
     * 增强功能
     */
    @Override
    public void enable() {
        System.out.println("看美女。。。。");
    }
}
