package visitor;

/**
 * @author
 * @time 2022/8/25 7:14
 * @Description- 小爱机器人
 */
public class XiaoAi {
    private CPU cpu = new CPU("wu");
    private Disk disk = new Disk("wu");

    void answerQuestion() {
        cpu.work();
        disk.work();
    }

    public void acceptUpdatePackage(Vistor vistor) {

        //访问模式
        vistor.visitCPU(cpu);
        vistor.visitDisk(disk);
    }
}
