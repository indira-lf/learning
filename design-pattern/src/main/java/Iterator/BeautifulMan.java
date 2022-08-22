package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @time 2022/8/22 22:45
 * @Description- 抽象聚合类
 */
public abstract class BeautifulMan {

    private List<String> girlFriends = new ArrayList<>();

    void likeYou(String name) {
        girlFriends.add(name);
    }
    void sayBye(String name){
        girlFriends.remove(name);
    }

    /**
     * 获取迭代器
     */
    public Itr getIterator() {
        return new Iterator();
    }


    class Iterator implements Itr {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < girlFriends.size()-1;
        }

        @Override
        public String next() {
            String s = girlFriends.get(cursor);
            cursor++;
            return s;
        }

        @Override
        public String firstLove() {
            return girlFriends.get(0);
        }

        @Override
        public String current() {
            return girlFriends.get(girlFriends.size()-1);
        }
    }

    interface Itr {
        boolean hasNext();

        String next();

        String firstLove();

        String current();
    }

}
