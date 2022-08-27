package behavioral.ext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @time 2022/8/26 22:57
 * @Description- TODO
 */
public class FilterChain implements Filter{

    int cusor = 0;

    List<Filter> filtersChain = new ArrayList<>();

    My target;

    public void setTarget(My target) {
        this.target = target;
    }

    public My getTarget() {
        return target;
    }

    void addFilter(Filter filter){
        filtersChain.add(filter);
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {

        if (cusor < filtersChain.size()){
            Filter filter = filtersChain.get(cusor);

            cusor++;
            filter.doFilter(request,response,chain);
        }else {
            // 执行目标方法
            target.hello();
        }

    }
}
