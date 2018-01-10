package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Material;

/**
 * Created by yosep on 1/9/2018.
 */

public class MaterialResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private List<Material> content = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Material> getContent() {
        return content;
    }

    public void setContent(List<Material> content) {
        this.content = content;
    }

}
