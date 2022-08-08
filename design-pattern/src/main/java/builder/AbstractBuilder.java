package builder;

/**
 * @author
 * @time 2022/8/8 20:42
 * @Description- 抽象建造者
 */
public abstract class AbstractBuilder {

    Phone phone;
    abstract AbstractBuilder customCpu(String cpu);
    abstract AbstractBuilder customMem(String mem);
    abstract AbstractBuilder customDisk(String disk);
    abstract AbstractBuilder customCam(String cam);

    Phone getProduct(){
        return phone;
    }
}
