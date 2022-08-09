package adapter;

/**
 * @author
 * @time 2022/8/9 22:17
 * @Description- TODO
 */
public class Zh_JPTranslator implements Translator{
    @Override
    public String translate(String content) {

        if ("你好".equals(content)){
            return "空你几哇";
        }
        if ("什么".equals("content")) {
            return "纳尼";
        }

        return "*****";
    }
}
