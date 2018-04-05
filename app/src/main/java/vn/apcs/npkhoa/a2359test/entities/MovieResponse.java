package vn.apcs.npkhoa.a2359test.entities;

/**
 * Created by khoanguyen on 4/5/18.
 */

//POJO extracted from given JSON by using http://www.jsonschema2pojo.org/ tool
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("film_id")
    @Expose
    private String filmId;
    @SerializedName("film_name")
    @Expose
    private String filmName;
    @SerializedName("film_duration")
    @Expose
    private String filmDuration;
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("pg_rating")
    @Expose
    private String pgRating;
    @SerializedName("status_id")
    @Expose
    private int statusId;
    @SerializedName("poster_url")
    @Expose
    private String posterUrl;
    @SerializedName("poster_thumb")
    @Expose
    private String posterThumb;
    @SerializedName("poster_landscape")
    @Expose
    private String posterLandscape;
    @SerializedName("imdb_point")
    @Expose
    private float imdbPoint;

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(String filmDuration) {
        this.filmDuration = filmDuration;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPgRating() {
        return pgRating;
    }

    public void setPgRating(String pgRating) {
        this.pgRating = pgRating;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPosterThumb() {
        return posterThumb;
    }

    public void setPosterThumb(String posterThumb) {
        this.posterThumb = posterThumb;
    }

    public String getPosterLandscape() {
        return posterLandscape;
    }

    public void setPosterLandscape(String posterLandscape) {
        this.posterLandscape = posterLandscape;
    }

    public float getImdbPoint() {
        return imdbPoint;
    }

    public void setImdbPoint(float imdbPoint) {
        this.imdbPoint = imdbPoint;
    }

}
