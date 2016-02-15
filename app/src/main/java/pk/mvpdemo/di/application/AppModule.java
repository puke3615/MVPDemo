package pk.mvpdemo.di.application;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import pk.mvpdemo.app.MVPApplication;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
@Module
public class AppModule {

    private MVPApplication application;

    public AppModule(MVPApplication application) {
        this.application = application;
    }

    @Provides
    Application application() {
        return application;
    }

}
