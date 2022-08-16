package flyweight;

import lombok.AllArgsConstructor;

/**
 * @author
 * @time 2022/8/16 21:02
 * @Description- 具体享元类
 */
@AllArgsConstructor
public class BeautifulWaitress extends AbstractWaitressFlyweight {
    /**
     * 工号
     */
    String id;
    /**
     * 名字
     */
    String name;
    /**
     * 年龄
     */
    String age;

    @Override
    void service() {
        System.out.println("工号："+id+";"+name+" "+age+"正在为您服务...");

        this.canService = false;
    }

    @Override
    void end() {
        System.out.println("工号："+id+";"+name+" "+age+"服务结束...");
        this.canService = true;
    }
}
