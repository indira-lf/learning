package prototype;

/**
 * @author
 * @time 2022/8/7 8:05
 * @Description- TODO
 */
public class User implements Cloneable {
    private String userName;

    private Integer age;

    private String email;

    public User() {
        System.out.println("创建对象");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = new User();
        user.setUserName(this.userName);
        user.setAge(this.age);
        user.setEmail(this.email);
        return user;
    }
}
