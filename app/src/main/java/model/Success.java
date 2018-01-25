package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muham on 1/24/2018.
 */

public class Success {
    @SerializedName("PLANT")
    @Expose
    private String pLANT;
    @SerializedName("SLOC")
    @Expose
    private String sLOC;
    @SerializedName("BATCH")
    @Expose
    private String bATCH;
    @SerializedName("SS")
    @Expose
    private String sS;
    @SerializedName("SSK")
    @Expose
    private String sSK;
    @SerializedName("QTY")
    @Expose
    private String qTY;
    @SerializedName("WHN")
    @Expose
    private String wHN;
    @SerializedName("STYPE")
    @Expose
    private String sTYPE;
    @SerializedName("SBIN")
    @Expose
    private String sBIN;

    public String getPLANT() {
        return pLANT;
    }

    public void setPLANT(String pLANT) {
        this.pLANT = pLANT;
    }

    public String getSLOC() {
        return sLOC;
    }

    public void setSLOC(String sLOC) {
        this.sLOC = sLOC;
    }

    public String getBATCH() {
        return bATCH;
    }

    public void setBATCH(String bATCH) {
        this.bATCH = bATCH;
    }

    public String getSS() {
        return sS;
    }

    public void setSS(String sS) {
        this.sS = sS;
    }

    public String getSSK() {
        return sSK;
    }

    public void setSSK(String sSK) {
        this.sSK = sSK;
    }

    public String getQTY() {
        return qTY;
    }

    public void setQTY(String qTY) {
        this.qTY = qTY;
    }

    public String getWHN() {
        return wHN;
    }

    public void setWHN(String wHN) {
        this.wHN = wHN;
    }

    public String getSTYPE() {
        return sTYPE;
    }

    public void setSTYPE(String sTYPE) {
        this.sTYPE = sTYPE;
    }

    public String getSBIN() {
        return sBIN;
    }

    public void setSBIN(String sBIN) {
        this.sBIN = sBIN;
    }
}
