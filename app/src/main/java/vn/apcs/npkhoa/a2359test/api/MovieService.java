package vn.apcs.npkhoa.a2359test.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.apcs.npkhoa.a2359test.entities.MovieResponse;

/**
 * Created by khoanguyen on 4/5/18.
 */

public interface MovieService {
    @GET("movies/showing")
    Call<List<MovieResponse>> movie();
}
