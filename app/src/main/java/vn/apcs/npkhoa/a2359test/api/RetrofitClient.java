package vn.apcs.npkhoa.a2359test.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by khoanguyen on 4/5/18.
 */

public class RetrofitClient {
    private Retrofit retrofit;

    public MovieService getMovieService() {
        return retrofit.create(MovieService.class);
    }

    public PromotionService getPromotionService() {
        return retrofit.create(PromotionService.class);
    }

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://demo1415628.mockable.io/interview/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
