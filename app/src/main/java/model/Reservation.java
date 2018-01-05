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

public class Reservation {
    @SerializedName("WERKS")
    @Expose
    private String wERKS;
    @SerializedName("LGORT")
    @Expose
    private String lGORT;
    @SerializedName("BDMNG")
    @Expose
    private String bDMNG;
    @SerializedName("MEINS")
    @Expose
    private String mEINS;
    @SerializedName("PSPEL")
    @Expose
    private String pSPEL;
    @SerializedName("ZZWBS")
    @Expose
    private String zZWBS;
    @SerializedName("RSNUM")
    @Expose
    private String rSNUM;
    @SerializedName("RSPOS")
    @Expose
    private String rSPOS;
    @SerializedName("RSART")
    @Expose
    private String rSART;
    @SerializedName("BDART")
    @Expose
    private String bDART;
    @SerializedName("RSSTA")
    @Expose
    private String rSSTA;
    @SerializedName("XLOEK")
    @Expose
    private String xLOEK;
    @SerializedName("XWAOK")
    @Expose
    private String xWAOK;
    @SerializedName("KZEAR")
    @Expose
    private String kZEAR;
    @SerializedName("XFEHL")
    @Expose
    private String xFEHL;
    @SerializedName("MATNR")
    @Expose
    private String mATNR;
    @SerializedName("MAKTX")
    @Expose
    private String mAKTX;
    @SerializedName("CHARG")
    @Expose
    private String cHARG;
    @SerializedName("SORTF")
    @Expose
    private String sORTF;
    @SerializedName("SOBKZ")
    @Expose
    private String sOBKZ;
    @SerializedName("BDTER")
    @Expose
    private String bDTER;
    @SerializedName("SHKZG")
    @Expose
    private String sHKZG;
    @SerializedName("ENMNG")
    @Expose
    private String eNMNG;
    @SerializedName("AUFNR")
    @Expose
    private String aUFNR;
    @SerializedName("BWART")
    @Expose
    private String bWART;
    @SerializedName("KETERANGAN")
    @Expose
    private String keterangan;

    /**
     * No args constructor for use in serialization
     */
    public Reservation() {
    }

    /**
     * @param zZWBS
     * @param sORTF
     * @param rSSTA
     * @param xWAOK
     * @param cHARG
     * @param bDART
     * @param sHKZG
     * @param kZEAR
     * @param xFEHL
     * @param mATNR
     * @param lGORT
     * @param eNMNG
     * @param rSNUM
     * @param pSPEL
     * @param bDMNG
     * @param mAKTX
     * @param sOBKZ
     * @param mEINS
     * @param rSPOS
     * @param wERKS
     * @param aUFNR
     * @param xLOEK
     * @param bDTER
     * @param rSART
     * @param bWART
     */
    public Reservation(String rSNUM, String rSPOS, String rSART, String bDART, String rSSTA, String xLOEK, String xWAOK, String kZEAR, String xFEHL, String mATNR, String mAKTX, String wERKS, String lGORT, String cHARG, String sORTF, String sOBKZ, String bDTER, String bDMNG, String mEINS, String sHKZG, String eNMNG, String aUFNR, String bWART, String pSPEL, String zZWBS) {
        super();
        this.rSNUM = rSNUM;
        this.rSPOS = rSPOS;
        this.rSART = rSART;
        this.bDART = bDART;
        this.rSSTA = rSSTA;
        this.xLOEK = xLOEK;
        this.xWAOK = xWAOK;
        this.kZEAR = kZEAR;
        this.xFEHL = xFEHL;
        this.mATNR = mATNR;
        this.mAKTX = mAKTX;
        this.wERKS = wERKS;
        this.lGORT = lGORT;
        this.cHARG = cHARG;
        this.sORTF = sORTF;
        this.sOBKZ = sOBKZ;
        this.bDTER = bDTER;
        this.bDMNG = bDMNG;
        this.mEINS = mEINS;
        this.sHKZG = sHKZG;
        this.eNMNG = eNMNG;
        this.aUFNR = aUFNR;
        this.bWART = bWART;
        this.pSPEL = pSPEL;
        this.zZWBS = zZWBS;
    }

    public Reservation(String rSNUM, String rSPOS, String keterangan) {
        this.rSNUM = rSNUM;
        this.rSPOS = rSPOS;
        this.keterangan = keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Reservation withKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public String getRSNUM() {
        return rSNUM;
    }

    public void setRSNUM(String rSNUM) {
        this.rSNUM = rSNUM;
    }

    public Reservation withRSNUM(String rSNUM) {
        this.rSNUM = rSNUM;
        return this;
    }

    public String getRSPOS() {
        return rSPOS;
    }

    public void setRSPOS(String rSPOS) {
        this.rSPOS = rSPOS;
    }

    public Reservation withRSPOS(String rSPOS) {
        this.rSPOS = rSPOS;
        return this;
    }

    public String getRSART() {
        return rSART;
    }

    public void setRSART(String rSART) {
        this.rSART = rSART;
    }

    public Reservation withRSART(String rSART) {
        this.rSART = rSART;
        return this;
    }

    public String getBDART() {
        return bDART;
    }

    public void setBDART(String bDART) {
        this.bDART = bDART;
    }

    public Reservation withBDART(String bDART) {
        this.bDART = bDART;
        return this;
    }

    public String getRSSTA() {
        return rSSTA;
    }

    public void setRSSTA(String rSSTA) {
        this.rSSTA = rSSTA;
    }

    public Reservation withRSSTA(String rSSTA) {
        this.rSSTA = rSSTA;
        return this;
    }

    public String getXLOEK() {
        return xLOEK;
    }

    public void setXLOEK(String xLOEK) {
        this.xLOEK = xLOEK;
    }

    public Reservation withXLOEK(String xLOEK) {
        this.xLOEK = xLOEK;
        return this;
    }

    public String getXWAOK() {
        return xWAOK;
    }

    public void setXWAOK(String xWAOK) {
        this.xWAOK = xWAOK;
    }

    public Reservation withXWAOK(String xWAOK) {
        this.xWAOK = xWAOK;
        return this;
    }

    public String getKZEAR() {
        return kZEAR;
    }

    public void setKZEAR(String kZEAR) {
        this.kZEAR = kZEAR;
    }

    public Reservation withKZEAR(String kZEAR) {
        this.kZEAR = kZEAR;
        return this;
    }

    public String getXFEHL() {
        return xFEHL;
    }

    public void setXFEHL(String xFEHL) {
        this.xFEHL = xFEHL;
    }

    public Reservation withXFEHL(String xFEHL) {
        this.xFEHL = xFEHL;
        return this;
    }

    public String getMATNR() {
        return mATNR;
    }

    public void setMATNR(String mATNR) {
        this.mATNR = mATNR;
    }

    public Reservation withMATNR(String mATNR) {
        this.mATNR = mATNR;
        return this;
    }

    public String getMAKTX() {
        return mAKTX;
    }

    public void setMAKTX(String mAKTX) {
        this.mAKTX = mAKTX;
    }

    public Reservation withMAKTX(String mAKTX) {
        this.mAKTX = mAKTX;
        return this;
    }

    public String getWERKS() {
        return wERKS;
    }

    public void setWERKS(String wERKS) {
        this.wERKS = wERKS;
    }

    public Reservation withWERKS(String wERKS) {
        this.wERKS = wERKS;
        return this;
    }

    public String getLGORT() {
        return lGORT;
    }

    public void setLGORT(String lGORT) {
        this.lGORT = lGORT;
    }

    public Reservation withLGORT(String lGORT) {
        this.lGORT = lGORT;
        return this;
    }

    public String getCHARG() {
        return cHARG;
    }

    public void setCHARG(String cHARG) {
        this.cHARG = cHARG;
    }

    public Reservation withCHARG(String cHARG) {
        this.cHARG = cHARG;
        return this;
    }

    public String getSORTF() {
        return sORTF;
    }

    public void setSORTF(String sORTF) {
        this.sORTF = sORTF;
    }

    public Reservation withSORTF(String sORTF) {
        this.sORTF = sORTF;
        return this;
    }

    public String getSOBKZ() {
        return sOBKZ;
    }

    public void setSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
    }

    public Reservation withSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
        return this;
    }

    public String getBDTER() {
        return bDTER;
    }

    public void setBDTER(String bDTER) {
        this.bDTER = bDTER;
    }

    public Reservation withBDTER(String bDTER) {
        this.bDTER = bDTER;
        return this;
    }

    public String getBDMNG() {
        return bDMNG;
    }

    public void setBDMNG(String bDMNG) {
        this.bDMNG = bDMNG;
    }

    public Reservation withBDMNG(String bDMNG) {
        this.bDMNG = bDMNG;
        return this;
    }

    public String getMEINS() {
        return mEINS;
    }

    public void setMEINS(String mEINS) {
        this.mEINS = mEINS;
    }

    public Reservation withMEINS(String mEINS) {
        this.mEINS = mEINS;
        return this;
    }

    public String getSHKZG() {
        return sHKZG;
    }

    public void setSHKZG(String sHKZG) {
        this.sHKZG = sHKZG;
    }

    public Reservation withSHKZG(String sHKZG) {
        this.sHKZG = sHKZG;
        return this;
    }

    public String getENMNG() {
        return eNMNG;
    }

    public void setENMNG(String eNMNG) {
        this.eNMNG = eNMNG;
    }

    public Reservation withENMNG(String eNMNG) {
        this.eNMNG = eNMNG;
        return this;
    }

    public String getAUFNR() {
        return aUFNR;
    }

    public void setAUFNR(String aUFNR) {
        this.aUFNR = aUFNR;
    }

    public Reservation withAUFNR(String aUFNR) {
        this.aUFNR = aUFNR;
        return this;
    }

    public String getBWART() {
        return bWART;
    }

    public void setBWART(String bWART) {
        this.bWART = bWART;
    }

    public Reservation withBWART(String bWART) {
        this.bWART = bWART;
        return this;
    }

    public String getPSPEL() {
        return pSPEL;
    }

    public void setPSPEL(String pSPEL) {
        this.pSPEL = pSPEL;
    }

    public Reservation withPSPEL(String pSPEL) {
        this.pSPEL = pSPEL;
        return this;
    }

    public String getZZWBS() {
        return zZWBS;
    }

    public void setZZWBS(String zZWBS) {
        this.zZWBS = zZWBS;
    }

    public Reservation withZZWBS(String zZWBS) {
        this.zZWBS = zZWBS;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rSNUM", rSNUM).append("rSPOS", rSPOS).append("rSART", rSART).append("bDART", bDART).append("rSSTA", rSSTA).append("xLOEK", xLOEK).append("xWAOK", xWAOK).append("kZEAR", kZEAR).append("xFEHL", xFEHL).append("mATNR", mATNR).append("mAKTX", mAKTX).append("wERKS", wERKS).append("lGORT", lGORT).append("cHARG", cHARG).append("sORTF", sORTF).append("sOBKZ", sOBKZ).append("bDTER", bDTER).append("bDMNG", bDMNG).append("mEINS", mEINS).append("sHKZG", sHKZG).append("eNMNG", eNMNG).append("aUFNR", aUFNR).append("bWART", bWART).append("pSPEL", pSPEL).append("zZWBS", zZWBS).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sORTF).append(rSSTA).append(cHARG).append(kZEAR).append(bDMNG).append(mAKTX).append(sOBKZ).append(mEINS).append(aUFNR).append(xLOEK).append(bWART).append(zZWBS).append(xWAOK).append(bDART).append(sHKZG).append(mATNR).append(xFEHL).append(lGORT).append(eNMNG).append(rSNUM).append(pSPEL).append(rSPOS).append(wERKS).append(bDTER).append(rSART).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Reservation)) {
            return false;
        }
        Reservation rhs = ((Reservation) other);
        return new EqualsBuilder().append(sORTF, rhs.sORTF).append(rSSTA, rhs.rSSTA).append(cHARG, rhs.cHARG).append(kZEAR, rhs.kZEAR).append(bDMNG, rhs.bDMNG).append(mAKTX, rhs.mAKTX).append(sOBKZ, rhs.sOBKZ).append(mEINS, rhs.mEINS).append(aUFNR, rhs.aUFNR).append(xLOEK, rhs.xLOEK).append(bWART, rhs.bWART).append(zZWBS, rhs.zZWBS).append(xWAOK, rhs.xWAOK).append(bDART, rhs.bDART).append(sHKZG, rhs.sHKZG).append(mATNR, rhs.mATNR).append(xFEHL, rhs.xFEHL).append(lGORT, rhs.lGORT).append(eNMNG, rhs.eNMNG).append(rSNUM, rhs.rSNUM).append(pSPEL, rhs.pSPEL).append(rSPOS, rhs.rSPOS).append(wERKS, rhs.wERKS).append(bDTER, rhs.bDTER).append(rSART, rhs.rSART).isEquals();
    }

}
