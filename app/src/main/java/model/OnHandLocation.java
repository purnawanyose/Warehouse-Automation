package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muham on 1/22/2018.
 */

public class OnHandLocation {
    public OnHandLocation() {
    }

    public OnHandLocation(String tYPE, String iD, String nUMBER, String mESSAGE, String lOGNO, String lOGMSGNO, String mESSAGEV1, String mESSAGEV2, String mESSAGEV3, String mESSAGEV4, String pARAMETER, String rOW, String fIELD, String sYSTEM, String pLANT, String sLOC, String bATCH, String sS, String sSK, String qTY, String wHN, String sTYPE, String sBIN) {
        this.tYPE = tYPE;
        this.iD = iD;
        this.nUMBER = nUMBER;
        this.mESSAGE = mESSAGE;
        this.lOGNO = lOGNO;
        this.lOGMSGNO = lOGMSGNO;
        this.mESSAGEV1 = mESSAGEV1;
        this.mESSAGEV2 = mESSAGEV2;
        this.mESSAGEV3 = mESSAGEV3;
        this.mESSAGEV4 = mESSAGEV4;
        this.pARAMETER = pARAMETER;
        this.rOW = rOW;
        this.fIELD = fIELD;
        this.sYSTEM = sYSTEM;
        this.pLANT = pLANT;
        this.sLOC = sLOC;
        this.bATCH = bATCH;
        this.sS = sS;
        this.sSK = sSK;
        this.qTY = qTY;
        this.wHN = wHN;
        this.sTYPE = sTYPE;
        this.sBIN = sBIN;
    }

    @SerializedName("TYPE")
    @Expose
    private String tYPE;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("NUMBER")
    @Expose
    private String nUMBER;
    @SerializedName("MESSAGE")
    @Expose
    private String mESSAGE;
    @SerializedName("LOG_NO")
    @Expose
    private String lOGNO;
    @SerializedName("LOG_MSG_NO")
    @Expose
    private String lOGMSGNO;
    @SerializedName("MESSAGE_V1")
    @Expose
    private String mESSAGEV1;
    @SerializedName("MESSAGE_V2")
    @Expose
    private String mESSAGEV2;
    @SerializedName("MESSAGE_V3")
    @Expose
    private String mESSAGEV3;
    @SerializedName("MESSAGE_V4")
    @Expose
    private String mESSAGEV4;
    @SerializedName("PARAMETER")
    @Expose
    private String pARAMETER;
    @SerializedName("ROW")
    @Expose
    private String rOW;
    @SerializedName("FIELD")
    @Expose
    private String fIELD;
    @SerializedName("SYSTEM")
    @Expose
    private String sYSTEM;
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


    public String getTYPE() {
        return tYPE;
    }

    public void setTYPE(String tYPE) {
        this.tYPE = tYPE;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getNUMBER() {
        return nUMBER;
    }

    public void setNUMBER(String nUMBER) {
        this.nUMBER = nUMBER;
    }

    public String getMESSAGE() {
        return mESSAGE;
    }

    public void setMESSAGE(String mESSAGE) {
        this.mESSAGE = mESSAGE;
    }

    public String getLOGNO() {
        return lOGNO;
    }

    public void setLOGNO(String lOGNO) {
        this.lOGNO = lOGNO;
    }

    public String getLOGMSGNO() {
        return lOGMSGNO;
    }

    public void setLOGMSGNO(String lOGMSGNO) {
        this.lOGMSGNO = lOGMSGNO;
    }

    public String getMESSAGEV1() {
        return mESSAGEV1;
    }

    public void setMESSAGEV1(String mESSAGEV1) {
        this.mESSAGEV1 = mESSAGEV1;
    }

    public String getMESSAGEV2() {
        return mESSAGEV2;
    }

    public void setMESSAGEV2(String mESSAGEV2) {
        this.mESSAGEV2 = mESSAGEV2;
    }

    public String getMESSAGEV3() {
        return mESSAGEV3;
    }

    public void setMESSAGEV3(String mESSAGEV3) {
        this.mESSAGEV3 = mESSAGEV3;
    }

    public String getMESSAGEV4() {
        return mESSAGEV4;
    }

    public void setMESSAGEV4(String mESSAGEV4) {
        this.mESSAGEV4 = mESSAGEV4;
    }

    public String getPARAMETER() {
        return pARAMETER;
    }

    public void setPARAMETER(String pARAMETER) {
        this.pARAMETER = pARAMETER;
    }

    public String getROW() {
        return rOW;
    }

    public void setROW(String rOW) {
        this.rOW = rOW;
    }

    public String getFIELD() {
        return fIELD;
    }

    public void setFIELD(String fIELD) {
        this.fIELD = fIELD;
    }

    public String getSYSTEM() {
        return sYSTEM;
    }

    public void setSYSTEM(String sYSTEM) {
        this.sYSTEM = sYSTEM;
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
