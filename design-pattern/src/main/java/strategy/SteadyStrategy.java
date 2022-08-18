package strategy;

/**
 * @author
 * @time 2022/8/18 21:41
 * @Description- 稳健策略
 */
public class SteadyStrategy implements GameStrategy {
    @Override
    public void warStrategy() {
        System.out.println("各路小心...即时支持...");
    }
}
