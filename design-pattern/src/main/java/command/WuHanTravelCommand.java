package command;

/**
 * @author
 * @time 2022/8/22 22:04
 * @Description- 武汉出差命令
 */
public class WuHanTravelCommand implements Command {

    private FengReceiver receiver = new FengReceiver();

    @Override
    public void execute() {
        System.out.println("我要出差旅游了...");
        receiver.travel();
    }
}
