package template;

/**
 * @author
 * @time 2022/8/17 7:27
 * @Description- TODO
 */
public class AutoCookMachine extends CookTemplate {
    @Override
    public void addFood() {
        System.out.println("加番茄...");
        System.out.println("加鸡蛋...");
    }

    @Override
    public void addSalt() {
        System.out.println("加点盐...");
    }
}
