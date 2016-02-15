package pk.mvpdemo.view;

import android.view.LayoutInflater;
import android.view.View;

import pk.mvpdemo.view.base.IToast;

/**
 * @author zijiao
 * @version 2016/2/15
 * @Mark 视图交互层，该接口直接与EditActivity交互
 */
public interface IEditView extends IToast {

    View getView(LayoutInflater inflater);

    void setEditText(String content);

    String getEditText();

    /*void setEditListener(IEditListener editListener);

    public static interface IEditListener {
        void onSave();

        void onClear();
    }*/

}
