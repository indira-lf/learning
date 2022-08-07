package prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @time 2022/8/7 8:04
 * @Description- TODO
 */
public class MyBatis {

    // 缓存user
    private Map<String,User> userCache = new HashMap<>();

    /**
     * 从数据库查数据
     * @param userName
     * @return
     */
    public User getUser(String userName) throws CloneNotSupportedException {
        User user = null;
        if (!userCache.containsKey(userName)){
            user = getUserFromDb(userName);
        } else {
            // 从缓存中直接拿，会有脏缓存问题
            //原型已经拿到，不能直接给(本人)
            user = userCache.get(userName);
            // 从这个对象快速得到一个克隆体(克隆人)
            user = (User) user.clone();

        }
        return user;
    }

    private User getUserFromDb(String userName) throws CloneNotSupportedException {
        User user = new User();
        user.setUserName(userName);
        user.setAge(19);
        user.setEmail("aaa");
        userCache.put(userName, (User) user.clone());
        return user;
    }
}
