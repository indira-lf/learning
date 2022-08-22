package command;

/**
 * @author
 * @time 2022/8/22 22:18
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        TeacherTongInvoker invoker = new TeacherTongInvoker();
        invoker.setCommand(new WuHanTravelCommand());
        invoker.call();
    }
}
