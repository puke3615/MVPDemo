package pk.mvpdemo.model;

import pk.mvpdemo.entity.Record;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public interface IEditModel {

    boolean save(Record record);

    void clear();

    Record get();

}
