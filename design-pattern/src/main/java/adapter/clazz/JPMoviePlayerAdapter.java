package adapter.clazz;

import adapter.Player;
import adapter.Zh_JPTranslator;

/**
 * @author
 * @time 2022/8/9 22:12
 * @Description- 通过继承方式
 */
public class JPMoviePlayerAdapter extends Zh_JPTranslator implements Player {

    private Player target; //被适配对象
    public JPMoviePlayerAdapter(Player target){
        this.target = target;
    }

    @Override
    public String play() {
        String play = target.play();
        //转换字幕
        String translate = translate(play);
        System.out.println("日文："+translate);
        return play;
    }
}
