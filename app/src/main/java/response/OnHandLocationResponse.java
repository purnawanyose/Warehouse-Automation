package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.OnHand;
import model.OnHandLocation;
import model.Reservation;

/**
 * Created by muham on 1/22/2018.
 */

public class OnHandLocationResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<OnHandLocation> onhandlocation;


    public List<OnHandLocation> getOnhandlocation()
    {
        return onhandlocation;
    }

    public String getStatus()
    {
        return status;
    }
}
