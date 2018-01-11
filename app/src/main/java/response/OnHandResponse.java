package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Interim;
import model.OnHand;

/**
 * Created by muham on 12/15/2017.
 */

public class OnHandResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List <OnHand> onhand;


    public List<OnHand> getOnHand()
    {
        return onhand;
    }

    public String getStatus()
    {
        return status;
    }



}
