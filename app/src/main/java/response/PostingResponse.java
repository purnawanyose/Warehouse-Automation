package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Opname;
import model.Posting;

/**
 * Created by muham on 12/19/2017.
 */

public class PostingResponse {


    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private Posting content;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Posting getContent() {
        return content;
    }

    public void setContent(Posting content) {
        this.content = content;
    }

}
