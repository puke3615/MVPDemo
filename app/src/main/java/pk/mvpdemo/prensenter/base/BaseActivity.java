package pk.mvpdemo.prensenter.base;

import android.app.Activity;
import android.os.Bundle;

import pk.mvpdemo.app.MVPApplication;
import pk.mvpdemo.di.IInject;
import pk.mvpdemo.di.application.AppComponent;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public abstract class BaseActivity<T> extends Activity {

    private AppComponent mAppComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppComponent = ((MVPApplication) getApplication()).getAppComponent();
        T component = getComponent();
        if (component instanceof IInject) {
            ((IInject) component).inject(this);
        }
    }

    protected abstract T getComponent();

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
