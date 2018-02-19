package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yosep on 2/19/2018.
 */

public class DetailResponse {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private StockOpnameDetailResponse content;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public StockOpnameDetailResponse getContent() {
        return content;
    }

    public void setContent(StockOpnameDetailResponse content) {
        this.content = content;
    }
}
