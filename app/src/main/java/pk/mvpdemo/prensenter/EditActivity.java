package pk.mvpdemo.prensenter;

import android.os.Bundle;
import android.text.TextUtils;

import javax.inject.Inject;

import dagger.Lazy;
import pk.mvpdemo.di.edit.DaggerEditComponent;
import pk.mvpdemo.di.edit.EditComponent;
import pk.mvpdemo.di.edit.EditModule;
import pk.mvpdemo.entity.Record;
import pk.mvpdemo.model.IEditService;
import pk.mvpdemo.prensenter.base.BaseActivity;
import pk.mvpdemo.view.IEditView;

public class EditActivity extends BaseActivity<EditComponent> implements IEditPresenter {

    @Inject
    IEditView mEditView;
    @Inject
    Lazy<IEditService> mEditModelGetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        initView();
    }

    private void initComponent() {
//        mEditView = new EditView(this);
//        mEditModel = new FileEditService();
    }

    private void initView() {
        setContentView(mEditView.getView(getLayoutInflater()));
        Record record = getEditService().get();
        if (record != null) {
            String content = record.content;
            mEditView.setEditText(content);
        }
    }

    private IEditService getEditService() {
        return mEditModelGetter.get();
    }

    @Override
    public void onSave() {
        String name = mEditView.getEditText();
        if (TextUtils.isEmpty(name)) {
            mEditView.showToast("请填写数据");
            return;
        }
        boolean success = getEditService().save(new Record(name, System.currentTimeMillis()));
        mEditView.showToast(String.format("数据保存%s", success ? "成功" : "失败"));
    }

    @Override
    public void onClear() {
        mEditView.setEditText(null);
        getEditService().clear();
        mEditView.showToast("数据已清除");
    }

    @Override
    public EditComponent getComponent() {
        return DaggerEditComponent.builder()
                .appComponent(getAppComponent())
                .editModule(new EditModule(this))
                .build();
    }
}
