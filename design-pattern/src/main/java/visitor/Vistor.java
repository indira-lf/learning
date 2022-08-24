package visitor;

/**
 * @author
 * @time 2022/8/25 7:20
 * @Description- 升级包的接口
 */
public interface Vistor {
    void visitDisk(Disk disk);

    void visitCPU(CPU cpu);
}
