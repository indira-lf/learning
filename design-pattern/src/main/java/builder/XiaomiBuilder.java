package builder;

/**
 * @author
 * @time 2022/8/8 20:45
 * @Description- TODO
 */
public class XiaomiBuilder extends AbstractBuilder{

    public XiaomiBuilder() {
        phone = new Phone();
    }

    @Override
    AbstractBuilder customCpu(String cpu) {
        phone.cpu = cpu;
        return this;
    }

    @Override
    AbstractBuilder customMem(String mem) {
        phone.mem = "12G";
        return this;
    }

    @Override
    AbstractBuilder customDisk(String disk) {
        phone.disk = disk;
        return this;
    }

    @Override
    AbstractBuilder customCam(String cam) {
        phone.cam = cam;
        return this;
    }
}
