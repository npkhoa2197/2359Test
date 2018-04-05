package vn.apcs.npkhoa.a2359test;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import vn.apcs.npkhoa.a2359test.event.CombinationEvent;
import vn.apcs.npkhoa.a2359test.ui.View;

/**
 * Created by khoanguyen on 4/5/18.
 */

public class PresenterImpl implements Presenter {
    private View view;
    private Model model;

    public PresenterImpl(View view) {
        this.view = view;
        this.model = new ModelImpl();
        EventBus.getDefault().register(this);
    }

//    @Override
//    public void onResume() {
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onPause() {
//        EventBus.getDefault().unregister(this);
//    }
//
//    @Override
//    public void onDestroy() {
//        view = null;
//    }

    @Override
    public void getItems() {
        if (view != null) {
            view.showElements();
            view.hideProgressBar();
        }
        model.execute();
    }

    //this method will listen to the event coming from Model layer
    @Override
    @Subscribe
    public void onEventMainThread(CombinationEvent event) {
        String msgError = event.getError();
        if (view != null) {
            view.showElements();
            view.hideProgressBar();

            if (msgError != null) {
                view.onError(msgError);
            } else {
                view.setContent(event.getCombinations());
            }
        }
    }
}
