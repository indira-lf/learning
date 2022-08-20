package observer;

/**
 * @author
 * @time 2022/8/21 7:44
 * @Description- TODO
 */
public class HumanFans extends AbstractFans {
    @Override
    void acceptMsg(String msg) {
        System.out.println("主播说："+msg);
    }
}
