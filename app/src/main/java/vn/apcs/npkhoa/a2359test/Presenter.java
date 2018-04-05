package vn.apcs.npkhoa.a2359test;

import vn.apcs.npkhoa.a2359test.event.CombinationEvent;

/**
 * Created by khoanguyen on 4/5/18.
 */

public interface Presenter {
//    void onResume();
//    void onPause();
//    void onDestroy();
    void getItems();
    void onEventMainThread(CombinationEvent event);
}
