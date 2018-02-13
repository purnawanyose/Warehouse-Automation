package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Content;
import model.ContentModel;

/**
 * Created by muham on 2/5/2018.
 */

public class TranslocResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private List<ContentModel> content;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ContentModel> getContent() {
        return content;
    }

    public void setContent(List<ContentModel> content) {
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
