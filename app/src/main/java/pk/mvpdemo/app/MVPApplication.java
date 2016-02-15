package pk.mvpdemo.app;

import android.app.Application;
import android.content.Context;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
public class MVPApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context context() {
        return sContext;
    }

}
