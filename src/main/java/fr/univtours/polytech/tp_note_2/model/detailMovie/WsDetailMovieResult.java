
package fr.univtours.polytech.tp_note_2.model.detailMovie;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({
    "ok",
    "description",
    "error_code"
})
@Generated("jsonschema2pojo")
public class WsDetailMovieResult {

    @JsonbProperty("ok")
    private Boolean ok;
    @JsonbProperty("description")
    private List<Description> description;
    @JsonbProperty("error_code")
    private Integer errorCode;
    @JsonbTransient
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonbProperty("ok")
    public Boolean getOk() {
        return ok;
    }

    @JsonbProperty("ok")
    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @JsonbProperty("description")
    public List<Description> getDescription() {
        return description;
    }

    @JsonbProperty("description")
    public void setDescription(List<Description> description) {
        this.description = description;
    }

    @JsonbProperty("error_code")
    public Integer getErrorCode() {
        return errorCode;
    }

    @JsonbProperty("error_code")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
