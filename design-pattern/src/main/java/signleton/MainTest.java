package signleton;

import java.util.Map;
import java.util.Properties;

/**
 * @author
 * @time 2022/8/6 22:42
 * @Description- 单例模式测试类
 */
public class MainTest {
    public static void main(String[] args) {
        Person person1 = Person.getInstance();

        Person person2 = Person.getInstance();

        System.out.println(person1 == person2);

        //获取系统属性
        Properties properties = System.getProperties();
        System.out.println(properties);
        //获取系统的环境变量
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);
    }
}
