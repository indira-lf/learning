package behavioral.ext;

/**
 * @author
 * @time 2022/8/27 12:37
 * @Description- TODO
 */
public class EncodingFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.msg += ">>>";

        System.out.println("EncodingFilter------start");
        chain.doFilter(request,response,chain);
        System.out.println("EncodingFilter------end");
    }
}
