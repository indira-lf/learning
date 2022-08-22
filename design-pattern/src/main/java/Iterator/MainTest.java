package Iterator;

/**
 * @author
 * @time 2022/8/22 23:01
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        MaYuCheng cheng = new MaYuCheng();

        cheng.likeYou("a");
        cheng.likeYou("b");
        cheng.likeYou("c");

        BeautifulMan.Itr iterator = cheng.getIterator();
        System.out.println(iterator.firstLove());
        System.out.println(iterator.current());
    }
}
