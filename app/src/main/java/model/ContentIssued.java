package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by muham on 2/6/2018.
 */

public class ContentIssued {

    @SerializedName("error")
    @Expose
    private List<Object> error = null;
    @SerializedName("success")
    @Expose
    private Success success;

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }
}
