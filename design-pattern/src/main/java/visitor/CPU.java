package visitor;

/**
 * @author
 * @time 2022/8/25 7:21
 * @Description- TODO
 */
public class CPU extends Hardware {
    public CPU(String command) {
        super(command);
    }

    @Override
    public void work() {
        System.out.println("CPU:"+command);
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.visitCPU(this);
    }
}
