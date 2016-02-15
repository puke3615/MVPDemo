package pk.mvpdemo.di.application;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application application();

}
