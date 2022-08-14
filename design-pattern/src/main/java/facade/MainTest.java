package facade;

/**
 * @author
 * @time 2022/8/15 7:38
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        WeiXinFacade weiXinFacade = new WeiXinFacade();
        weiXinFacade.handle("张三");
    }
}
