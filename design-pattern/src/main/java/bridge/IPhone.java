package bridge;

/**
 * @author
 * @time 2022/8/10 21:51
 * @Description- TODO
 */
public class IPhone extends AbstractPhone {
    @Override
    String getPhone() {
        return "IPhone" + sale.getSaleInfo();
    }
}
