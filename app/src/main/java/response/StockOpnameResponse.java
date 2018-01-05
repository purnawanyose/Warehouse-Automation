package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.BonSementara;
import model.Interim;
import model.Opname;

/**
 * Created by muham on 12/19/2017.
 */

public class StockOpnameResponse {


    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Opname> stockopname;

    public List<Opname> getStockopname() {
        return stockopname;
    }
    public String getStatus()
    {
        return status;
    }

}
