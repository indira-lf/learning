package observer;

import java.util.List;

/**
 * @author
 * @time 2022/8/21 7:38
 * @Description- 抽象观察者
 */
public abstract class AbstractFans {

//    List<AbstractTikToker> tikTokers;

    abstract void acceptMsg(String msg);

    void follow(AbstractTikToker tikToker) {
        tikToker.addFans(this);
    }
}
