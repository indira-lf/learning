package adapter.obj;

import adapter.Player;
import adapter.Translator;
import adapter.Zh_JPTranslator;

/**
 * @author
 * @time 2022/8/9 22:23
 * @Description- TODO
 */
public class JPMoviePlayerAdapter extends Zh_JPTranslator implements Player {

    //组合模式
    private Translator translator = new Zh_JPTranslator();
    private Player target; //被适配对象
    public JPMoviePlayerAdapter(Player target){
        this.target = target;
    }

    @Override
    public String play() {
        String play = target.play();
        //转换字幕
        String translate = translator.translate(play);
        System.out.println("日文："+translate);
        return play;
    }
}
