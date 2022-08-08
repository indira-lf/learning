package builder;

/**
 * @author
 * @time 2022/8/8 20:48
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractBuilder builder = new XiaomiBuilder();
//        builder.customCpu("骁龙88");
//        builder.customDisk("1T");
//        builder.customCam("2Y");
//        builder.customMem("16G");

        // 链式调用
        builder.customCpu("骁龙870").customMem("12G").customCam("1Y").customDisk("512G");

        Phone phone = builder.getProduct();
        System.out.println(phone.toString());
    }
}
