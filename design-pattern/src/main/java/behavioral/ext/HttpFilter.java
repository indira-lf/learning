package behavioral.ext;

/**
 * @author
 * @time 2022/8/26 23:00
 * @Description- TODO
 */
public class HttpFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //第一个Filter
        request.msg += "---";

        System.out.println("HttpFilter----start");
        chain.doFilter(request,response,chain);
        System.out.println("HttpFilter----end");
    }
}
