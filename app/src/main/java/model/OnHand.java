package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muham on 1/10/2018.
 */

public class OnHand {

    public OnHand() {
    }

    public OnHand(String mATNO, String mATDESC, String pLANT, String sLOC, String wHSNO, String sTYPE, String sBIN, String qUANT, String vALTYPE, String sPCSTK, String wBS, String qUANTITY, String uOM) {

        this.mATNO = mATNO;
        this.mATDESC = mATDESC;
        this.pLANT = pLANT;
        this.sLOC = sLOC;
        this.wHSNO = wHSNO;
        this.sTYPE = sTYPE;
        this.sBIN = sBIN;
        this.qUANT = qUANT;
        this.vALTYPE = vALTYPE;
        this.sPCSTK = sPCSTK;
        this.wBS = wBS;
        this.qUANTITY = qUANTITY;
        this.uOM = uOM;
    }

    @SerializedName("MATNO")
    @Expose
    private String mATNO;
    @SerializedName("MATDESC")
    @Expose
    private String mATDESC;
    @SerializedName("PLANT")
    @Expose
    private String pLANT;
    @SerializedName("SLOC")
    @Expose
    private String sLOC;
    @SerializedName("WHSNO")
    @Expose
    private String wHSNO;
    @SerializedName("STYPE")
    @Expose
    private String sTYPE;
    @SerializedName("SBIN")
    @Expose
    private String sBIN;
    @SerializedName("QUANT")
    @Expose
    private String qUANT;
    @SerializedName("VALTYPE")
    @Expose
    private String vALTYPE;
    @SerializedName("SPC_STK")
    @Expose
    private String sPCSTK;
    @SerializedName("WBS")
    @Expose
    private String wBS;
    @SerializedName("QUANTITY")
    @Expose
    private String qUANTITY;
    @SerializedName("UOM")
    @Expose
    private String uOM;

    public String getMATNO() {
        return mATNO;
    }

    public void setMATNO(String mATNO) {
        this.mATNO = mATNO;
    }

    public String getMATDESC() {
        return mATDESC;
    }

    public void setMATDESC(String mATDESC) {
        this.mATDESC = mATDESC;
    }

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

    public String getWHSNO() {
        return wHSNO;
    }

    public void setWHSNO(String wHSNO) {
        this.wHSNO = wHSNO;
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

    public String getQUANT() {
        return qUANT;
    }

    public void setQUANT(String qUANT) {
        this.qUANT = qUANT;
    }

    public String getVALTYPE() {
        return vALTYPE;
    }

    public void setVALTYPE(String vALTYPE) {
        this.vALTYPE = vALTYPE;
    }

    public String getSPCSTK() {
        return sPCSTK;
    }

    public void setSPCSTK(String sPCSTK) {
        this.sPCSTK = sPCSTK;
    }

    public String getWBS() {
        return wBS;
    }

    public void setWBS(String wBS) {
        this.wBS = wBS;
    }

    public String getQUANTITY() {
        return qUANTITY;
    }

    public void setQUANTITY(String qUANTITY) {
        this.qUANTITY = qUANTITY;
    }

    public String getUOM() {
        return uOM;
    }

    public void setUOM(String uOM) {
        this.uOM = uOM;
    }
}
