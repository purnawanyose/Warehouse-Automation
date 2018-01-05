package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by harrisfz
 * ubilih@gmail.com
 * harris.febryantony@sisi.id
 * on 11/9/17.
 */


public class Head {

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

    /**
     * No args constructor for use in serialization
     */
    public Head() {
    }

    /**
     * @param cOUNTSTATUS
     * @param pOSTBLOCK
     * @param gROUPINGTYPE
     * @param fISCALYEAR
     * @param dELETESTATUS
     * @param sTGELOC
     * @param cOUNTDATE
     * @param pSTNGDATE
     * @param pHYSINVENTORY
     * @param eVENTTYPE
     * @param fISPERIOD
     * @param pLANDATE
     * @param pHYSINVREF
     * @param pLANT
     * @param dOCDATE
     * @param fREEZEBOOKINV
     * @param uSERNAME
     * @param sPECSTOCK
     * @param aDJUSTSTATUS
     * @param pHYSINVNOLONG
     * @param gROUPINGCRIT
     * @param pHYSINVNO
     * @param pHYSINVREFLONG
     */
    public Head(String pHYSINVENTORY, String fISCALYEAR, String eVENTTYPE, String pLANT, String sTGELOC, String sPECSTOCK, String dOCDATE, String pLANDATE, String cOUNTDATE, String pSTNGDATE, String fISPERIOD, String uSERNAME, String pOSTBLOCK, String cOUNTSTATUS, String aDJUSTSTATUS, String pHYSINVREF, String dELETESTATUS, String fREEZEBOOKINV, String gROUPINGTYPE, String gROUPINGCRIT, String pHYSINVNO, String pHYSINVNOLONG, String pHYSINVREFLONG) {
        super();
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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pHYSINVENTORY", pHYSINVENTORY).append("fISCALYEAR", fISCALYEAR).append("eVENTTYPE", eVENTTYPE).append("pLANT", pLANT).append("sTGELOC", sTGELOC).append("sPECSTOCK", sPECSTOCK).append("dOCDATE", dOCDATE).append("pLANDATE", pLANDATE).append("cOUNTDATE", cOUNTDATE).append("pSTNGDATE", pSTNGDATE).append("fISPERIOD", fISPERIOD).append("uSERNAME", uSERNAME).append("pOSTBLOCK", pOSTBLOCK).append("cOUNTSTATUS", cOUNTSTATUS).append("aDJUSTSTATUS", aDJUSTSTATUS).append("pHYSINVREF", pHYSINVREF).append("dELETESTATUS", dELETESTATUS).append("fREEZEBOOKINV", fREEZEBOOKINV).append("gROUPINGTYPE", gROUPINGTYPE).append("gROUPINGCRIT", gROUPINGCRIT).append("pHYSINVNO", pHYSINVNO).append("pHYSINVNOLONG", pHYSINVNOLONG).append("pHYSINVREFLONG", pHYSINVREFLONG).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cOUNTSTATUS).append(pOSTBLOCK).append(gROUPINGTYPE).append(fISCALYEAR).append(dELETESTATUS).append(pSTNGDATE).append(cOUNTDATE).append(sTGELOC).append(eVENTTYPE).append(pHYSINVENTORY).append(fISPERIOD).append(pLANDATE).append(pHYSINVREF).append(pLANT).append(dOCDATE).append(fREEZEBOOKINV).append(uSERNAME).append(sPECSTOCK).append(aDJUSTSTATUS).append(pHYSINVNOLONG).append(gROUPINGCRIT).append(pHYSINVNO).append(pHYSINVREFLONG).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Head)) {
            return false;
        }
        Head rhs = ((Head) other);
        return new EqualsBuilder().append(cOUNTSTATUS, rhs.cOUNTSTATUS).append(pOSTBLOCK, rhs.pOSTBLOCK).append(gROUPINGTYPE, rhs.gROUPINGTYPE).append(fISCALYEAR, rhs.fISCALYEAR).append(dELETESTATUS, rhs.dELETESTATUS).append(pSTNGDATE, rhs.pSTNGDATE).append(cOUNTDATE, rhs.cOUNTDATE).append(sTGELOC, rhs.sTGELOC).append(eVENTTYPE, rhs.eVENTTYPE).append(pHYSINVENTORY, rhs.pHYSINVENTORY).append(fISPERIOD, rhs.fISPERIOD).append(pLANDATE, rhs.pLANDATE).append(pHYSINVREF, rhs.pHYSINVREF).append(pLANT, rhs.pLANT).append(dOCDATE, rhs.dOCDATE).append(fREEZEBOOKINV, rhs.fREEZEBOOKINV).append(uSERNAME, rhs.uSERNAME).append(sPECSTOCK, rhs.sPECSTOCK).append(aDJUSTSTATUS, rhs.aDJUSTSTATUS).append(pHYSINVNOLONG, rhs.pHYSINVNOLONG).append(gROUPINGCRIT, rhs.gROUPINGCRIT).append(pHYSINVNO, rhs.pHYSINVNO).append(pHYSINVREFLONG, rhs.pHYSINVREFLONG).isEquals();
    }

}
