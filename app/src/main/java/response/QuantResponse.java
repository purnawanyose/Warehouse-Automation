package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Interim;
import model.Quant;

/**
 * Created by muham on 12/18/2017.
 */

public class QuantResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Quant> quant;


    public List<Quant> getQuant()
    {
        return quant;
    }

    public String getStatus()
    {
        return status;
    }
}

