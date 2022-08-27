package behavioral.ext;

import lombok.Data;

/**
 * @author
 * @time 2022/8/26 22:56
 * @Description- TODO
 */
@Data
public class Request {
    String msg;

    public Request(String msg) {
        this.msg = msg;
    }
}
