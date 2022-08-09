package adapter;

/**
 * @author
 * @time 2022/8/9 21:54
 * @Description- TODO
 */
public class MoviePlayer implements Player{
    @Override
    public String play() {
        System.out.println("正在播放：设计模式.avi");
        String content = "你好";
        System.out.println(content);
        return content;
    }
}
