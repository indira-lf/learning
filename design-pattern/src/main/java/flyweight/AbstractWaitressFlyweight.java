package flyweight;

/**
 * @author
 * @time 2022/8/16 20:59
 * @Description- TODO
 */
public abstract class AbstractWaitressFlyweight {

    // 正在服务     享元的不可共享属性留给外部进行改变的接口
    abstract void service();
    // 服务完成     享元的不可共享属性留给外部进行改变的接口
    abstract void end();

    /**
     * 能否服务
     */
    boolean canService = true;

    public boolean isCanService() {
        return canService;
    }
}
