package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.OnHand;
import model.OnHandLocation;
import model.Reservation;

/**
 * Created by muham on 1/22/2018.
 */

public class OnHandLocationResponse {
    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("success")
    @Expose
    private List<Success> success = null;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public List<Success> getSuccess() {
        return success;
    }

    public void setSuccess(List<Success> success) {
        this.success = success;
    }
}
