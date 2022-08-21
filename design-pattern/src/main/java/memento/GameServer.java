package memento;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @time 2022/8/22 7:06
 * @Description- TODO
 */
public class GameServer {
    Map<Integer,GameRecord> records = new HashMap<>();

    void add(GameRecord gameRecord) {
        records.put(gameRecord.id,gameRecord);
    }

    FengGamer getRecord(Integer id) throws Exception {
        GameRecord gameRecord = records.get(id);
        //获取备忘录里面的内容以后还要逆转
        FengGamer fengGamer = new FengGamer();
        BeanUtils.copyProperties(fengGamer,gameRecord);
        return fengGamer;
    }
}
