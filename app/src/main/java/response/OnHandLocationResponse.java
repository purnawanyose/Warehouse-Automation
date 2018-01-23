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
<<<<<<< HEAD

    @SerializedName("content")
    private List <OnHandLocation> onhandlocation;


    public List<OnHandLocation> getOnHandLocation()
=======

    @SerializedName("content")
    private List<OnHandLocation> onhandlocation;

    public List<OnHandLocation> getOnhandlocation()
>>>>>>> cd350491bcb1826d92d08a5ce1c8df8cfaf6c0de
    {
        return onhandlocation;
    }

    public String getStatus()
    {
        return status;
    }
}
