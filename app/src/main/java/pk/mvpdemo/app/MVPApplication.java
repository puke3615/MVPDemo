package pk.mvpdemo.app;

import android.app.Application;
import android.content.Context;

import pk.mvpdemo.di.application.AppComponent;
import pk.mvpdemo.di.application.AppModule;
import pk.mvpdemo.di.application.DaggerAppComponent;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class MVPApplication extends Application {

    private static Context sContext;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static Context context() {
        return sContext;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
