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

public class BonSementara {
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
    @SerializedName("WERKS")
    @Expose
    private String plant;
    @SerializedName("LGORT")
    @Expose
    private String sloc;
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
    @SerializedName("BDMNG")
    @Expose
    private String qty;
    @SerializedName("MEINS")
    @Expose
    private String uom;
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
    public BonSementara() {
    }

    /**
     * @param sORTF
     * @param rSSTA
     * @param xWAOK
     * @param cHARG
     * @param bDART
     * @param sHKZG
     * @param kZEAR
     * @param xFEHL
     * @param mATNR
     * @param sloc
     * @param eNMNG
     * @param rSNUM
     * @param qty
     * @param mAKTX
     * @param sOBKZ
     * @param uom
     * @param rSPOS
     * @param plant
     * @param aUFNR
     * @param xLOEK
     * @param bDTER
     * @param rSART
     * @param bWART
     */
    public BonSementara(String rSNUM, String rSPOS, String rSART, String bDART, String rSSTA, String xLOEK, String xWAOK, String kZEAR, String xFEHL, String mATNR, String mAKTX, String plant, String sloc, String cHARG, String sORTF, String sOBKZ, String bDTER, String qty, String uom, String sHKZG, String eNMNG, String aUFNR, String bWART) {
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
        this.plant = plant;
        this.sloc = sloc;
        this.cHARG = cHARG;
        this.sORTF = sORTF;
        this.sOBKZ = sOBKZ;
        this.bDTER = bDTER;
        this.qty = qty;
        this.uom = uom;
        this.sHKZG = sHKZG;
        this.eNMNG = eNMNG;
        this.aUFNR = aUFNR;
        this.bWART = bWART;
    }

    public BonSementara(String rSNUM, String rSPOS, String rSART, String bDART, String rSSTA, String xLOEK, String xWAOK, String kZEAR, String xFEHL, String mATNR, String mAKTX, String plant, String sloc, String cHARG, String sORTF, String sOBKZ, String bDTER, String qty, String uom, String sHKZG, String eNMNG, String aUFNR, String bWART, String keterangan) {
        this(rSNUM, rSPOS, rSART, bDART, rSSTA, xLOEK, xWAOK, kZEAR, xFEHL, mATNR, mAKTX, plant, sloc, cHARG, sORTF, sOBKZ, bDTER, qty, uom, sHKZG, eNMNG, aUFNR, bWART);
        this.keterangan = keterangan;
    }

    public BonSementara(String rSNUM, String rSPOS, String keterangan) {
        this.rSNUM = rSNUM;
        this.rSPOS = rSPOS;
        this.keterangan = keterangan;
    }

    public String getKETERANGAN() {
        return keterangan;
    }

    public void setKETERANGAN(String kETERANGAN) {
        this.keterangan = kETERANGAN;
    }

    public BonSementara withKeterangan(String keterangan) {
        this.keterangan = keterangan;
        return this;
    }

    public String getRSNUM() {
        return rSNUM;
    }

    public void setRSNUM(String rSNUM) {
        this.rSNUM = rSNUM;
    }

    public BonSementara withRSNUM(String rSNUM) {
        this.rSNUM = rSNUM;
        return this;
    }

    public String getRSPOS() {
        return rSPOS;
    }

    public void setRSPOS(String rSPOS) {
        this.rSPOS = rSPOS;
    }

    public BonSementara withRSPOS(String rSPOS) {
        this.rSPOS = rSPOS;
        return this;
    }

    public String getRSART() {
        return rSART;
    }

    public void setRSART(String rSART) {
        this.rSART = rSART;
    }

    public BonSementara withRSART(String rSART) {
        this.rSART = rSART;
        return this;
    }

    public String getBDART() {
        return bDART;
    }

    public void setBDART(String bDART) {
        this.bDART = bDART;
    }

    public BonSementara withBDART(String bDART) {
        this.bDART = bDART;
        return this;
    }

    public String getRSSTA() {
        return rSSTA;
    }

    public void setRSSTA(String rSSTA) {
        this.rSSTA = rSSTA;
    }

    public BonSementara withRSSTA(String rSSTA) {
        this.rSSTA = rSSTA;
        return this;
    }

    public String getXLOEK() {
        return xLOEK;
    }

    public void setXLOEK(String xLOEK) {
        this.xLOEK = xLOEK;
    }

    public BonSementara withXLOEK(String xLOEK) {
        this.xLOEK = xLOEK;
        return this;
    }

    public String getXWAOK() {
        return xWAOK;
    }

    public void setXWAOK(String xWAOK) {
        this.xWAOK = xWAOK;
    }

    public BonSementara withXWAOK(String xWAOK) {
        this.xWAOK = xWAOK;
        return this;
    }

    public String getKZEAR() {
        return kZEAR;
    }

    public void setKZEAR(String kZEAR) {
        this.kZEAR = kZEAR;
    }

    public BonSementara withKZEAR(String kZEAR) {
        this.kZEAR = kZEAR;
        return this;
    }

    public String getXFEHL() {
        return xFEHL;
    }

    public void setXFEHL(String xFEHL) {
        this.xFEHL = xFEHL;
    }

    public BonSementara withXFEHL(String xFEHL) {
        this.xFEHL = xFEHL;
        return this;
    }

    public String getMATNR() {
        return mATNR;
    }

    public void setMATNR(String mATNR) {
        this.mATNR = mATNR;
    }

    public BonSementara withMATNR(String mATNR) {
        this.mATNR = mATNR;
        return this;
    }

    public String getMAKTX() {
        return mAKTX;
    }

    public void setMAKTX(String mAKTX) {
        this.mAKTX = mAKTX;
    }

    public BonSementara withMAKTX(String mAKTX) {
        this.mAKTX = mAKTX;
        return this;
    }

    public String getWERKS() {
        return plant;
    }

    public void setWERKS(String wERKS) {
        this.plant = wERKS;
    }

    public BonSementara withWERKS(String wERKS) {
        this.plant = wERKS;
        return this;
    }

    public String getLGORT() {
        return sloc;
    }

    public void setLGORT(String lGORT) {
        this.sloc = lGORT;
    }

    public BonSementara withLGORT(String lGORT) {
        this.sloc = lGORT;
        return this;
    }

    public String getCHARG() {
        return cHARG;
    }

    public void setCHARG(String cHARG) {
        this.cHARG = cHARG;
    }

    public BonSementara withCHARG(String cHARG) {
        this.cHARG = cHARG;
        return this;
    }

    public String getSORTF() {
        return sORTF;
    }

    public void setSORTF(String sORTF) {
        this.sORTF = sORTF;
    }

    public BonSementara withSORTF(String sORTF) {
        this.sORTF = sORTF;
        return this;
    }

    public String getSOBKZ() {
        return sOBKZ;
    }

    public void setSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
    }

    public BonSementara withSOBKZ(String sOBKZ) {
        this.sOBKZ = sOBKZ;
        return this;
    }

    public String getBDTER() {
        return bDTER;
    }

    public void setBDTER(String bDTER) {
        this.bDTER = bDTER;
    }

    public BonSementara withBDTER(String bDTER) {
        this.bDTER = bDTER;
        return this;
    }

    public String getBDMNG() {
        return qty;
    }

    public void setBDMNG(String bDMNG) {
        this.qty = bDMNG;
    }

    public BonSementara withBDMNG(String bDMNG) {
        this.qty = bDMNG;
        return this;
    }

    public String getMEINS() {
        return uom;
    }

    public void setMEINS(String mEINS) {
        this.uom = mEINS;
    }

    public BonSementara withMEINS(String mEINS) {
        this.uom = mEINS;
        return this;
    }

    public String getSHKZG() {
        return sHKZG;
    }

    public void setSHKZG(String sHKZG) {
        this.sHKZG = sHKZG;
    }

    public BonSementara withSHKZG(String sHKZG) {
        this.sHKZG = sHKZG;
        return this;
    }

    public String getENMNG() {
        return eNMNG;
    }

    public void setENMNG(String eNMNG) {
        this.eNMNG = eNMNG;
    }

    public BonSementara withENMNG(String eNMNG) {
        this.eNMNG = eNMNG;
        return this;
    }

    public String getAUFNR() {
        return aUFNR;
    }

    public void setAUFNR(String aUFNR) {
        this.aUFNR = aUFNR;
    }

    public BonSementara withAUFNR(String aUFNR) {
        this.aUFNR = aUFNR;
        return this;
    }

    public String getBWART() {
        return bWART;
    }

    public void setBWART(String bWART) {
        this.bWART = bWART;
    }

    public BonSementara withBWART(String bWART) {
        this.bWART = bWART;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("rSNUM", rSNUM).append("rSPOS", rSPOS).append("rSART", rSART).append("bDART", bDART).append("rSSTA", rSSTA).append("xLOEK", xLOEK).append("xWAOK", xWAOK).append("kZEAR", kZEAR).append("xFEHL", xFEHL).append("mATNR", mATNR).append("mAKTX", mAKTX).append("plant", plant).append("sloc", sloc).append("cHARG", cHARG).append("sORTF", sORTF).append("sOBKZ", sOBKZ).append("bDTER", bDTER).append("qty", qty).append("uom", uom).append("sHKZG", sHKZG).append("eNMNG", eNMNG).append("aUFNR", aUFNR).append("bWART", bWART).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sORTF).append(xWAOK).append(rSSTA).append(cHARG).append(bDART).append(sHKZG).append(kZEAR).append(mATNR).append(xFEHL).append(sloc).append(eNMNG).append(rSNUM).append(qty).append(mAKTX).append(sOBKZ).append(uom).append(rSPOS).append(plant).append(aUFNR).append(xLOEK).append(bDTER).append(rSART).append(bWART).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof BonSementara)) {
            return false;
        }
        BonSementara rhs = ((BonSementara) other);
        return new EqualsBuilder().append(sORTF, rhs.sORTF).append(xWAOK, rhs.xWAOK).append(rSSTA, rhs.rSSTA).append(cHARG, rhs.cHARG).append(bDART, rhs.bDART).append(sHKZG, rhs.sHKZG).append(kZEAR, rhs.kZEAR).append(mATNR, rhs.mATNR).append(xFEHL, rhs.xFEHL).append(sloc, rhs.sloc).append(eNMNG, rhs.eNMNG).append(rSNUM, rhs.rSNUM).append(qty, rhs.qty).append(mAKTX, rhs.mAKTX).append(sOBKZ, rhs.sOBKZ).append(uom, rhs.uom).append(rSPOS, rhs.rSPOS).append(plant, rhs.plant).append(aUFNR, rhs.aUFNR).append(xLOEK, rhs.xLOEK).append(bDTER, rhs.bDTER).append(rSART, rhs.rSART).append(bWART, rhs.bWART).isEquals();
    }

}