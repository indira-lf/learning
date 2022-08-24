package visitor;

/**
 * @author
 * @time 2022/8/25 7:15
 * @Description- 硬件 抽象元素类
 */
public abstract class Hardware {
    String command;

    public Hardware(String command) {
        this.command = command;
    }

    // 收到命令后继续工作
    public void work(){
        System.out.println(command);
    }

    // 定义接受软件升级包的方法。这个方法应该具体硬件去实现
    abstract public void accept(Vistor vistor);
}
