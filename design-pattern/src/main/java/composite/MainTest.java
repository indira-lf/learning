package composite;

/**
 * @author
 * @time 2022/8/14 21:26
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        Menu root = new Menu(1, "系统管理");
        Menu role = new Menu(2, "角色管理");
        root.addChildMenu(role);
        role.addChildMenu(new Menu(6,"固定角色"));
        role.addChildMenu(new Menu(7,"临时授权"));

        Menu roleMan = new Menu(3,"用户管理");
        root.addChildMenu(roleMan);
        roleMan.addChildMenu(new Menu(4,"临时用户"));
        roleMan.addChildMenu(new Menu(5,"注册用户"));

        root.printMenu();
    }
}
