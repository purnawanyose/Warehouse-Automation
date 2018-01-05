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

public class OpnameItem {

    @SerializedName("PHYSINVENTORY")
    @Expose
    private String pHYSINVENTORY;
    @SerializedName("FISCALYEAR")
    @Expose
    private String fISCALYEAR;
    @SerializedName("ITEM")
    @Expose
    private String iTEM;
    @SerializedName("MATERIAL")
    @Expose
    private String mATERIAL;
    @SerializedName("PLANT")
    @Expose
    private String pLANT;
    @SerializedName("STGE_LOC")
    @Expose
    private String sTGELOC;
    @SerializedName("BATCH")
    @Expose
    private String bATCH;
    @SerializedName("SPEC_STOCK")
    @Expose
    private String sPECSTOCK;
    @SerializedName("STOCK_TYPE")
    @Expose
    private String sTOCKTYPE;
    @SerializedName("SALES_ORD")
    @Expose
    private String sALESORD;
    @SerializedName("S_ORD_ITEM")
    @Expose
    private String sORDITEM;
    @SerializedName("SCHED_LINE")
    @Expose
    private String sCHEDLINE;
    @SerializedName("VENDOR")
    @Expose
    private String vENDOR;
    @SerializedName("CUSTOMER")
    @Expose
    private String cUSTOMER;
    @SerializedName("PRODBINLOC")
    @Expose
    private String pRODBINLOC;
    @SerializedName("CHANGE_USER")
    @Expose
    private String cHANGEUSER;
    @SerializedName("CHANGE_DATE")
    @Expose
    private String cHANGEDATE;
    @SerializedName("COUNT_USER")
    @Expose
    private String cOUNTUSER;
    @SerializedName("COUNT_DATE")
    @Expose
    private String cOUNTDATE;
    @SerializedName("PSTNG_NAME")
    @Expose
    private String pSTNGNAME;
    @SerializedName("PSTNG_DATE")
    @Expose
    private String pSTNGDATE;
    @SerializedName("PH_INV_REF")
    @Expose
    private String pHINVREF;
    @SerializedName("COUNTED")
    @Expose
    private String cOUNTED;
    @SerializedName("DIFF_POSTED")
    @Expose
    private String dIFFPOSTED;
    @SerializedName("RECOUNT")
    @Expose
    private String rECOUNT;
    @SerializedName("DELETE_IND")
    @Expose
    private String dELETEIND;
    @SerializedName("ALT_UNIT")
    @Expose
    private String aLTUNIT;
    @SerializedName("BOOK_QTY")
    @Expose
    private String bOOKQTY;
    @SerializedName("ZERO_COUNT")
    @Expose
    private String zEROCOUNT;
    @SerializedName("QUANTITY")
    @Expose
    private String qUANTITY;
    @SerializedName("BASE_UOM")
    @Expose
    private String bASEUOM;
    @SerializedName("BASE_UOM_ISO")
    @Expose
    private String bASEUOMISO;
    @SerializedName("ENTRY_QNT")
    @Expose
    private String eNTRYQNT;
    @SerializedName("ENTRY_UOM")
    @Expose
    private String eNTRYUOM;
    @SerializedName("ENTRY_UOM_ISO")
    @Expose
    private String eNTRYUOMISO;
    @SerializedName("MAT_DOC")
    @Expose
    private String mATDOC;
    @SerializedName("DOC_YEAR")
    @Expose
    private String dOCYEAR;
    @SerializedName("MATDOC_ITM")
    @Expose
    private String mATDOCITM;
    @SerializedName("RECOUNTDOC")
    @Expose
    private String rECOUNTDOC;
    @SerializedName("DIFFERENCE")
    @Expose
    private String dIFFERENCE;
    @SerializedName("CURRENCY")
    @Expose
    private String cURRENCY;
    @SerializedName("CURRENCY_ISO")
    @Expose
    private String cURRENCYISO;
    @SerializedName("CC_PH_INV")
    @Expose
    private String cCPHINV;
    @SerializedName("WBS_ELEMENT")
    @Expose
    private String wBSELEMENT;
    @SerializedName("SV_INC_VAT")
    @Expose
    private String sVINCVAT;
    @SerializedName("SALES_VAL")
    @Expose
    private String sALESVAL;
    @SerializedName("BOOK_VALUE")
    @Expose
    private String bOOKVALUE;
    @SerializedName("VO_MAT")
    @Expose
    private String vOMAT;
    @SerializedName("SV_W_O_VAT")
    @Expose
    private String sVWOVAT;
    @SerializedName("DIFFSALCNTVAT")
    @Expose
    private String dIFFSALCNTVAT;
    @SerializedName("DIFFSALCNT")
    @Expose
    private String dIFFSALCNT;
    @SerializedName("VALCOUNTQNT")
    @Expose
    private String vALCOUNTQNT;
    @SerializedName("VALBOOKAMT")
    @Expose
    private String vALBOOKAMT;
    @SerializedName("DIFF_VALUE")
    @Expose
    private String dIFFVALUE;
    @SerializedName("REASON")
    @Expose
    private String rEASON;
    @SerializedName("MATERIAL_EXTERNAL")
    @Expose
    private String mATERIALEXTERNAL;
    @SerializedName("MATERIAL_GUID")
    @Expose
    private String mATERIALGUID;
    @SerializedName("MATERIAL_VERSION")
    @Expose
    private String mATERIALVERSION;
    @SerializedName("PH_INV_REF_LONG")
    @Expose
    private String pHINVREFLONG;
    @SerializedName("MATNR_DESCRIPTION")
    @Expose
    private String mATNRDESCRIPTION;

    /**
     * No args constructor for use in serialization
     */
    public OpnameItem() {
    }

    /**
     * @param bATCH
     * @param pHYSINVENTORY
     * @param bASEUOMISO
     * @param cHANGEDATE
     * @param rEASON
     * @param pSTNGNAME
     * @param vENDOR
     * @param wBSELEMENT
     * @param sPECSTOCK
     * @param eNTRYUOMISO
     * @param cCPHINV
     * @param mATERIALGUID
     * @param mATDOC
     * @param dIFFSALCNT
     * @param pSTNGDATE
     * @param cOUNTDATE
     * @param dELETEIND
     * @param sORDITEM
     * @param mATERIALVERSION
     * @param bASEUOM
     * @param cHANGEUSER
     * @param bOOKQTY
     * @param sALESORD
     * @param rECOUNTDOC
     * @param dIFFPOSTED
     * @param mATNRDESCRIPTION
     * @param sVINCVAT
     * @param sCHEDLINE
     * @param fISCALYEAR
     * @param sALESVAL
     * @param sTGELOC
     * @param eNTRYUOM
     * @param aLTUNIT
     * @param cOUNTUSER
     * @param pLANT
     * @param mATDOCITM
     * @param pHINVREFLONG
     * @param zEROCOUNT
     * @param rECOUNT
     * @param cUSTOMER
     * @param iTEM
     * @param sTOCKTYPE
     * @param vALBOOKAMT
     * @param qUANTITY
     * @param dIFFVALUE
     * @param pRODBINLOC
     * @param mATERIAL
     * @param bOOKVALUE
     * @param dIFFERENCE
     * @param vALCOUNTQNT
     * @param cURRENCYISO
     * @param dOCYEAR
     * @param cURRENCY
     * @param cOUNTED
     * @param vOMAT
     * @param eNTRYQNT
     * @param dIFFSALCNTVAT
     * @param pHINVREF
     * @param mATERIALEXTERNAL
     * @param sVWOVAT
     */
    public OpnameItem(String pHYSINVENTORY, String fISCALYEAR, String iTEM, String mATERIAL, String pLANT, String sTGELOC, String bATCH, String sPECSTOCK, String sTOCKTYPE, String sALESORD, String sORDITEM, String sCHEDLINE, String vENDOR, String cUSTOMER, String pRODBINLOC, String cHANGEUSER, String cHANGEDATE, String cOUNTUSER, String cOUNTDATE, String pSTNGNAME, String pSTNGDATE, String pHINVREF, String cOUNTED, String dIFFPOSTED, String rECOUNT, String dELETEIND, String aLTUNIT, String bOOKQTY, String zEROCOUNT, String qUANTITY, String bASEUOM, String bASEUOMISO, String eNTRYQNT, String eNTRYUOM, String eNTRYUOMISO, String mATDOC, String dOCYEAR, String mATDOCITM, String rECOUNTDOC, String dIFFERENCE, String cURRENCY, String cURRENCYISO, String cCPHINV, String wBSELEMENT, String sVINCVAT, String sALESVAL, String bOOKVALUE, String vOMAT, String sVWOVAT, String dIFFSALCNTVAT, String dIFFSALCNT, String vALCOUNTQNT, String vALBOOKAMT, String dIFFVALUE, String rEASON, String mATERIALEXTERNAL, String mATERIALGUID, String mATERIALVERSION, String pHINVREFLONG, String mATNRDESCRIPTION) {
        super();
        this.pHYSINVENTORY = pHYSINVENTORY;
        this.fISCALYEAR = fISCALYEAR;
        this.iTEM = iTEM;
        this.mATERIAL = mATERIAL;
        this.pLANT = pLANT;
        this.sTGELOC = sTGELOC;
        this.bATCH = bATCH;
        this.sPECSTOCK = sPECSTOCK;
        this.sTOCKTYPE = sTOCKTYPE;
        this.sALESORD = sALESORD;
        this.sORDITEM = sORDITEM;
        this.sCHEDLINE = sCHEDLINE;
        this.vENDOR = vENDOR;
        this.cUSTOMER = cUSTOMER;
        this.pRODBINLOC = pRODBINLOC;
        this.cHANGEUSER = cHANGEUSER;
        this.cHANGEDATE = cHANGEDATE;
        this.cOUNTUSER = cOUNTUSER;
        this.cOUNTDATE = cOUNTDATE;
        this.pSTNGNAME = pSTNGNAME;
        this.pSTNGDATE = pSTNGDATE;
        this.pHINVREF = pHINVREF;
        this.cOUNTED = cOUNTED;
        this.dIFFPOSTED = dIFFPOSTED;
        this.rECOUNT = rECOUNT;
        this.dELETEIND = dELETEIND;
        this.aLTUNIT = aLTUNIT;
        this.bOOKQTY = bOOKQTY;
        this.zEROCOUNT = zEROCOUNT;
        this.qUANTITY = qUANTITY;
        this.bASEUOM = bASEUOM;
        this.bASEUOMISO = bASEUOMISO;
        this.eNTRYQNT = eNTRYQNT;
        this.eNTRYUOM = eNTRYUOM;
        this.eNTRYUOMISO = eNTRYUOMISO;
        this.mATDOC = mATDOC;
        this.dOCYEAR = dOCYEAR;
        this.mATDOCITM = mATDOCITM;
        this.rECOUNTDOC = rECOUNTDOC;
        this.dIFFERENCE = dIFFERENCE;
        this.cURRENCY = cURRENCY;
        this.cURRENCYISO = cURRENCYISO;
        this.cCPHINV = cCPHINV;
        this.wBSELEMENT = wBSELEMENT;
        this.sVINCVAT = sVINCVAT;
        this.sALESVAL = sALESVAL;
        this.bOOKVALUE = bOOKVALUE;
        this.vOMAT = vOMAT;
        this.sVWOVAT = sVWOVAT;
        this.dIFFSALCNTVAT = dIFFSALCNTVAT;
        this.dIFFSALCNT = dIFFSALCNT;
        this.vALCOUNTQNT = vALCOUNTQNT;
        this.vALBOOKAMT = vALBOOKAMT;
        this.dIFFVALUE = dIFFVALUE;
        this.rEASON = rEASON;
        this.mATERIALEXTERNAL = mATERIALEXTERNAL;
        this.mATERIALGUID = mATERIALGUID;
        this.mATERIALVERSION = mATERIALVERSION;
        this.pHINVREFLONG = pHINVREFLONG;
        this.mATNRDESCRIPTION = mATNRDESCRIPTION;
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

    public String getITEM() {
        return iTEM;
    }

    public void setITEM(String iTEM) {
        this.iTEM = iTEM;
    }

    public String getMATERIAL() {
        return mATERIAL;
    }

    public void setMATERIAL(String mATERIAL) {
        this.mATERIAL = mATERIAL;
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

    public String getBATCH() {
        return bATCH;
    }

    public void setBATCH(String bATCH) {
        this.bATCH = bATCH;
    }

    public String getSPECSTOCK() {
        return sPECSTOCK;
    }

    public void setSPECSTOCK(String sPECSTOCK) {
        this.sPECSTOCK = sPECSTOCK;
    }

    public String getSTOCKTYPE() {
        return sTOCKTYPE;
    }

    public void setSTOCKTYPE(String sTOCKTYPE) {
        this.sTOCKTYPE = sTOCKTYPE;
    }

    public String getSALESORD() {
        return sALESORD;
    }

    public void setSALESORD(String sALESORD) {
        this.sALESORD = sALESORD;
    }

    public String getSORDITEM() {
        return sORDITEM;
    }

    public void setSORDITEM(String sORDITEM) {
        this.sORDITEM = sORDITEM;
    }

    public String getSCHEDLINE() {
        return sCHEDLINE;
    }

    public void setSCHEDLINE(String sCHEDLINE) {
        this.sCHEDLINE = sCHEDLINE;
    }

    public String getVENDOR() {
        return vENDOR;
    }

    public void setVENDOR(String vENDOR) {
        this.vENDOR = vENDOR;
    }

    public String getCUSTOMER() {
        return cUSTOMER;
    }

    public void setCUSTOMER(String cUSTOMER) {
        this.cUSTOMER = cUSTOMER;
    }

    public String getPRODBINLOC() {
        return pRODBINLOC;
    }

    public void setPRODBINLOC(String pRODBINLOC) {
        this.pRODBINLOC = pRODBINLOC;
    }

    public String getCHANGEUSER() {
        return cHANGEUSER;
    }

    public void setCHANGEUSER(String cHANGEUSER) {
        this.cHANGEUSER = cHANGEUSER;
    }

    public String getCHANGEDATE() {
        return cHANGEDATE;
    }

    public void setCHANGEDATE(String cHANGEDATE) {
        this.cHANGEDATE = cHANGEDATE;
    }

    public String getCOUNTUSER() {
        return cOUNTUSER;
    }

    public void setCOUNTUSER(String cOUNTUSER) {
        this.cOUNTUSER = cOUNTUSER;
    }

    public String getCOUNTDATE() {
        return cOUNTDATE;
    }

    public void setCOUNTDATE(String cOUNTDATE) {
        this.cOUNTDATE = cOUNTDATE;
    }

    public String getPSTNGNAME() {
        return pSTNGNAME;
    }

    public void setPSTNGNAME(String pSTNGNAME) {
        this.pSTNGNAME = pSTNGNAME;
    }

    public String getPSTNGDATE() {
        return pSTNGDATE;
    }

    public void setPSTNGDATE(String pSTNGDATE) {
        this.pSTNGDATE = pSTNGDATE;
    }

    public String getPHINVREF() {
        return pHINVREF;
    }

    public void setPHINVREF(String pHINVREF) {
        this.pHINVREF = pHINVREF;
    }

    public String getCOUNTED() {
        return cOUNTED;
    }

    public void setCOUNTED(String cOUNTED) {
        this.cOUNTED = cOUNTED;
    }

    public String getDIFFPOSTED() {
        return dIFFPOSTED;
    }

    public void setDIFFPOSTED(String dIFFPOSTED) {
        this.dIFFPOSTED = dIFFPOSTED;
    }

    public String getRECOUNT() {
        return rECOUNT;
    }

    public void setRECOUNT(String rECOUNT) {
        this.rECOUNT = rECOUNT;
    }

    public String getDELETEIND() {
        return dELETEIND;
    }

    public void setDELETEIND(String dELETEIND) {
        this.dELETEIND = dELETEIND;
    }

    public String getALTUNIT() {
        return aLTUNIT;
    }

    public void setALTUNIT(String aLTUNIT) {
        this.aLTUNIT = aLTUNIT;
    }

    public String getBOOKQTY() {
        return bOOKQTY;
    }

    public void setBOOKQTY(String bOOKQTY) {
        this.bOOKQTY = bOOKQTY;
    }

    public String getZEROCOUNT() {
        return zEROCOUNT;
    }

    public void setZEROCOUNT(String zEROCOUNT) {
        this.zEROCOUNT = zEROCOUNT;
    }

    public String getQUANTITY() {
        return qUANTITY;
    }

    public void setQUANTITY(String qUANTITY) {
        this.qUANTITY = qUANTITY;
    }

    public String getBASEUOM() {
        return bASEUOM;
    }

    public void setBASEUOM(String bASEUOM) {
        this.bASEUOM = bASEUOM;
    }

    public String getBASEUOMISO() {
        return bASEUOMISO;
    }

    public void setBASEUOMISO(String bASEUOMISO) {
        this.bASEUOMISO = bASEUOMISO;
    }

    public String getENTRYQNT() {
        return eNTRYQNT;
    }

    public void setENTRYQNT(String eNTRYQNT) {
        this.eNTRYQNT = eNTRYQNT;
    }

    public String getENTRYUOM() {
        return eNTRYUOM;
    }

    public void setENTRYUOM(String eNTRYUOM) {
        this.eNTRYUOM = eNTRYUOM;
    }

    public String getENTRYUOMISO() {
        return eNTRYUOMISO;
    }

    public void setENTRYUOMISO(String eNTRYUOMISO) {
        this.eNTRYUOMISO = eNTRYUOMISO;
    }

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

    public String getMATDOCITM() {
        return mATDOCITM;
    }

    public void setMATDOCITM(String mATDOCITM) {
        this.mATDOCITM = mATDOCITM;
    }

    public String getRECOUNTDOC() {
        return rECOUNTDOC;
    }

    public void setRECOUNTDOC(String rECOUNTDOC) {
        this.rECOUNTDOC = rECOUNTDOC;
    }

    public String getDIFFERENCE() {
        return dIFFERENCE;
    }

    public void setDIFFERENCE(String dIFFERENCE) {
        this.dIFFERENCE = dIFFERENCE;
    }

    public String getCURRENCY() {
        return cURRENCY;
    }

    public void setCURRENCY(String cURRENCY) {
        this.cURRENCY = cURRENCY;
    }

    public String getCURRENCYISO() {
        return cURRENCYISO;
    }

    public void setCURRENCYISO(String cURRENCYISO) {
        this.cURRENCYISO = cURRENCYISO;
    }

    public String getCCPHINV() {
        return cCPHINV;
    }

    public void setCCPHINV(String cCPHINV) {
        this.cCPHINV = cCPHINV;
    }

    public String getWBSELEMENT() {
        return wBSELEMENT;
    }

    public void setWBSELEMENT(String wBSELEMENT) {
        this.wBSELEMENT = wBSELEMENT;
    }

    public String getSVINCVAT() {
        return sVINCVAT;
    }

    public void setSVINCVAT(String sVINCVAT) {
        this.sVINCVAT = sVINCVAT;
    }

    public String getSALESVAL() {
        return sALESVAL;
    }

    public void setSALESVAL(String sALESVAL) {
        this.sALESVAL = sALESVAL;
    }

    public String getBOOKVALUE() {
        return bOOKVALUE;
    }

    public void setBOOKVALUE(String bOOKVALUE) {
        this.bOOKVALUE = bOOKVALUE;
    }

    public String getVOMAT() {
        return vOMAT;
    }

    public void setVOMAT(String vOMAT) {
        this.vOMAT = vOMAT;
    }

    public String getSVWOVAT() {
        return sVWOVAT;
    }

    public void setSVWOVAT(String sVWOVAT) {
        this.sVWOVAT = sVWOVAT;
    }

    public String getDIFFSALCNTVAT() {
        return dIFFSALCNTVAT;
    }

    public void setDIFFSALCNTVAT(String dIFFSALCNTVAT) {
        this.dIFFSALCNTVAT = dIFFSALCNTVAT;
    }

    public String getDIFFSALCNT() {
        return dIFFSALCNT;
    }

    public void setDIFFSALCNT(String dIFFSALCNT) {
        this.dIFFSALCNT = dIFFSALCNT;
    }

    public String getVALCOUNTQNT() {
        return vALCOUNTQNT;
    }

    public void setVALCOUNTQNT(String vALCOUNTQNT) {
        this.vALCOUNTQNT = vALCOUNTQNT;
    }

    public String getVALBOOKAMT() {
        return vALBOOKAMT;
    }

    public void setVALBOOKAMT(String vALBOOKAMT) {
        this.vALBOOKAMT = vALBOOKAMT;
    }

    public String getDIFFVALUE() {
        return dIFFVALUE;
    }

    public void setDIFFVALUE(String dIFFVALUE) {
        this.dIFFVALUE = dIFFVALUE;
    }

    public String getREASON() {
        return rEASON;
    }

    public void setREASON(String rEASON) {
        this.rEASON = rEASON;
    }

    public String getMATERIALEXTERNAL() {
        return mATERIALEXTERNAL;
    }

    public void setMATERIALEXTERNAL(String mATERIALEXTERNAL) {
        this.mATERIALEXTERNAL = mATERIALEXTERNAL;
    }

    public String getMATERIALGUID() {
        return mATERIALGUID;
    }

    public void setMATERIALGUID(String mATERIALGUID) {
        this.mATERIALGUID = mATERIALGUID;
    }

    public String getMATERIALVERSION() {
        return mATERIALVERSION;
    }

    public void setMATERIALVERSION(String mATERIALVERSION) {
        this.mATERIALVERSION = mATERIALVERSION;
    }

    public String getPHINVREFLONG() {
        return pHINVREFLONG;
    }

    public void setPHINVREFLONG(String pHINVREFLONG) {
        this.pHINVREFLONG = pHINVREFLONG;
    }

    public String getMATNRDESCRIPTION() {
        return mATNRDESCRIPTION;
    }

    public void setMATNRDESCRIPTION(String mATNRDESCRIPTION) {
        this.mATNRDESCRIPTION = mATNRDESCRIPTION;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pHYSINVENTORY", pHYSINVENTORY).append("fISCALYEAR", fISCALYEAR).append("iTEM", iTEM).append("mATERIAL", mATERIAL).append("pLANT", pLANT).append("sTGELOC", sTGELOC).append("bATCH", bATCH).append("sPECSTOCK", sPECSTOCK).append("sTOCKTYPE", sTOCKTYPE).append("sALESORD", sALESORD).append("sORDITEM", sORDITEM).append("sCHEDLINE", sCHEDLINE).append("vENDOR", vENDOR).append("cUSTOMER", cUSTOMER).append("pRODBINLOC", pRODBINLOC).append("cHANGEUSER", cHANGEUSER).append("cHANGEDATE", cHANGEDATE).append("cOUNTUSER", cOUNTUSER).append("cOUNTDATE", cOUNTDATE).append("pSTNGNAME", pSTNGNAME).append("pSTNGDATE", pSTNGDATE).append("pHINVREF", pHINVREF).append("cOUNTED", cOUNTED).append("dIFFPOSTED", dIFFPOSTED).append("rECOUNT", rECOUNT).append("dELETEIND", dELETEIND).append("aLTUNIT", aLTUNIT).append("bOOKQTY", bOOKQTY).append("zEROCOUNT", zEROCOUNT).append("qUANTITY", qUANTITY).append("bASEUOM", bASEUOM).append("bASEUOMISO", bASEUOMISO).append("eNTRYQNT", eNTRYQNT).append("eNTRYUOM", eNTRYUOM).append("eNTRYUOMISO", eNTRYUOMISO).append("mATDOC", mATDOC).append("dOCYEAR", dOCYEAR).append("mATDOCITM", mATDOCITM).append("rECOUNTDOC", rECOUNTDOC).append("dIFFERENCE", dIFFERENCE).append("cURRENCY", cURRENCY).append("cURRENCYISO", cURRENCYISO).append("cCPHINV", cCPHINV).append("wBSELEMENT", wBSELEMENT).append("sVINCVAT", sVINCVAT).append("sALESVAL", sALESVAL).append("bOOKVALUE", bOOKVALUE).append("vOMAT", vOMAT).append("sVWOVAT", sVWOVAT).append("dIFFSALCNTVAT", dIFFSALCNTVAT).append("dIFFSALCNT", dIFFSALCNT).append("vALCOUNTQNT", vALCOUNTQNT).append("vALBOOKAMT", vALBOOKAMT).append("dIFFVALUE", dIFFVALUE).append("rEASON", rEASON).append("mATERIALEXTERNAL", mATERIALEXTERNAL).append("mATERIALGUID", mATERIALGUID).append("mATERIALVERSION", mATERIALVERSION).append("pHINVREFLONG", pHINVREFLONG).append("mATNRDESCRIPTION", mATNRDESCRIPTION).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bATCH).append(pHYSINVENTORY).append(bASEUOMISO).append(cHANGEDATE).append(rEASON).append(pSTNGNAME).append(vENDOR).append(wBSELEMENT).append(sPECSTOCK).append(eNTRYUOMISO).append(cCPHINV).append(mATERIALGUID).append(mATDOC).append(dIFFSALCNT).append(dELETEIND).append(pSTNGDATE).append(cOUNTDATE).append(sORDITEM).append(mATERIALVERSION).append(bASEUOM).append(bOOKQTY).append(cHANGEUSER).append(sALESORD).append(rECOUNTDOC).append(dIFFPOSTED).append(mATNRDESCRIPTION).append(sVINCVAT).append(sCHEDLINE).append(fISCALYEAR).append(sALESVAL).append(sTGELOC).append(eNTRYUOM).append(aLTUNIT).append(cOUNTUSER).append(pLANT).append(mATDOCITM).append(pHINVREFLONG).append(zEROCOUNT).append(rECOUNT).append(cUSTOMER).append(iTEM).append(sTOCKTYPE).append(vALBOOKAMT).append(qUANTITY).append(dIFFVALUE).append(pRODBINLOC).append(mATERIAL).append(bOOKVALUE).append(dIFFERENCE).append(vALCOUNTQNT).append(cURRENCYISO).append(dOCYEAR).append(cURRENCY).append(vOMAT).append(cOUNTED).append(eNTRYQNT).append(dIFFSALCNTVAT).append(pHINVREF).append(mATERIALEXTERNAL).append(sVWOVAT).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof OpnameItem)) {
            return false;
        }
        OpnameItem rhs = ((OpnameItem) other);
        return new EqualsBuilder().append(bATCH, rhs.bATCH).append(pHYSINVENTORY, rhs.pHYSINVENTORY).append(bASEUOMISO, rhs.bASEUOMISO).append(cHANGEDATE, rhs.cHANGEDATE).append(rEASON, rhs.rEASON).append(pSTNGNAME, rhs.pSTNGNAME).append(vENDOR, rhs.vENDOR).append(wBSELEMENT, rhs.wBSELEMENT).append(sPECSTOCK, rhs.sPECSTOCK).append(eNTRYUOMISO, rhs.eNTRYUOMISO).append(cCPHINV, rhs.cCPHINV).append(mATERIALGUID, rhs.mATERIALGUID).append(mATDOC, rhs.mATDOC).append(dIFFSALCNT, rhs.dIFFSALCNT).append(dELETEIND, rhs.dELETEIND).append(pSTNGDATE, rhs.pSTNGDATE).append(cOUNTDATE, rhs.cOUNTDATE).append(sORDITEM, rhs.sORDITEM).append(mATERIALVERSION, rhs.mATERIALVERSION).append(bASEUOM, rhs.bASEUOM).append(bOOKQTY, rhs.bOOKQTY).append(cHANGEUSER, rhs.cHANGEUSER).append(sALESORD, rhs.sALESORD).append(rECOUNTDOC, rhs.rECOUNTDOC).append(dIFFPOSTED, rhs.dIFFPOSTED).append(mATNRDESCRIPTION, rhs.mATNRDESCRIPTION).append(sVINCVAT, rhs.sVINCVAT).append(sCHEDLINE, rhs.sCHEDLINE).append(fISCALYEAR, rhs.fISCALYEAR).append(sALESVAL, rhs.sALESVAL).append(sTGELOC, rhs.sTGELOC).append(eNTRYUOM, rhs.eNTRYUOM).append(aLTUNIT, rhs.aLTUNIT).append(cOUNTUSER, rhs.cOUNTUSER).append(pLANT, rhs.pLANT).append(mATDOCITM, rhs.mATDOCITM).append(pHINVREFLONG, rhs.pHINVREFLONG).append(zEROCOUNT, rhs.zEROCOUNT).append(rECOUNT, rhs.rECOUNT).append(cUSTOMER, rhs.cUSTOMER).append(iTEM, rhs.iTEM).append(sTOCKTYPE, rhs.sTOCKTYPE).append(vALBOOKAMT, rhs.vALBOOKAMT).append(qUANTITY, rhs.qUANTITY).append(dIFFVALUE, rhs.dIFFVALUE).append(pRODBINLOC, rhs.pRODBINLOC).append(mATERIAL, rhs.mATERIAL).append(bOOKVALUE, rhs.bOOKVALUE).append(dIFFERENCE, rhs.dIFFERENCE).append(vALCOUNTQNT, rhs.vALCOUNTQNT).append(cURRENCYISO, rhs.cURRENCYISO).append(dOCYEAR, rhs.dOCYEAR).append(cURRENCY, rhs.cURRENCY).append(vOMAT, rhs.vOMAT).append(cOUNTED, rhs.cOUNTED).append(eNTRYQNT, rhs.eNTRYQNT).append(dIFFSALCNTVAT, rhs.dIFFSALCNTVAT).append(pHINVREF, rhs.pHINVREF).append(mATERIALEXTERNAL, rhs.mATERIALEXTERNAL).append(sVWOVAT, rhs.sVWOVAT).isEquals();
    }
}
