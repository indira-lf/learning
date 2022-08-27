package behavioral.ext;

/**
 * @author
 * @time 2022/8/26 22:55
 * @Description- TODO
 */
public interface Filter {
    void doFilter(Request request,Response response, FilterChain chain);
}
