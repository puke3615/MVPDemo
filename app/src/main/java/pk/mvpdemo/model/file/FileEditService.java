package pk.mvpdemo.model.file;

import java.io.File;

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
        File file = new File(SAVE_PATH);
        return FileManager.save(file, record);
    }

    @Override
    public void clear() {
        File file = new File(SAVE_PATH);
        FileManager.delete(file);
    }

    @Override
    public Record get() {
        File file = new File(SAVE_PATH);
        return (Record) FileManager.get(file);
    }
}
