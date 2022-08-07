package prototype;

/**
 * @author
 * @time 2022/8/7 7:58
 * @Description- 原型模式
 */
public class MainTest {
    public static void main(String[] args) throws CloneNotSupportedException {

        MyBatis myBatis = new MyBatis();

        User user1 = myBatis.getUser("张三");
        user1.setUserName("李四");
        User user2 = myBatis.getUser("张三");
        User user3 = myBatis.getUser("张三");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
