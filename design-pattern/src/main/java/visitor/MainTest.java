package visitor;

/**
 * @author
 * @time 2022/8/25 7:24
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        XiaoAi xiaoAi = new XiaoAi();
        xiaoAi.answerQuestion();

        UpdatePackage aPackage = new UpdatePackage("1");
        xiaoAi.acceptUpdatePackage(aPackage);
        xiaoAi.answerQuestion();
    }
}
