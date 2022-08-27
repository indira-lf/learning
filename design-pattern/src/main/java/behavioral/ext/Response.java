package behavioral.ext;

import lombok.Data;

/**
 * @author
 * @time 2022/8/26 22:57
 * @Description- TODO
 */
@Data
public class Response {

    String content;

    public Response(String content) {
        this.content = content;
    }
}
