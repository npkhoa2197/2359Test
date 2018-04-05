package vn.apcs.npkhoa.a2359test.entities;

/**
 * Created by khoanguyen on 4/5/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//POJO extracted from given JSON by using http://www.jsonschema2pojo.org/ tool
public class PromotionResponse {

    @SerializedName("news_id")
    @Expose
    private String newsId;
    @SerializedName("news_title")
    @Expose
    private String newsTitle;
    @SerializedName("news_description")
    @Expose
    private String newsDescription;
    @SerializedName("date_add")
    @Expose
    private String dateAdd;
    @SerializedName("image_full")
    @Expose
    private String imageFull;
    @SerializedName("image_thumb")
    @Expose
    private String imageThumb;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getImageFull() {
        return imageFull;
    }

    public void setImageFull(String imageFull) {
        this.imageFull = imageFull;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

}
