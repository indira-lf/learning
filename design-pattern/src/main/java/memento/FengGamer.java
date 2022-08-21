package memento;

import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Random;

/**
 * @author
 * @time 2022/8/22 6:54
 * @Description- TODO
 */
@Data
public class FengGamer {

    /**
     * 剩余金币
     */
    Integer coin;
    /**
     * 血量
     */
    Integer hp;
    /**
     * 蓝量
     */
    Integer mp;
    /**
     * 等级
     */
    Integer level;

    GameServer gameServer = new GameServer();

    /**
     * 保存游戏记录
     */
    void saveGameRecord() throws Exception {
        System.out.println("正在保存当前记录...");
        GameRecord gameRecord = new GameRecord();
        BeanUtils.copyProperties(gameRecord,this);
        gameServer.add(gameRecord);
    }

    /**
     * 从备忘录获取游戏历史存档
     */
    void getFromMemento() {
        System.out.println("获取历史存档信息...");
    }

    /**
     * 玩游戏
     */
    void playGame() {
        System.out.println("-------(“_”)------");
        int i = new Random().nextInt();
        coin = i;
        hp = i;
        mp = i;
        level = i;
    }

    /**
     * 退出游戏
     */
    void exitGame() throws Exception {
        System.out.println("退出&存档");
        saveGameRecord();
    }
}
