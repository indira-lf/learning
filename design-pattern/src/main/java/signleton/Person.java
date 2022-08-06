package signleton;

/**
 * @author
 * @time 2022/8/6 22:42
 * @Description- TODO
 */
public class Person {
    private String name;
    private String age;

    private static volatile Person instance;

    //恶汉式
//    private final static Person instance = new Person();

    /**
     * 私有构造器
     */
    private Person() {
        System.out.println("创建person");
    }

    /**
     * 懒汉式
     * @return
     *
     * public static synchronized Person getInstance() 锁太大
     *
     * 双重检测+内存可见性(volatile)
     */
    public static Person getInstance(){
        if (instance == null){
            synchronized (Person.class){
                if (instance == null){
                    Person person = new Person();
                    instance = person;
                }
            }
        }
        return instance;
    }

    /**
     * 恶汉式
     * @return
     */
    public static Person getInstance2(){
        return instance;
    }
}
