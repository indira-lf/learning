package command;

/**
 * @author
 * @time 2022/8/22 22:08
 * @Description- 命令调用者（发起者）
 */
public class TeacherTongInvoker {

    Command command;

    public void call() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
