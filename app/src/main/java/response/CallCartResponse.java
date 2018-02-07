package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Cart;
import model.Interim;

/**
 * Created by muham on 2/7/2018.
 */

public class CallCartResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Cart> cart;

    public List<Cart> getCart()
    {

        return cart;
    }

    public String getStatus()

    {
        return status;
    }
}
