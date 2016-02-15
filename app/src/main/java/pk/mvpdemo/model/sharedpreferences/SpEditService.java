package pk.mvpdemo.model.sharedpreferences;

import android.content.SharedPreferences;

import javax.inject.Inject;

import pk.mvpdemo.app.MVPApplication;
import pk.mvpdemo.entity.Record;
import pk.mvpdemo.model.IEditService;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class SpEditService implements IEditService {

    private static final String SP_NAME = "SpEditService";
    private static final String KEY_TIME = "time";
    private static final String KEY_CONTENT = "content";
    private final SharedPreferences mSp;

    @Inject
    public SpEditService() {
        mSp = MVPApplication.context().getSharedPreferences(SP_NAME, 0);
    }

    @Override
    public boolean save(Record record) {
        if (record == null) {
            return false;
        }
        Long time = record.time;
        String content = record.content;
        return mSp.edit()
                .putLong(KEY_TIME, time)
                .putString(KEY_CONTENT, content)
                .commit();
    }

    @Override
    public void clear() {
        mSp.edit().clear().commit();
    }

    @Override
    public Record get() {
        Long time = mSp.getLong(KEY_TIME, -1);
        String content = mSp.getString(KEY_CONTENT, null);
        return new Record(content, time);
    }
}
