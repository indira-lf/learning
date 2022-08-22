package command;

/**
 * @author
 * @time 2022/8/22 22:05
 * @Description- TODO
 */
public class OnlineCommand implements Command {

    private FengReceiver receiver = new FengReceiver();

    @Override
    public void execute() {
        System.out.println("我要去上课");
        receiver.online();
    }
}
