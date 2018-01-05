package response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import model.Interim;

/**
 * Created by muham on 12/15/2017.
 */

public class InterimResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List <Interim> interim;


    public List<Interim> getInterim()
    {
        return interim;
    }

    public String getStatus()
    {
        return status;
    }


}
