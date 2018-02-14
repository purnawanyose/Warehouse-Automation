package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yosep on 2/13/2018.
 */

public class MatDoc {

    @SerializedName("MAT_DOC")
    @Expose
    private String mATDOC;
    @SerializedName("DOC_YEAR")
    @Expose
    private String dOCYEAR;

    public String getMATDOC() {
        return mATDOC;
    }

    public void setMATDOC(String mATDOC) {
        this.mATDOC = mATDOC;
    }

    public String getDOCYEAR() {
        return dOCYEAR;
    }

    public void setDOCYEAR(String dOCYEAR) {
        this.dOCYEAR = dOCYEAR;
    }

}
