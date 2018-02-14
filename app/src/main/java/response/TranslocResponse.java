package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Content;
import model.ContentModel;
import model.Interim;
import model.Transloc;

/**
 * Created by muham on 2/5/2018.
 */

public class TranslocResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Transloc> transloc;

    public List<Transloc> getTransloc()
    {

        return transloc;
    }

    public String getStatus()

    {
        return status;
    }
}
