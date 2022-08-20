package observer;

/**
 * @author
 * @time 2022/8/21 7:36
 * @Description- 抖音主播
 */
public abstract class AbstractTikToker {

    //添加粉丝
    abstract void addFans(AbstractFans fans);

    //通知粉丝
    abstract void notifyFans(String msg);
}
