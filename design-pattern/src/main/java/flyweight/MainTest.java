package flyweight;

/**
 * @author
 * @time 2022/8/16 21:18
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractWaitressFlyweight waitress1 = ZuDao.getWaitress("9527");
        waitress1.service();
        AbstractWaitressFlyweight waitress2 = ZuDao.getWaitress("9528");
        waitress2.service();
        AbstractWaitressFlyweight waitress3 = ZuDao.getWaitress("9527");
        if (waitress3 != null){
            waitress3.service();
        }
        waitress1.end();
        waitress2.end();
        if (waitress3 != null) {
            waitress3.end();
        }
    }
}
