package flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author
 * @time 2022/8/16 21:06
 * @Description- 享元工厂
 */
public class ZuDao {

    private static Map<String,AbstractWaitressFlyweight> pool = new HashMap<>();

    /*
        池子中有对象
     */
    static {
        BeautifulWaitress beautifulWaitress = new BeautifulWaitress("9527","张三","18");
        BeautifulWaitress waitress = new BeautifulWaitress("9528","李四","18");
        pool.put(beautifulWaitress.id,beautifulWaitress);
        pool.put(waitress.id,waitress);
    }

    public void addWaitress(AbstractWaitressFlyweight waitressFlyweight) {
        pool.put(UUID.randomUUID().toString(),waitressFlyweight);
    }

    public static AbstractWaitressFlyweight getWaitress(String id) {
        AbstractWaitressFlyweight flyweight = pool.get(id);
        if (flyweight == null) {
            for (AbstractWaitressFlyweight value : pool.values()) {
                if (value.isCanService()){
                    return value;
                }
            }

            return null;
        } else {
            if (!flyweight.isCanService()){
                return null;
            }
        }

        return flyweight;
    }
}
