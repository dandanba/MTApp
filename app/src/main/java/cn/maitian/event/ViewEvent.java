package cn.maitian.event;

import android.view.View;

/**
 * Created by geng on 2016/7/16.
 */
public class ViewEvent extends BaseEvent {
    private final View mView;

    public ViewEvent(View view) {
        this.mView = view;
    }

    public View getView() {
        return mView;
    }
}
