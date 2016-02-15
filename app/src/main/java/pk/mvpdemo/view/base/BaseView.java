package pk.mvpdemo.view.base;

import android.widget.Toast;

import pk.mvpdemo.app.MVPApplication;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class BaseView implements IToast {

    @Override
    public void showToast(Object s) {
        Toast.makeText(MVPApplication.context(), String.valueOf(s), Toast.LENGTH_SHORT).show();
    }
}
