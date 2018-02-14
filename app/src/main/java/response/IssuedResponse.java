package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Issued;
import model.Transloc;

/**
 * Created by muham on 2/5/2018.
 */

public class IssuedResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Issued> issued;

    public List<Issued> getIssued()
    {

        return issued;
    }

    public String getStatus()

    {
        return status;
    }

}
