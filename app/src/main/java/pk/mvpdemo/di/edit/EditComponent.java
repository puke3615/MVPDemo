package pk.mvpdemo.di.edit;

import dagger.Component;
import pk.mvpdemo.di.ActivityScope;
import pk.mvpdemo.di.IInject;
import pk.mvpdemo.di.application.AppComponent;
import pk.mvpdemo.model.IEditService;
import pk.mvpdemo.prensenter.EditActivity;
import pk.mvpdemo.view.IEditView;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
@ActivityScope
@Component(modules = EditModule.class, dependencies = AppComponent.class)
public interface EditComponent extends IInject<EditActivity> {

    IEditView view();

    IEditService model();

}
