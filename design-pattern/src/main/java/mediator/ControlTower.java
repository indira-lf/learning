package mediator;

/**
 * @author
 * @time 2022/8/20 21:33
 * @Description- TODO
 */
public class ControlTower {

    private boolean canDo = true;

    void acceptRequest(Captain captain,String action) {
        if ("fly".equals(action) || "land".equals(action)){
            if (canDo){
                System.out.println("允许");
                canDo = false;
            }else {
                System.out.println("不允许");
            }
        } else if ("success".equals(action)){
            canDo = true;
        }
    }
}
