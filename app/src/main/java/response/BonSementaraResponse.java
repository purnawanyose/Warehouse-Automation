package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.BonSementara;
import model.Interim;
import model.Quant;

/**
 * Created by muham on 12/19/2017.
 */

public class BonSementaraResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<BonSementara> bonsemetara;

    public List<BonSementara> getBonSementara()
    {

        return bonsemetara;
    }

    public String getStatus()

    {
        return status;
    }


}
