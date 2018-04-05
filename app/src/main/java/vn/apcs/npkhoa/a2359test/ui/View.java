package vn.apcs.npkhoa.a2359test.ui;

import java.util.List;

import vn.apcs.npkhoa.a2359test.entities.Combination;

/**
 * Created by khoanguyen on 4/5/18.
 */

public interface View {
    void showElements();
    void hideElements();
    void showProgressBar();
    void hideProgressBar();

    void onError(String error);
    void setContent(List<Combination> items);
}
