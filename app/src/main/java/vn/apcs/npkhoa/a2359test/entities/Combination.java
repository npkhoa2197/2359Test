package vn.apcs.npkhoa.a2359test.entities;

/**
 * Created by khoanguyen on 4/5/18.
 */

//for simplicity in creating different row types for a recyclerView
//I create a class called Combination which can represent either a movie type or a promotion type
//it will combination will be distinguished by an int TYPE
public class Combination {
    public static final int MOVIE_TYPE = 0;
    public static final int PROMOTION_TYPE = 1;

    private int mType;

    private String movieImgUrl;
    private MovieResponse movie;
    private String promotionImgUrl;
    private PromotionResponse promotion;

    public Combination(int mType, String movieImgUrl, MovieResponse movie, String promotionImgUrl, PromotionResponse promotion) {
        this.mType = mType;
        this.movieImgUrl = movieImgUrl;
        this.movie = movie;
        this.promotionImgUrl = promotionImgUrl;
        this.promotion = promotion;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public String getMovieImgUrl() {
        return movieImgUrl;
    }

    public void setMovieImgUrl(String movieImgUrl) {
        this.movieImgUrl = movieImgUrl;
    }

    public MovieResponse getMovie() {
        return movie;
    }

    public void setMovie(MovieResponse movies) {
        this.movie = movie;
    }

    public PromotionResponse getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionResponse promotion) {
        this.promotion = promotion;
    }

    public String getPromotionImgUrl() {
        return promotionImgUrl;
    }

    public void setPromotionImgUrl(String promotionImgUrl) {
        this.promotionImgUrl = promotionImgUrl;
    }
}
