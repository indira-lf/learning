package memento;

import lombok.Data;

/**
 * @author
 * @time 2022/8/22 7:03
 * @Description- TODO
 */
@Data
public class GameRecord {
    /**
     * 代表生成记录的id
     */
    Integer id;
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

    public void getCurrent() {
        System.out.println( "GameRecord{" +
                "coin=" + coin +
                ", hp=" + hp +
                ", mp=" + mp +
                ", level=" + level +
                '}');
    }
}
