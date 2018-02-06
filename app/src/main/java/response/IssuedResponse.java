package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Content;
import model.ContentIssued;
import model.Issued;
import model.Reservation;

/**
 * Created by muham on 2/5/2018.
 */

public class IssuedResponse {

     @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private Content content;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
/*
    @SerializedName("content")
    private List <ContentIssued> contentIssued;


    public List<ContentIssued> getContentIssued()
    {
        return contentIssued;
    }*/
}
