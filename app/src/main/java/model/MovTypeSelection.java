package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yosep on 1/8/2018.
 */

public class MovTypeSelection {

    @SerializedName("SPRAS")
    @Expose
    private String sPRAS;
    @SerializedName("BWART")
    @Expose
    private String bWART;
    @SerializedName("SOBKZ")
    @Expose
    private String sOBKZ;
    @SerializedName("KZBEW")
    @Expose
    private String kZBEW;
    @SerializedName("KZZUG")
    @Expose
    private String kZZUG;
    @SerializedName("KZVBR")
    @Expose
    private String kZVBR;
    @SerializedName("BTEXT")
    @Expose
    private String bTEXT;

    public MovTypeSelection(){}

    public MovTypeSelection(String sPRAS, String bWART, String sOBKZ, String kZBEW, String kZZUG, String kZVBR, String bTEXT) {
        this.sPRAS = sPRAS;
        this.bWART = bWART;
        this.sOBKZ = sOBKZ;
        this.kZBEW = kZBEW;
        this.kZZUG = kZZUG;
        this.kZVBR = kZVBR;
        this.bTEXT = bTEXT;
    }

    public String getSPRAS() {
        return sPRAS;
    }

    public void setSPRAS(String sPRAS) {
        this.sPRAS = sPRAS;
    }

    public String getBWART() {
        return bWART;
    }

    public void setBWART(String bWART) {
        this.bWART = bWART;
    }

    public String getSOBKZ() {
        return sOBKZ;
    }

    public void setSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
    }

    public String getKZBEW() {
        return kZBEW;
    }

    public void setKZBEW(String kZBEW) {
        this.kZBEW = kZBEW;
    }

    public String getKZZUG() {
        return kZZUG;
    }

    public void setKZZUG(String kZZUG) {
        this.kZZUG = kZZUG;
    }

    public String getKZVBR() {
        return kZVBR;
    }

    public void setKZVBR(String kZVBR) {
        this.kZVBR = kZVBR;
    }

    public String getBTEXT() {
        return bTEXT;
    }

    public void setBTEXT(String bTEXT) {
        this.bTEXT = bTEXT;
    }

}
