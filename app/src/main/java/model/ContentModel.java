package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yosep on 2/13/2018.
 */

public class ContentModel {

    @SerializedName("error")
    @Expose
    private ArrayList<Object> error = null;

    @SerializedName("success")
    @Expose
    private ArrayList<MatDoc> success;

    public ContentModel(ArrayList<Object> error, ArrayList<MatDoc> success) {
        this.error = error;
        this.success = success;
    }

    public ContentModel() {
    }

    public ArrayList<Object> getError() {
        return error;
    }

    public void setError(ArrayList<Object> error) {
        this.error = error;
    }

    public ArrayList<MatDoc> getSuccess() {
        return success;
    }

    public void setSuccess(ArrayList<MatDoc> success) {
        this.success = success;
    }
}
