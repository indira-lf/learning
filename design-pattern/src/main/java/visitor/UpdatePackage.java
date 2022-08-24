package visitor;

/**
 * @author
 * @time 2022/8/25 7:32
 * @Description- TODO
 */
public class UpdatePackage implements Vistor {

    private String ext;

    public UpdatePackage(String ext) {
        this.ext = ext;
    }

    @Override
    public void visitDisk(Disk disk) {
        disk.command += ">> 联网存储" + ext;
    }

    @Override
    public void visitCPU(CPU cpu) {
        cpu.command += ">> 联网查询" + ext;
        //装饰模式

    }
}
