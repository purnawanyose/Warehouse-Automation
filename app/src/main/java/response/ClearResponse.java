package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.BonSementara;
import model.Interim;

/**
 * Created by muham on 1/5/2018.
 */

public class ClearResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Interim> interim;

    public List<Interim> getInterim()
    {

        return interim;
    }

    public String getStatus()

    {
        return status;
    }

}
