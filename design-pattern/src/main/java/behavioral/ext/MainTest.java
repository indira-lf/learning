package behavioral.ext;

/**
 * @author
 * @time 2022/8/26 23:00
 * @Description- TODO
 */
public class MainTest {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();

        CharacterFilter characterFilter = new CharacterFilter();
        EncodingFilter encodingFilter = new EncodingFilter();
        HttpFilter httpFilter = new HttpFilter();
        chain.addFilter(httpFilter);
        chain.addFilter(characterFilter);
        chain.addFilter(encodingFilter);

        chain.setTarget(new My());

        chain.doFilter(new Request("hello world"),new Response("abs"),chain);
    }
}
