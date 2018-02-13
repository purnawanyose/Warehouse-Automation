package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.MatDoc;
import model.Success;

/**
 * Created by yosep on 2/13/2018.
 */

public class SuccesResponse {

    @SerializedName("error")
    @Expose
    private List<Object> error = null;
    @SerializedName("success")
    @Expose
    private MatDoc success;

    public List<Object> getError() {
        return error;
    }

    public void setError(List<Object> error) {
        this.error = error;
    }

    public MatDoc getSuccess() {
        return success;
    }

    public void setSuccess(MatDoc success) {
        this.success = success;
    }
}
