package pk.mvpdemo.model.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.inject.Inject;

import pk.mvpdemo.app.MVPApplication;
import pk.mvpdemo.entity.Record;
import pk.mvpdemo.model.IEditService;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class FileEditService implements IEditService {

    private static final String SAVE_PATH = MVPApplication.context().getFileStreamPath("record.dat").getAbsolutePath();

    @Inject
    public FileEditService() {

    }

    @Override
    public boolean save(Record record) {
        if (!(record instanceof Serializable)) {
            return false;
        }
        ObjectOutputStream oos = null;
        try {
            File file = new File(SAVE_PATH);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(record);
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        File file = new File(SAVE_PATH);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    @Override
    public Record get() {
        File file = new File(SAVE_PATH);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Record record = (Record) ois.readObject();
            return record;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
