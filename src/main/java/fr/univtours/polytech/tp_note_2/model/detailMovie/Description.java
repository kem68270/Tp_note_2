
package fr.univtours.polytech.tp_note_2.model.detailMovie;

import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.annotation.Generated;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({
    "#TITLE",
    "#YEAR",
    "#IMDB_ID",
    "#RANK",
    "#ACTORS",
    "#AKA",
    "#IMDB_URL",
    "#IMDB_IV",
    "#IMG_POSTER",
    "photo_width",
    "photo_height"
})
@Generated("jsonschema2pojo")
public class Description {

    @JsonbProperty("#TITLE")
    private String title;
    @JsonbProperty("#YEAR")
    private Integer year;
    @JsonbProperty("#IMDB_ID")
    private String imdbId;
    @JsonbProperty("#RANK")
    private Integer rank;
    @JsonbProperty("#ACTORS")
    private String actors;
    @JsonbProperty("#AKA")
    private String aka;
    @JsonbProperty("#IMDB_URL")
    private String imdbUrl;
    @JsonbProperty("#IMDB_IV")
    private String imdbIv;
    @JsonbProperty("#IMG_POSTER")
    private String imgPoster;
    @JsonbProperty("photo_width")
    private Integer photoWidth;
    @JsonbProperty("photo_height")
    private Integer photoHeight;
    @JsonbTransient
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonbProperty("#TITLE")
    public String getTitle() {
        return title;
    }

    @JsonbProperty("#TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonbProperty("#YEAR")
    public Integer getYear() {
        return year;
    }

    @JsonbProperty("#YEAR")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonbProperty("#IMDB_ID")
    public String getImdbId() {
        return imdbId;
    }

    @JsonbProperty("#IMDB_ID")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @JsonbProperty("#RANK")
    public Integer getRank() {
        return rank;
    }

    @JsonbProperty("#RANK")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonbProperty("#ACTORS")
    public String getActors() {
        return actors;
    }

    @JsonbProperty("#ACTORS")
    public void setActors(String actors) {
        this.actors = actors;
    }

    @JsonbProperty("#AKA")
    public String getAka() {
        return aka;
    }

    @JsonbProperty("#AKA")
    public void setAka(String aka) {
        this.aka = aka;
    }

    @JsonbProperty("#IMDB_URL")
    public String getImdbUrl() {
        return imdbUrl;
    }

    @JsonbProperty("#IMDB_URL")
    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    @JsonbProperty("#IMDB_IV")
    public String getImdbIv() {
        return imdbIv;
    }

    @JsonbProperty("#IMDB_IV")
    public void setImdbIv(String imdbIv) {
        this.imdbIv = imdbIv;
    }

    @JsonbProperty("#IMG_POSTER")
    public String getImgPoster() {
        return imgPoster;
    }

    @JsonbProperty("#IMG_POSTER")
    public void setImgPoster(String imgPoster) {
        this.imgPoster = imgPoster;
    }

    @JsonbProperty("photo_width")
    public Integer getPhotoWidth() {
        return photoWidth;
    }

    @JsonbProperty("photo_width")
    public void setPhotoWidth(Integer photoWidth) {
        this.photoWidth = photoWidth;
    }

    @JsonbProperty("photo_height")
    public Integer getPhotoHeight() {
        return photoHeight;
    }

    @JsonbProperty("photo_height")
    public void setPhotoHeight(Integer photoHeight) {
        this.photoHeight = photoHeight;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
