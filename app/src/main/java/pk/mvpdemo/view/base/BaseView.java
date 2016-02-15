package pk.mvpdemo.view.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import pk.mvpdemo.app.MVPApplication;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class BaseView implements IView {

    private final Activity mActivity;
    private ProgressDialog mProgressDialog;

    public BaseView(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void showToast(Object s) {
        Toast.makeText(MVPApplication.context(), String.valueOf(s), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mActivity);
            mProgressDialog.setCanceledOnTouchOutside(true);
            mProgressDialog.setMessage("Loading...");
        }
        mProgressDialog.show();
    }

    @Override
    public void dismissProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public Activity activity() {
        return mActivity;
    }
}
