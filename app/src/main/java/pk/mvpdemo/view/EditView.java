package pk.mvpdemo.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import pk.mvpdemo.R;
import pk.mvpdemo.prensenter.IEditPresenter;
import pk.mvpdemo.view.base.BaseView;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class EditView extends BaseView implements IEditView {

    private View view;
    private EditText mEdit;
    private Button mSave, mClear;
    private IEditPresenter mListener;

    @Inject
    public EditView(Activity activity) {
        super(activity);
        mListener = (IEditPresenter) activity;
    }

    @Override
    public View getView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.activity_edit, null);
        initView();
        initListener();
        return view;
    }

    private void initView() {
        View view = this.view;
        mEdit = (EditText) view.findViewById(R.id.edit);
        mSave = (Button) view.findViewById(R.id.save);
        mClear = (Button) view.findViewById(R.id.clear);
    }

    private void initListener() {
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onSave();
                }
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClear();
                }
            }
        });
    }

    @Override
    public void setEditText(String content) {
        mEdit.setText(content);
    }

    @Override
    public String getEditText() {
        return mEdit.getText().toString().trim();
    }

}
