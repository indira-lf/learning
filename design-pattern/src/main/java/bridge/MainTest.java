package bridge;

/**
 * @author
 * @time 2022/8/10 21:51
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        //iPhone.setSale(new OfflineSale("线下",99999));
        iPhone.setSale(new OnlineSale("线上",9999));

        String phone = iPhone.getPhone();
        System.out.println(phone);
    }
}
