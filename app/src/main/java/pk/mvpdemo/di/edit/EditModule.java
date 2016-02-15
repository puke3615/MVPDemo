package pk.mvpdemo.di.edit;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import pk.mvpdemo.di.ActivityScope;
import pk.mvpdemo.model.IEditService;
import pk.mvpdemo.model.file.FileEditService;
import pk.mvpdemo.prensenter.EditActivity;
import pk.mvpdemo.view.EditView;
import pk.mvpdemo.view.IEditView;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark
 */
@Module
public class EditModule {

    private EditActivity activity;

    public EditModule(EditActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    IEditView provideEditView(EditView editView) {
        return editView;
    }

    @Provides
    @ActivityScope
    IEditService provideEditService(FileEditService editService) {
        return editService;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

}
