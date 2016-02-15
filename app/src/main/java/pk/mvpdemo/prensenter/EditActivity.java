package pk.mvpdemo.prensenter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;

import javax.inject.Inject;

import dagger.Lazy;
import pk.mvpdemo.app.MVPApplication;
import pk.mvpdemo.di.application.AppComponent;
import pk.mvpdemo.di.edit.DaggerEditComponent;
import pk.mvpdemo.di.edit.EditComponent;
import pk.mvpdemo.di.edit.EditModule;
import pk.mvpdemo.entity.Record;
import pk.mvpdemo.model.IEditService;
import pk.mvpdemo.view.IEditView;

public class EditActivity extends Activity implements IEditPresenter {

    @Inject
    IEditView mEditView;
    @Inject
    Lazy<IEditService> mEditModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        initView();
    }

    private void initComponent() {
//        mEditView = new EditView(this);
//        mEditModel = new FileEditService();
        AppComponent appComponent = ((MVPApplication) getApplication()).getAppComponent();
        EditComponent component = DaggerEditComponent.builder()
                .appComponent(appComponent)
                .editModule(new EditModule(this))
                .build();
        component.inject(this);
    }

    private void initView() {
        setContentView(mEditView.getView(getLayoutInflater()));
        Record record = mEditModel.get().get();
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
        boolean success = mEditModel.get().save(new Record(name, System.currentTimeMillis()));
        mEditView.showToast(String.format("数据保存%s", success ? "成功" : "失败"));
    }

    @Override
    public void onClear() {
        mEditView.setEditText(null);
        mEditModel.get().clear();
        mEditView.showToast("数据已清除");
    }
}
