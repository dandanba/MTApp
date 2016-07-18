package cn.maitian.base;


import android.content.Context;
import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.maitian.event.BaseEvent;
import cn.maitian.util.EventUtil;
import cn.maitian.util.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private BaseActivity mBaseActivity;

    public LogHandler getHandler() {
        return mBaseActivity.getHandler();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBaseActivity = (BaseActivity) context;
        EventUtil.register(this);
        LogUtil.i("%1$s,onAttach", TAG);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.i("%1$s,onDetach", TAG);
        EventUtil.unregister(this);
    }

    // This method will be called when a BaseEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent event) {
    }

    public void postEvent(Object event) {
        EventUtil.postEvent(event);
    }
}
