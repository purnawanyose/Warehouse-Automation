package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yosep on 1/9/2018.
 */

public class Material {

    @SerializedName("MATNR")
    @Expose
    private String mATNR;
    @SerializedName("SPRAS")
    @Expose
    private String sPRAS;
    @SerializedName("MAKTX")
    @Expose
    private String mAKTX;
    @SerializedName("MAKTG")
    @Expose
    private String mAKTG;

    public Material(){}

    public Material(String mATNR, String sPRAS, String mAKTX, String mAKTG) {
        this.mATNR = mATNR;
        this.sPRAS = sPRAS;
        this.mAKTX = mAKTX;
        this.mAKTG = mAKTG;
    }

    public String getMATNR() {
        return mATNR;
    }

    public void setMATNR(String mATNR) {
        this.mATNR = mATNR;
    }

    public String getSPRAS() {
        return sPRAS;
    }

    public void setSPRAS(String sPRAS) {
        this.sPRAS = sPRAS;
    }

    public String getMAKTX() {
        return mAKTX;
    }

    public void setMAKTX(String mAKTX) {
        this.mAKTX = mAKTX;
    }

    public String getMAKTG() {
        return mAKTG;
    }

    public void setMAKTG(String mAKTG) {
        this.mAKTG = mAKTG;
    }


}
