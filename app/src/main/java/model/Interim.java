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

public class Interim {

    @SerializedName("MAKTX")
    @Expose
    private String mAKTX;
    @SerializedName("MANDT")
    @Expose
    private String mANDT;
    @SerializedName("LGNUM")
    @Expose
    private String lGNUM;
    @SerializedName("LQNUM")
    @Expose
    private String lQNUM;
    @SerializedName("MATNR")
    @Expose
    private String mATNR;
    @SerializedName("WERKS")
    @Expose
    private String wERKS;
    @SerializedName("CHARG")
    @Expose
    private String cHARG;
    @SerializedName("BESTQ")
    @Expose
    private String bESTQ;
    @SerializedName("SOBKZ")
    @Expose
    private String sOBKZ;
    @SerializedName("SONUM")
    @Expose
    private String sONUM;
    @SerializedName("LGTYP")
    @Expose
    private String lGTYP;
    @SerializedName("LGPLA")
    @Expose
    private String lGPLA;
    @SerializedName("PLPOS")
    @Expose
    private String pLPOS;
    @SerializedName("SKZUE")
    @Expose
    private String sKZUE;
    @SerializedName("SKZUA")
    @Expose
    private String sKZUA;
    @SerializedName("SKZSE")
    @Expose
    private String sKZSE;
    @SerializedName("SKZSA")
    @Expose
    private String sKZSA;
    @SerializedName("SKZSI")
    @Expose
    private String sKZSI;
    @SerializedName("SPGRU")
    @Expose
    private String sPGRU;
    @SerializedName("ZEUGN")
    @Expose
    private String zEUGN;
    @SerializedName("BDATU")
    @Expose
    private String bDATU;
    @SerializedName("BZEIT")
    @Expose
    private String bZEIT;
    @SerializedName("BTANR")
    @Expose
    private String bTANR;
    @SerializedName("BTAPS")
    @Expose
    private String bTAPS;
    @SerializedName("EDATU")
    @Expose
    private String eDATU;
    @SerializedName("EZEIT")
    @Expose
    private String eZEIT;
    @SerializedName("ADATU")
    @Expose
    private String aDATU;
    @SerializedName("AZEIT")
    @Expose
    private String aZEIT;
    @SerializedName("ZDATU")
    @Expose
    private String zDATU;
    @SerializedName("WDATU")
    @Expose
    private String wDATU;
    @SerializedName("WENUM")
    @Expose
    private String wENUM;
    @SerializedName("WEPOS")
    @Expose
    private String wEPOS;
    @SerializedName("LETYP")
    @Expose
    private String lETYP;
    @SerializedName("MEINS")
    @Expose
    private String mEINS;
    @SerializedName("GESME")
    @Expose
    private String gESME;
    @SerializedName("VERME")
    @Expose
    private String vERME;
    @SerializedName("EINME")
    @Expose
    private String eINME;
    @SerializedName("AUSME")
    @Expose
    private String aUSME;
    @SerializedName("MGEWI")
    @Expose
    private String mGEWI;
    @SerializedName("GEWEI")
    @Expose
    private String gEWEI;
    @SerializedName("TBNUM")
    @Expose
    private String tBNUM;
    @SerializedName("IVNUM")
    @Expose
    private String iVNUM;
    @SerializedName("IVPOS")
    @Expose
    private String iVPOS;
    @SerializedName("BETYP")
    @Expose
    private String bETYP;
    @SerializedName("BENUM")
    @Expose
    private String bENUM;
    @SerializedName("LENUM")
    @Expose
    private String lENUM;
    @SerializedName("QPLOS")
    @Expose
    private String qPLOS;
    @SerializedName("VFDAT")
    @Expose
    private String vFDAT;
    @SerializedName("QKAPV")
    @Expose
    private String qKAPV;
    @SerializedName("KOBER")
    @Expose
    private String kOBER;
    @SerializedName("LGORT")
    @Expose
    private String lGORT;
    @SerializedName("VIRGO")
    @Expose
    private String vIRGO;
    @SerializedName("TRAME")
    @Expose
    private String tRAME;
    @SerializedName("KZHUQ")
    @Expose
    private String kZHUQ;
    @SerializedName("VBELN")
    @Expose
    private String vBELN;
    @SerializedName("POSNR")
    @Expose
    private String pOSNR;
    @SerializedName("IDATU")
    @Expose
    private String iDATU;

    /**
     * No args constructor for use in serialization
     */
    public Interim() {
    }

    /**
     * @param sKZSI
     * @param cHARG
     * @param wEPOS
     * @param sKZSE
     * @param gEWEI
     * @param sKZSA
     * @param sPGRU
     * @param bENUM
     * @param vFDAT
     * @param wDATU
     * @param mEINS
     * @param eDATU
     * @param lETYP
     * @param aDATU
     * @param bTAPS
     * @param aUSME
     * @param zEUGN
     * @param zDATU
     * @param bETYP
     * @param iVNUM
     * @param lGTYP
     * @param lGPLA
     * @param tRAME
     * @param tBNUM
     * @param iVPOS
     * @param kZHUQ
     * @param bDATU
     * @param kOBER
     * @param qKAPV
     * @param lQNUM
     * @param mGEWI
     * @param vERME
     * @param sKZUA
     * @param sOBKZ
     * @param sKZUE
     * @param eINME
     * @param sONUM
     * @param bZEIT
     * @param wENUM
     * @param pOSNR
     * @param vIRGO
     * @param gESME
     * @param pLPOS
     * @param lENUM
     * @param vBELN
     * @param mATNR
     * @param lGORT
     * @param lGNUM
     * @param bTANR
     * @param iDATU
     * @param bESTQ
     * @param wERKS
     * @param eZEIT
     * @param aZEIT
     * @param mANDT
     * @param qPLOS
     * @param mAKTX
     */
    public Interim(String mAKTX, String mANDT, String lGNUM, String lQNUM, String mATNR, String wERKS, String cHARG, String bESTQ, String sOBKZ, String sONUM, String lGTYP, String lGPLA, String pLPOS, String sKZUE, String sKZUA, String sKZSE, String sKZSA, String sKZSI, String sPGRU, String zEUGN, String bDATU, String bZEIT, String bTANR, String bTAPS, String eDATU, String eZEIT, String aDATU, String aZEIT, String zDATU, String wDATU, String wENUM, String wEPOS, String lETYP, String mEINS, String gESME, String vERME, String eINME, String aUSME, String mGEWI, String gEWEI, String tBNUM, String iVNUM, String iVPOS, String bETYP, String bENUM, String lENUM, String qPLOS, String vFDAT, String qKAPV, String kOBER, String lGORT, String vIRGO, String tRAME, String kZHUQ, String vBELN, String pOSNR, String iDATU) {
        super();
        this.mAKTX = mAKTX;
        this.mANDT = mANDT;
        this.lGNUM = lGNUM;
        this.lQNUM = lQNUM;
        this.mATNR = mATNR;
        this.wERKS = wERKS;
        this.cHARG = cHARG;
        this.bESTQ = bESTQ;
        this.sOBKZ = sOBKZ;
        this.sONUM = sONUM;
        this.lGTYP = lGTYP;
        this.lGPLA = lGPLA;
        this.pLPOS = pLPOS;
        this.sKZUE = sKZUE;
        this.sKZUA = sKZUA;
        this.sKZSE = sKZSE;
        this.sKZSA = sKZSA;
        this.sKZSI = sKZSI;
        this.sPGRU = sPGRU;
        this.zEUGN = zEUGN;
        this.bDATU = bDATU;
        this.bZEIT = bZEIT;
        this.bTANR = bTANR;
        this.bTAPS = bTAPS;
        this.eDATU = eDATU;
        this.eZEIT = eZEIT;
        this.aDATU = aDATU;
        this.aZEIT = aZEIT;
        this.zDATU = zDATU;
        this.wDATU = wDATU;
        this.wENUM = wENUM;
        this.wEPOS = wEPOS;
        this.lETYP = lETYP;
        this.mEINS = mEINS;
        this.gESME = gESME;
        this.vERME = vERME;
        this.eINME = eINME;
        this.aUSME = aUSME;
        this.mGEWI = mGEWI;
        this.gEWEI = gEWEI;
        this.tBNUM = tBNUM;
        this.iVNUM = iVNUM;
        this.iVPOS = iVPOS;
        this.bETYP = bETYP;
        this.bENUM = bENUM;
        this.lENUM = lENUM;
        this.qPLOS = qPLOS;
        this.vFDAT = vFDAT;
        this.qKAPV = qKAPV;
        this.kOBER = kOBER;
        this.lGORT = lGORT;
        this.vIRGO = vIRGO;
        this.tRAME = tRAME;
        this.kZHUQ = kZHUQ;
        this.vBELN = vBELN;
        this.pOSNR = pOSNR;
        this.iDATU = iDATU;
    }

    public String getmAKTX() {
        return mAKTX;
    }

    public void setmAKTX(String mAKTX) {
        this.mAKTX= mAKTX;
    }

    public Interim withMAKTX(String mAKTX) {
        this.mAKTX = mAKTX;
        return this;
    }

    public String getMANDT() {
        return mANDT;
    }

    public void setMANDT(String mANDT) {
        this.mANDT = mANDT;
    }

    public Interim withMANDT(String mANDT) {
        this.mANDT = mANDT;
        return this;
    }

    public String getLGNUM() {
        return lGNUM;
    }

    public void setLGNUM(String lGNUM) {
        this.lGNUM = lGNUM;
    }

    public Interim withLGNUM(String lGNUM) {
        this.lGNUM = lGNUM;
        return this;
    }

    public String getLQNUM() {
        return lQNUM;
    }

    public void setLQNUM(String lQNUM) {
        this.lQNUM = lQNUM;
    }

    public Interim withLQNUM(String lQNUM) {
        this.lQNUM = lQNUM;
        return this;
    }

    public String getMATNR() {
        return mATNR;
    }

    public void setMATNR(String mATNR) {
        this.mATNR = mATNR;
    }

    public Interim withMATNR(String mATNR) {
        this.mATNR = mATNR;
        return this;
    }

    public String getWERKS() {
        return wERKS;
    }

    public void setWERKS(String wERKS) {
        this.wERKS = wERKS;
    }

    public Interim withWERKS(String wERKS) {
        this.wERKS = wERKS;
        return this;
    }

    public String getCHARG() {
        return cHARG;
    }

    public void setCHARG(String cHARG) {
        this.cHARG = cHARG;
    }

    public Interim withCHARG(String cHARG) {
        this.cHARG = cHARG;
        return this;
    }

    public String getBESTQ() {
        return bESTQ;
    }

    public void setBESTQ(String bESTQ) {
        this.bESTQ = bESTQ;
    }

    public Interim withBESTQ(String bESTQ) {
        this.bESTQ = bESTQ;
        return this;
    }

    public String getSOBKZ() {
        return sOBKZ;
    }

    public void setSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
    }

    public Interim withSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
        return this;
    }

    public String getSONUM() {
        return sONUM;
    }

    public void setSONUM(String sONUM) {
        this.sONUM = sONUM;
    }

    public Interim withSONUM(String sONUM) {
        this.sONUM = sONUM;
        return this;
    }

    public String getLGTYP() {
        return lGTYP;
    }

    public void setLGTYP(String lGTYP) {
        this.lGTYP = lGTYP;
    }

    public Interim withLGTYP(String lGTYP) {
        this.lGTYP = lGTYP;
        return this;
    }

    public String getLGPLA() {
        return lGPLA;
    }

    public void setLGPLA(String lGPLA) {
        this.lGPLA = lGPLA;
    }

    public Interim withLGPLA(String lGPLA) {
        this.lGPLA = lGPLA;
        return this;
    }

    public String getPLPOS() {
        return pLPOS;
    }

    public void setPLPOS(String pLPOS) {
        this.pLPOS = pLPOS;
    }

    public Interim withPLPOS(String pLPOS) {
        this.pLPOS = pLPOS;
        return this;
    }

    public String getSKZUE() {
        return sKZUE;
    }

    public void setSKZUE(String sKZUE) {
        this.sKZUE = sKZUE;
    }

    public Interim withSKZUE(String sKZUE) {
        this.sKZUE = sKZUE;
        return this;
    }

    public String getSKZUA() {
        return sKZUA;
    }

    public void setSKZUA(String sKZUA) {
        this.sKZUA = sKZUA;
    }

    public Interim withSKZUA(String sKZUA) {
        this.sKZUA = sKZUA;
        return this;
    }

    public String getSKZSE() {
        return sKZSE;
    }

    public void setSKZSE(String sKZSE) {
        this.sKZSE = sKZSE;
    }

    public Interim withSKZSE(String sKZSE) {
        this.sKZSE = sKZSE;
        return this;
    }

    public String getSKZSA() {
        return sKZSA;
    }

    public void setSKZSA(String sKZSA) {
        this.sKZSA = sKZSA;
    }

    public Interim withSKZSA(String sKZSA) {
        this.sKZSA = sKZSA;
        return this;
    }

    public String getSKZSI() {
        return sKZSI;
    }

    public void setSKZSI(String sKZSI) {
        this.sKZSI = sKZSI;
    }

    public Interim withSKZSI(String sKZSI) {
        this.sKZSI = sKZSI;
        return this;
    }

    public String getSPGRU() {
        return sPGRU;
    }

    public void setSPGRU(String sPGRU) {
        this.sPGRU = sPGRU;
    }

    public Interim withSPGRU(String sPGRU) {
        this.sPGRU = sPGRU;
        return this;
    }

    public String getZEUGN() {
        return zEUGN;
    }

    public void setZEUGN(String zEUGN) {
        this.zEUGN = zEUGN;
    }

    public Interim withZEUGN(String zEUGN) {
        this.zEUGN = zEUGN;
        return this;
    }

    public String getBDATU() {
        return bDATU;
    }

    public void setBDATU(String bDATU) {
        this.bDATU = bDATU;
    }

    public Interim withBDATU(String bDATU) {
        this.bDATU = bDATU;
        return this;
    }

    public String getBZEIT() {
        return bZEIT;
    }

    public void setBZEIT(String bZEIT) {
        this.bZEIT = bZEIT;
    }

    public Interim withBZEIT(String bZEIT) {
        this.bZEIT = bZEIT;
        return this;
    }

    public String getBTANR() {
        return bTANR;
    }

    public void setBTANR(String bTANR) {
        this.bTANR = bTANR;
    }

    public Interim withBTANR(String bTANR) {
        this.bTANR = bTANR;
        return this;
    }

    public String getBTAPS() {
        return bTAPS;
    }

    public void setBTAPS(String bTAPS) {
        this.bTAPS = bTAPS;
    }

    public Interim withBTAPS(String bTAPS) {
        this.bTAPS = bTAPS;
        return this;
    }

    public String getEDATU() {
        return eDATU;
    }

    public void setEDATU(String eDATU) {
        this.eDATU = eDATU;
    }

    public Interim withEDATU(String eDATU) {
        this.eDATU = eDATU;
        return this;
    }

    public String getEZEIT() {
        return eZEIT;
    }

    public void setEZEIT(String eZEIT) {
        this.eZEIT = eZEIT;
    }

    public Interim withEZEIT(String eZEIT) {
        this.eZEIT = eZEIT;
        return this;
    }

    public String getADATU() {
        return aDATU;
    }

    public void setADATU(String aDATU) {
        this.aDATU = aDATU;
    }

    public Interim withADATU(String aDATU) {
        this.aDATU = aDATU;
        return this;
    }

    public String getAZEIT() {
        return aZEIT;
    }

    public void setAZEIT(String aZEIT) {
        this.aZEIT = aZEIT;
    }

    public Interim withAZEIT(String aZEIT) {
        this.aZEIT = aZEIT;
        return this;
    }

    public String getZDATU() {
        return zDATU;
    }

    public void setZDATU(String zDATU) {
        this.zDATU = zDATU;
    }

    public Interim withZDATU(String zDATU) {
        this.zDATU = zDATU;
        return this;
    }

    public String getWDATU() {
        return wDATU;
    }

    public void setWDATU(String wDATU) {
        this.wDATU = wDATU;
    }

    public Interim withWDATU(String wDATU) {
        this.wDATU = wDATU;
        return this;
    }

    public String getWENUM() {
        return wENUM;
    }

    public void setWENUM(String wENUM) {
        this.wENUM = wENUM;
    }

    public Interim withWENUM(String wENUM) {
        this.wENUM = wENUM;
        return this;
    }

    public String getWEPOS() {
        return wEPOS;
    }

    public void setWEPOS(String wEPOS) {
        this.wEPOS = wEPOS;
    }

    public Interim withWEPOS(String wEPOS) {
        this.wEPOS = wEPOS;
        return this;
    }

    public String getLETYP() {
        return lETYP;
    }

    public void setLETYP(String lETYP) {
        this.lETYP = lETYP;
    }

    public Interim withLETYP(String lETYP) {
        this.lETYP = lETYP;
        return this;
    }

    public String getMEINS() {
        return mEINS;
    }

    public void setMEINS(String mEINS) {
        this.mEINS = mEINS;
    }

    public Interim withMEINS(String mEINS) {
        this.mEINS = mEINS;
        return this;
    }

    public String getGESME() {
        return gESME;
    }

    public void setGESME(String gESME) {
        this.gESME = gESME;
    }

    public Interim withGESME(String gESME) {
        this.gESME = gESME;
        return this;
    }

    public String getVERME() {
        return vERME;
    }

    public void setVERME(String vERME) {
        this.vERME = vERME;
    }

    public Interim withVERME(String vERME) {
        this.vERME = vERME;
        return this;
    }

    public String getEINME() {
        return eINME;
    }

    public void setEINME(String eINME) {
        this.eINME = eINME;
    }

    public Interim withEINME(String eINME) {
        this.eINME = eINME;
        return this;
    }

    public String getAUSME() {
        return aUSME;
    }

    public void setAUSME(String aUSME) {
        this.aUSME = aUSME;
    }

    public Interim withAUSME(String aUSME) {
        this.aUSME = aUSME;
        return this;
    }

    public String getMGEWI() {
        return mGEWI;
    }

    public void setMGEWI(String mGEWI) {
        this.mGEWI = mGEWI;
    }

    public Interim withMGEWI(String mGEWI) {
        this.mGEWI = mGEWI;
        return this;
    }

    public String getGEWEI() {
        return gEWEI;
    }

    public void setGEWEI(String gEWEI) {
        this.gEWEI = gEWEI;
    }

    public Interim withGEWEI(String gEWEI) {
        this.gEWEI = gEWEI;
        return this;
    }

    public String getTBNUM() {
        return tBNUM;
    }

    public void setTBNUM(String tBNUM) {
        this.tBNUM = tBNUM;
    }

    public Interim withTBNUM(String tBNUM) {
        this.tBNUM = tBNUM;
        return this;
    }

    public String getIVNUM() {
        return iVNUM;
    }

    public void setIVNUM(String iVNUM) {
        this.iVNUM = iVNUM;
    }

    public Interim withIVNUM(String iVNUM) {
        this.iVNUM = iVNUM;
        return this;
    }

    public String getIVPOS() {
        return iVPOS;
    }

    public void setIVPOS(String iVPOS) {
        this.iVPOS = iVPOS;
    }

    public Interim withIVPOS(String iVPOS) {
        this.iVPOS = iVPOS;
        return this;
    }

    public String getBETYP() {
        return bETYP;
    }

    public void setBETYP(String bETYP) {
        this.bETYP = bETYP;
    }

    public Interim withBETYP(String bETYP) {
        this.bETYP = bETYP;
        return this;
    }

    public String getBENUM() {
        return bENUM;
    }

    public void setBENUM(String bENUM) {
        this.bENUM = bENUM;
    }

    public Interim withBENUM(String bENUM) {
        this.bENUM = bENUM;
        return this;
    }

    public String getLENUM() {
        return lENUM;
    }

    public void setLENUM(String lENUM) {
        this.lENUM = lENUM;
    }

    public Interim withLENUM(String lENUM) {
        this.lENUM = lENUM;
        return this;
    }

    public String getQPLOS() {
        return qPLOS;
    }

    public void setQPLOS(String qPLOS) {
        this.qPLOS = qPLOS;
    }

    public Interim withQPLOS(String qPLOS) {
        this.qPLOS = qPLOS;
        return this;
    }

    public String getVFDAT() {
        return vFDAT;
    }

    public void setVFDAT(String vFDAT) {
        this.vFDAT = vFDAT;
    }

    public Interim withVFDAT(String vFDAT) {
        this.vFDAT = vFDAT;
        return this;
    }

    public String getQKAPV() {
        return qKAPV;
    }

    public void setQKAPV(String qKAPV) {
        this.qKAPV = qKAPV;
    }

    public Interim withQKAPV(String qKAPV) {
        this.qKAPV = qKAPV;
        return this;
    }

    public String getKOBER() {
        return kOBER;
    }

    public void setKOBER(String kOBER) {
        this.kOBER = kOBER;
    }

    public Interim withKOBER(String kOBER) {
        this.kOBER = kOBER;
        return this;
    }

    public String getLGORT() {
        return lGORT;
    }

    public void setLGORT(String lGORT) {
        this.lGORT = lGORT;
    }

    public Interim withLGORT(String lGORT) {
        this.lGORT = lGORT;
        return this;
    }

    public String getVIRGO() {
        return vIRGO;
    }

    public void setVIRGO(String vIRGO) {
        this.vIRGO = vIRGO;
    }

    public Interim withVIRGO(String vIRGO) {
        this.vIRGO = vIRGO;
        return this;
    }

    public String getTRAME() {
        return tRAME;
    }

    public void setTRAME(String tRAME) {
        this.tRAME = tRAME;
    }

    public Interim withTRAME(String tRAME) {
        this.tRAME = tRAME;
        return this;
    }

    public String getKZHUQ() {
        return kZHUQ;
    }

    public void setKZHUQ(String kZHUQ) {
        this.kZHUQ = kZHUQ;
    }

    public Interim withKZHUQ(String kZHUQ) {
        this.kZHUQ = kZHUQ;
        return this;
    }

    public String getVBELN() {
        return vBELN;
    }

    public void setVBELN(String vBELN) {
        this.vBELN = vBELN;
    }

    public Interim withVBELN(String vBELN) {
        this.vBELN = vBELN;
        return this;
    }

    public String getPOSNR() {
        return pOSNR;
    }

    public void setPOSNR(String pOSNR) {
        this.pOSNR = pOSNR;
    }

    public Interim withPOSNR(String pOSNR) {
        this.pOSNR = pOSNR;
        return this;
    }

    public String getIDATU() {
        return iDATU;
    }

    public void setIDATU(String iDATU) {
        this.iDATU = iDATU;
    }

    public Interim withIDATU(String iDATU) {
        this.iDATU = iDATU;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("mAKTX", mAKTX).append("mANDT", mANDT).append("lGNUM", lGNUM).append("lQNUM", lQNUM).append("mATNR", mATNR).append("wERKS", wERKS).append("cHARG", cHARG).append("bESTQ", bESTQ).append("sOBKZ", sOBKZ).append("sONUM", sONUM).append("lGTYP", lGTYP).append("lGPLA", lGPLA).append("pLPOS", pLPOS).append("sKZUE", sKZUE).append("sKZUA", sKZUA).append("sKZSE", sKZSE).append("sKZSA", sKZSA).append("sKZSI", sKZSI).append("sPGRU", sPGRU).append("zEUGN", zEUGN).append("bDATU", bDATU).append("bZEIT", bZEIT).append("bTANR", bTANR).append("bTAPS", bTAPS).append("eDATU", eDATU).append("eZEIT", eZEIT).append("aDATU", aDATU).append("aZEIT", aZEIT).append("zDATU", zDATU).append("wDATU", wDATU).append("wENUM", wENUM).append("wEPOS", wEPOS).append("lETYP", lETYP).append("mEINS", mEINS).append("gESME", gESME).append("vERME", vERME).append("eINME", eINME).append("aUSME", aUSME).append("mGEWI", mGEWI).append("gEWEI", gEWEI).append("tBNUM", tBNUM).append("iVNUM", iVNUM).append("iVPOS", iVPOS).append("bETYP", bETYP).append("bENUM", bENUM).append("lENUM", lENUM).append("qPLOS", qPLOS).append("vFDAT", vFDAT).append("qKAPV", qKAPV).append("kOBER", kOBER).append("lGORT", lGORT).append("vIRGO", vIRGO).append("tRAME", tRAME).append("kZHUQ", kZHUQ).append("vBELN", vBELN).append("pOSNR", pOSNR).append("iDATU", iDATU).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sKZSI).append(cHARG).append(wEPOS).append(sKZSE).append(gEWEI).append(sKZSA).append(vFDAT).append(bENUM).append(sPGRU).append(wDATU).append(mEINS).append(eDATU).append(lETYP).append(aDATU).append(bTAPS).append(aUSME).append(zEUGN).append(bETYP).append(zDATU).append(iVNUM).append(lGTYP).append(lGPLA).append(tRAME).append(tBNUM).append(iVPOS).append(kZHUQ).append(bDATU).append(kOBER).append(qKAPV).append(mGEWI).append(lQNUM).append(vERME).append(sKZUA).append(sOBKZ).append(eINME).append(sKZUE).append(sONUM).append(bZEIT).append(wENUM).append(pOSNR).append(vIRGO).append(gESME).append(lENUM).append(pLPOS).append(vBELN).append(mATNR).append(lGORT).append(lGNUM).append(bTANR).append(iDATU).append(bESTQ).append(wERKS).append(eZEIT).append(aZEIT).append(mANDT).append(qPLOS).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Interim)) {
            return false;
        }
        Interim rhs = ((Interim) other);
        return new EqualsBuilder().append(sKZSI, rhs.sKZSI).append(cHARG, rhs.cHARG).append(wEPOS, rhs.wEPOS).append(sKZSE, rhs.sKZSE).append(gEWEI, rhs.gEWEI).append(sKZSA, rhs.sKZSA).append(vFDAT, rhs.vFDAT).append(bENUM, rhs.bENUM).append(sPGRU, rhs.sPGRU).append(wDATU, rhs.wDATU).append(mEINS, rhs.mEINS).append(eDATU, rhs.eDATU).append(lETYP, rhs.lETYP).append(aDATU, rhs.aDATU).append(bTAPS, rhs.bTAPS).append(aUSME, rhs.aUSME).append(zEUGN, rhs.zEUGN).append(bETYP, rhs.bETYP).append(zDATU, rhs.zDATU).append(iVNUM, rhs.iVNUM).append(lGTYP, rhs.lGTYP).append(lGPLA, rhs.lGPLA).append(tRAME, rhs.tRAME).append(tBNUM, rhs.tBNUM).append(iVPOS, rhs.iVPOS).append(kZHUQ, rhs.kZHUQ).append(bDATU, rhs.bDATU).append(kOBER, rhs.kOBER).append(qKAPV, rhs.qKAPV).append(mGEWI, rhs.mGEWI).append(lQNUM, rhs.lQNUM).append(vERME, rhs.vERME).append(sKZUA, rhs.sKZUA).append(sOBKZ, rhs.sOBKZ).append(eINME, rhs.eINME).append(sKZUE, rhs.sKZUE).append(sONUM, rhs.sONUM).append(bZEIT, rhs.bZEIT).append(wENUM, rhs.wENUM).append(pOSNR, rhs.pOSNR).append(vIRGO, rhs.vIRGO).append(gESME, rhs.gESME).append(lENUM, rhs.lENUM).append(pLPOS, rhs.pLPOS).append(vBELN, rhs.vBELN).append(mATNR, rhs.mATNR).append(lGORT, rhs.lGORT).append(lGNUM, rhs.lGNUM).append(bTANR, rhs.bTANR).append(iDATU, rhs.iDATU).append(bESTQ, rhs.bESTQ).append(wERKS, rhs.wERKS).append(eZEIT, rhs.eZEIT).append(aZEIT, rhs.aZEIT).append(mANDT, rhs.mANDT).append(qPLOS, rhs.qPLOS).isEquals();
    }

}
