package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.HeadDetailOpname;
import model.ItemDetailOpname;
import model.Opname;

/**
 * Created by muham on 12/19/2017.
 */

public class StockOpnameDetailResponse {


    @SerializedName("head")
    @Expose
    private HeadDetailOpname head;
    @SerializedName("items")
    @Expose
    private List<ItemDetailOpname> items = null;

    public HeadDetailOpname getHead() {
        return head;
    }

    public void setHead(HeadDetailOpname head) {
        this.head = head;
    }

    public List<ItemDetailOpname> getItems() {
        return items;
    }

    public void setItems(List<ItemDetailOpname> items) {
        this.items = items;
    }
}
