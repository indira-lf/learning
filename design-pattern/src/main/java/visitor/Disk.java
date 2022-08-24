package visitor;

/**
 * @author
 * @time 2022/8/25 7:23
 * @Description- TODO
 */
public class Disk extends Hardware {

    public Disk(String command) {
        super(command);
    }

    @Override
    public void work() {
        System.out.println("disk:"+command);
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.visitDisk(this);
    }
}
