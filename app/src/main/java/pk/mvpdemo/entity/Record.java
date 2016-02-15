package pk.mvpdemo.entity;

import java.io.Serializable;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark 实体类
 */
public class Record implements Serializable {

    public String content;

    public Long time;

    public Record(String content, Long time) {
        this.content = content;
        this.time = time;
    }
}
