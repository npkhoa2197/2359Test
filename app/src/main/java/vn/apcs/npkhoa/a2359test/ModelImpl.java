package vn.apcs.npkhoa.a2359test;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.apcs.npkhoa.a2359test.api.RetrofitClient;
import vn.apcs.npkhoa.a2359test.entities.Combination;
import vn.apcs.npkhoa.a2359test.entities.MovieResponse;
import vn.apcs.npkhoa.a2359test.entities.PromotionResponse;
import vn.apcs.npkhoa.a2359test.event.CombinationEvent;

/**
 * Created by khoanguyen on 4/5/18.
 */

public class ModelImpl implements Model {
    private RetrofitClient retrofitClient;

    private List<Combination> combinations;
    private List<Combination> onlyMoviews;
    private List<Combination> onlyPromotions;

    public ModelImpl() {
        combinations = new ArrayList<>();
        onlyMoviews = new ArrayList<>();
        onlyPromotions = new ArrayList<>();
        retrofitClient = new RetrofitClient();
    }

    @Override
    public void execute() {

        //enqueue an callback to api endpoint
        Call<List<PromotionResponse>> callback = retrofitClient.getPromotionService().promotion();
        callback.enqueue(new Callback<List<PromotionResponse>>() {
            @Override
            public void onResponse(Call<List<PromotionResponse>> call, Response<List<PromotionResponse>> response) {
                if (response.isSuccessful()) {
                    List<PromotionResponse> promotionResponse = response.body();

                    for (PromotionResponse res : promotionResponse) {
                        Combination _combination = new Combination(1,
                                null, null,
                                res.getImageThumb(), res);
                        Log.e("promotions", res.getImageFull());
                        onlyPromotions.add(_combination);
                    }
                }

            }
            @Override
            public void onFailure(Call<List<PromotionResponse>> call, Throwable t) {
                EventBus.getDefault().post(new CombinationEvent(t.getLocalizedMessage(), null));
            }
        });

        //enqueue an callback to api endpoint
        Call<List<MovieResponse>> callback2 = retrofitClient.getMovieService().movie();
        callback2.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                if (response.isSuccessful()) {
                    List<MovieResponse> movieResponses = response.body();

                    for (MovieResponse res : movieResponses) {
                        Combination _combination = new Combination(0,
                                res.getPosterThumb(), res,
                                null, null);
                        Log.e("movies", res.getPosterThumb());
                        onlyMoviews.add(_combination);
                    }
                    execute2();
                }
            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
                EventBus.getDefault().post(new CombinationEvent(t.getLocalizedMessage(), null));
            }
        });
    }
    private void execute2() {
        int j = 0;
        int i = 0;
        for (; i < onlyMoviews.size(); i += 2) {
            if (i + 2 >= onlyMoviews.size())
                break;

            combinations.add(onlyMoviews.get(i));
            combinations.add(onlyMoviews.get(i+1));
            if (j < onlyPromotions.size()) {
                combinations.add(onlyPromotions.get(j));
                ++j;
            }

        }
        if (i+1 < onlyMoviews.size())
            combinations.add(onlyMoviews.get(i+1));

        for (; j < onlyPromotions.size(); ++j)
            combinations.add(onlyPromotions.get(j));

        //use EventBus default instance to POST the event to the subscriber
        EventBus.getDefault().post(new CombinationEvent(null, combinations));
    }

//    private void post(List<Combination> items) {
//        post(items, null);
//    }
//
//    private void post(String error) {
//        post(null, error);
//    }
//
//    private void post(List<Combination> items, String error) {
//        CombinationEvent event = new CombinationEvent();
//        event.setError(error);
//        event.setCombinations(items);
//        EventBus.getDefault().post(event);
//    }
}
