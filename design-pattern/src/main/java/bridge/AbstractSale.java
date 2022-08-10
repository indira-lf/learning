package bridge;

/**
 * @author
 * @time 2022/8/10 21:46
 * @Description- 抽象销售渠道
 */
public abstract class AbstractSale {

    private String type;
    private Integer price;
    public AbstractSale(String type,Integer price) {
        this.price = price;
        this.type = type;
    }

    String getSaleInfo() {
        return "渠道：" + type + "===>" + "价格:"+price;
    }
}
