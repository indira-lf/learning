package behavioral.ext;

/**
 * @author
 * @time 2022/8/27 12:37
 * @Description- TODO
 */
public class CharacterFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //功能
        request.msg += "===";
        System.out.println("CharacterFilter-----start");
        chain.doFilter(request,response,chain);
        System.out.println("CharacterFilter-----end");
    }
}
