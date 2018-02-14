package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muham on 2/13/2018.
 */

public class Issued {

    public Issued() {
    }

    public Issued(String mATDOC) {
        this.mATDOC = mATDOC;
    }

    @SerializedName("MATDOC")
    @Expose
    private String mATDOC;

    public String getMATDOC() {
        return mATDOC;
    }

    public void setMATDOC(String mATDOC) {
        this.mATDOC = mATDOC;
    }
}
