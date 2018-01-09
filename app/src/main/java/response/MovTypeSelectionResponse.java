package response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.MovTypeSelection;

/**
 * Created by yosep on 1/8/2018.
 */

public class MovTypeSelectionResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("content")
    @Expose
    private List<MovTypeSelection> content = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<MovTypeSelection> getContent() {
        return content;
    }

    public void setContent(List<MovTypeSelection> content) {
        this.content = content;
    }

}
