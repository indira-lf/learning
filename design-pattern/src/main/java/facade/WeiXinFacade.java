package facade;

/**
 * @author
 * @time 2022/8/15 7:39
 * @Description- TODO
 */
public class WeiXinFacade {
    Police police = new Police();
    Edu edu = new Edu();
    Social social = new Social();

    public void handle(String name){
        police.resgister(name);
        edu.assignSchool(name);
        social.handleSocial(name);
    }
}
