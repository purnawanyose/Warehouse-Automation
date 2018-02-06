package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muham on 2/5/2018.
 */

public class Issued {


    public Issued() {
    }

    public Issued(String mATDOC, String dOCYEAR) {
        this.mATDOC = mATDOC;
        this.dOCYEAR = dOCYEAR;
    }


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
