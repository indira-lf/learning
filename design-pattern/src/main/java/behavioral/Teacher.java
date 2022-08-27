package behavioral;

/**
 * @author
 * @time 2022/8/26 22:47
 * @Description- TODO
 */
public class Teacher {

    //下一个处理的老师
    private Teacher next;

    private String name;

    public Teacher(String name){
        this.name = name;
    }

    void handleRequest(){
        System.out.println(this+"正在处理...");
        if (next != null) {
            next.handleRequest();
        }
    }

    public Teacher getNext() {
        return next;
    }

    public void setNext(Teacher next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "next=" + next +
                ", name='" + name + '\'' +
                '}';
    }
}
