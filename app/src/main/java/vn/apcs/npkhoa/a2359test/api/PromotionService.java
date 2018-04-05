package vn.apcs.npkhoa.a2359test.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.apcs.npkhoa.a2359test.entities.PromotionResponse;

/**
 * Created by khoanguyen on 4/5/18.
 */

public interface PromotionService {
    @GET("banners")
    Call<List<PromotionResponse>> promotion();
}
