package bridge;

/**
 * @author
 * @time 2022/8/10 21:44
 * @Description- 抽象手机类
 */
public abstract class AbstractPhone {

    AbstractSale sale; // 分离渠道【桥接的关注点】

    abstract String getPhone();

    public void setSale(AbstractSale sale) {
        this.sale = sale;
    }
}
