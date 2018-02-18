package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.BonSementara;
import model.Interim;

/**
 * Created by muham on 1/5/2018.
 */

public class ClearResponse {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private String content;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
