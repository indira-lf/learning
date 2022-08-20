package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @time 2022/8/21 7:38
 * @Description- TODO
 */
public class MMTikToker extends AbstractTikToker {

    List<AbstractFans> fansList = new ArrayList<>();

    @Override
    void addFans(AbstractFans fans) {
        fansList.add(fans);
    }

    @Override
    void notifyFans(String msg) {
        for (AbstractFans fans : fansList) {
            fans.acceptMsg(msg);
        }
    }

    void startSell() {
        System.out.println("MM...开始卖货");
        notifyFans("开始卖货了...");
    }

    void endSell() {
        System.out.println("MM...结束卖货");
        notifyFans("结束卖货了...");
    }
}
