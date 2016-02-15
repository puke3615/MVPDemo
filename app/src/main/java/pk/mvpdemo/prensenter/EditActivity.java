package pk.mvpdemo.prensenter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;

import pk.mvpdemo.entity.Record;
import pk.mvpdemo.model.IEditModel;
import pk.mvpdemo.model.file.FileEditModel;
import pk.mvpdemo.view.EditView;
import pk.mvpdemo.view.IEditView;

public class EditActivity extends Activity implements IEditPresenter {

    private IEditView mEditView;
    private IEditModel mEditModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        initView();
    }

    private void initComponent() {
        mEditView = new EditView(this);
        mEditModel = new FileEditModel();
    }

    private void initView() {
        setContentView(mEditView.getView(getLayoutInflater()));
        Record record = mEditModel.get();
        if (record != null) {
            String content = record.content;
            mEditView.setEditText(content);
        }
    }

    @Override
    public void onSave() {
        String name = mEditView.getEditText();
        if (TextUtils.isEmpty(name)) {
            mEditView.showToast("请填写数据");
            return;
        }
        boolean success = mEditModel.save(new Record(name, System.currentTimeMillis()));
        mEditView.showToast(String.format("数据保存%s", success ? "成功" : "失败"));
    }

    @Override
    public void onClear() {
        mEditView.setEditText(null);
        mEditModel.clear();
        mEditView.showToast("数据已清除");
    }
}
