package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muham on 2/18/2018.
 */

public class HeadDetailOpname {

    public HeadDetailOpname() {
    }

    public HeadDetailOpname(String pHYSINVENTORY, String fISCALYEAR, String eVENTTYPE, String pLANT, String sTGELOC, String sPECSTOCK, String dOCDATE, String pLANDATE, String cOUNTDATE, String pSTNGDATE, String fISPERIOD, String uSERNAME, String pOSTBLOCK, String cOUNTSTATUS, String aDJUSTSTATUS, String pHYSINVREF, String dELETESTATUS, String fREEZEBOOKINV, String gROUPINGTYPE, String gROUPINGCRIT, String pHYSINVNO, String pHYSINVNOLONG, String pHYSINVREFLONG) {
        this.pHYSINVENTORY = pHYSINVENTORY;
        this.fISCALYEAR = fISCALYEAR;
        this.eVENTTYPE = eVENTTYPE;
        this.pLANT = pLANT;
        this.sTGELOC = sTGELOC;
        this.sPECSTOCK = sPECSTOCK;
        this.dOCDATE = dOCDATE;
        this.pLANDATE = pLANDATE;
        this.cOUNTDATE = cOUNTDATE;
        this.pSTNGDATE = pSTNGDATE;
        this.fISPERIOD = fISPERIOD;
        this.uSERNAME = uSERNAME;
        this.pOSTBLOCK = pOSTBLOCK;
        this.cOUNTSTATUS = cOUNTSTATUS;
        this.aDJUSTSTATUS = aDJUSTSTATUS;
        this.pHYSINVREF = pHYSINVREF;
        this.dELETESTATUS = dELETESTATUS;
        this.fREEZEBOOKINV = fREEZEBOOKINV;
        this.gROUPINGTYPE = gROUPINGTYPE;
        this.gROUPINGCRIT = gROUPINGCRIT;
        this.pHYSINVNO = pHYSINVNO;
        this.pHYSINVNOLONG = pHYSINVNOLONG;
        this.pHYSINVREFLONG = pHYSINVREFLONG;
    }

    @SerializedName("PHYSINVENTORY")
    @Expose
    private String pHYSINVENTORY;
    @SerializedName("FISCALYEAR")
    @Expose
    private String fISCALYEAR;
    @SerializedName("EVENT_TYPE")
    @Expose
    private String eVENTTYPE;
    @SerializedName("PLANT")
    @Expose
    private String pLANT;
    @SerializedName("STGE_LOC")
    @Expose
    private String sTGELOC;
    @SerializedName("SPEC_STOCK")
    @Expose
    private String sPECSTOCK;
    @SerializedName("DOC_DATE")
    @Expose
    private String dOCDATE;
    @SerializedName("PLAN_DATE")
    @Expose
    private String pLANDATE;
    @SerializedName("COUNT_DATE")
    @Expose
    private String cOUNTDATE;
    @SerializedName("PSTNG_DATE")
    @Expose
    private String pSTNGDATE;
    @SerializedName("FIS_PERIOD")
    @Expose
    private String fISPERIOD;
    @SerializedName("USERNAME")
    @Expose
    private String uSERNAME;
    @SerializedName("POST_BLOCK")
    @Expose
    private String pOSTBLOCK;
    @SerializedName("COUNT_STATUS")
    @Expose
    private String cOUNTSTATUS;
    @SerializedName("ADJUST_STATUS")
    @Expose
    private String aDJUSTSTATUS;
    @SerializedName("PHYS_INV_REF")
    @Expose
    private String pHYSINVREF;
    @SerializedName("DELETE_STATUS")
    @Expose
    private String dELETESTATUS;
    @SerializedName("FREEZEBOOKINV")
    @Expose
    private String fREEZEBOOKINV;
    @SerializedName("GROUPING_TYPE")
    @Expose
    private String gROUPINGTYPE;
    @SerializedName("GROUPING_CRIT")
    @Expose
    private String gROUPINGCRIT;
    @SerializedName("PHYS_INV_NO")
    @Expose
    private String pHYSINVNO;
    @SerializedName("PHYS_INV_NO_LONG")
    @Expose
    private String pHYSINVNOLONG;
    @SerializedName("PHYS_INV_REF_LONG")
    @Expose
    private String pHYSINVREFLONG;

    public String getPHYSINVENTORY() {
        return pHYSINVENTORY;
    }

    public void setPHYSINVENTORY(String pHYSINVENTORY) {
        this.pHYSINVENTORY = pHYSINVENTORY;
    }

    public String getFISCALYEAR() {
        return fISCALYEAR;
    }

    public void setFISCALYEAR(String fISCALYEAR) {
        this.fISCALYEAR = fISCALYEAR;
    }

    public String getEVENTTYPE() {
        return eVENTTYPE;
    }

    public void setEVENTTYPE(String eVENTTYPE) {
        this.eVENTTYPE = eVENTTYPE;
    }

    public String getPLANT() {
        return pLANT;
    }

    public void setPLANT(String pLANT) {
        this.pLANT = pLANT;
    }

    public String getSTGELOC() {
        return sTGELOC;
    }

    public void setSTGELOC(String sTGELOC) {
        this.sTGELOC = sTGELOC;
    }

    public String getSPECSTOCK() {
        return sPECSTOCK;
    }

    public void setSPECSTOCK(String sPECSTOCK) {
        this.sPECSTOCK = sPECSTOCK;
    }

    public String getDOCDATE() {
        return dOCDATE;
    }

    public void setDOCDATE(String dOCDATE) {
        this.dOCDATE = dOCDATE;
    }

    public String getPLANDATE() {
        return pLANDATE;
    }

    public void setPLANDATE(String pLANDATE) {
        this.pLANDATE = pLANDATE;
    }

    public String getCOUNTDATE() {
        return cOUNTDATE;
    }

    public void setCOUNTDATE(String cOUNTDATE) {
        this.cOUNTDATE = cOUNTDATE;
    }

    public String getPSTNGDATE() {
        return pSTNGDATE;
    }

    public void setPSTNGDATE(String pSTNGDATE) {
        this.pSTNGDATE = pSTNGDATE;
    }

    public String getFISPERIOD() {
        return fISPERIOD;
    }

    public void setFISPERIOD(String fISPERIOD) {
        this.fISPERIOD = fISPERIOD;
    }

    public String getUSERNAME() {
        return uSERNAME;
    }

    public void setUSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
    }

    public String getPOSTBLOCK() {
        return pOSTBLOCK;
    }

    public void setPOSTBLOCK(String pOSTBLOCK) {
        this.pOSTBLOCK = pOSTBLOCK;
    }

    public String getCOUNTSTATUS() {
        return cOUNTSTATUS;
    }

    public void setCOUNTSTATUS(String cOUNTSTATUS) {
        this.cOUNTSTATUS = cOUNTSTATUS;
    }

    public String getADJUSTSTATUS() {
        return aDJUSTSTATUS;
    }

    public void setADJUSTSTATUS(String aDJUSTSTATUS) {
        this.aDJUSTSTATUS = aDJUSTSTATUS;
    }

    public String getPHYSINVREF() {
        return pHYSINVREF;
    }

    public void setPHYSINVREF(String pHYSINVREF) {
        this.pHYSINVREF = pHYSINVREF;
    }

    public String getDELETESTATUS() {
        return dELETESTATUS;
    }

    public void setDELETESTATUS(String dELETESTATUS) {
        this.dELETESTATUS = dELETESTATUS;
    }

    public String getFREEZEBOOKINV() {
        return fREEZEBOOKINV;
    }

    public void setFREEZEBOOKINV(String fREEZEBOOKINV) {
        this.fREEZEBOOKINV = fREEZEBOOKINV;
    }

    public String getGROUPINGTYPE() {
        return gROUPINGTYPE;
    }

    public void setGROUPINGTYPE(String gROUPINGTYPE) {
        this.gROUPINGTYPE = gROUPINGTYPE;
    }

    public String getGROUPINGCRIT() {
        return gROUPINGCRIT;
    }

    public void setGROUPINGCRIT(String gROUPINGCRIT) {
        this.gROUPINGCRIT = gROUPINGCRIT;
    }

    public String getPHYSINVNO() {
        return pHYSINVNO;
    }

    public void setPHYSINVNO(String pHYSINVNO) {
        this.pHYSINVNO = pHYSINVNO;
    }

    public String getPHYSINVNOLONG() {
        return pHYSINVNOLONG;
    }

    public void setPHYSINVNOLONG(String pHYSINVNOLONG) {
        this.pHYSINVNOLONG = pHYSINVNOLONG;
    }

    public String getPHYSINVREFLONG() {
        return pHYSINVREFLONG;
    }

    public void setPHYSINVREFLONG(String pHYSINVREFLONG) {
        this.pHYSINVREFLONG = pHYSINVREFLONG;
    }
}
