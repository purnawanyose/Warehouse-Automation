package model;

/**
 * Created by muham on 2/6/2018.
 */

public class Cart {

    String PSTNG_DATE, DOC_DATE, HEADER_TXT;
    String PR_UNAME, PLANT, MOVE_TYPE, ENTRY_QNT, RESERV_NO, RES_ITEM, STGE_LOC, VAL_TYPE, SPEC_STOCK, WBS_ELEM, STATUS;

    public Cart() {

    }

    public Cart(String PSTNG_DATE, String DOC_DATE, String HEADER_TXT, String PR_UNAME, String PLANT, String MOVE_TYPE,
                String ENTRY_QNT, String RESERV_NO, String RES_ITEM, String STGE_LOC, String VAL_TYPE, String SPEC_STOCK,
                String WBS_ELEM) {


        this.PSTNG_DATE = PSTNG_DATE;
        this.DOC_DATE = DOC_DATE;
        this.HEADER_TXT = HEADER_TXT;
        this.PR_UNAME = PR_UNAME;
        this.PLANT = PLANT;
        this.MOVE_TYPE = MOVE_TYPE;
        this.ENTRY_QNT = ENTRY_QNT;
        this.RESERV_NO = RESERV_NO;
        this.RES_ITEM = RES_ITEM;
        this.STGE_LOC = STGE_LOC;
        this.VAL_TYPE = VAL_TYPE;
        this.SPEC_STOCK = SPEC_STOCK;
        this.WBS_ELEM = WBS_ELEM;
        this.STATUS = STATUS;
    }

    public String getPSTNG_DATE() {
        return PSTNG_DATE;
    }

    public void setPSTNG_DATE(String PSTNG_DATE) {
        this.PSTNG_DATE = PSTNG_DATE;
    }

    public String getDOC_DATE() {
        return DOC_DATE;
    }

    public void setDOC_DATE(String DOC_DATE) {
        this.DOC_DATE = DOC_DATE;
    }

    public String getHEADER_TXT() {
        return HEADER_TXT;
    }

    public void setHEADER_TXT(String HEADER_TXT) {
        this.HEADER_TXT = HEADER_TXT;
    }

    public String getPR_UNAME() {
        return PR_UNAME;
    }

    public void setPR_UNAME(String PR_UNAME) {
        this.PR_UNAME = PR_UNAME;
    }

    public String getPLANT() {
        return PLANT;
    }

    public void setPLANT(String PLANT) {
        this.PLANT = PLANT;
    }

    public String getMOVE_TYPE() {
        return MOVE_TYPE;
    }

    public void setMOVE_TYPE(String MOVE_TYPE) {
        this.MOVE_TYPE = MOVE_TYPE;
    }

    public String getENTRY_QNT() {
        return ENTRY_QNT;
    }

    public void setENTRY_QNT(String ENTRY_QNT) {
        this.ENTRY_QNT = ENTRY_QNT;
    }

    public String getRESERV_NO() {
        return RESERV_NO;
    }

    public void setRESERV_NO(String RESERV_NO) {
        this.RESERV_NO = RESERV_NO;
    }

    public String getRES_ITEM() {
        return RES_ITEM;
    }

    public void setRES_ITEM(String RES_ITEM) {
        this.RES_ITEM = RES_ITEM;
    }

    public String getSTGE_LOC() {
        return STGE_LOC;
    }

    public void setSTGE_LOC(String STGE_LOC) {
        this.STGE_LOC = STGE_LOC;
    }

    public String getVAL_TYPE() {
        return VAL_TYPE;
    }

    public void setVAL_TYPE(String VAL_TYPE) {
        this.VAL_TYPE = VAL_TYPE;
    }

    public String getSPEC_STOCK() {
        return SPEC_STOCK;
    }

    public void setSPEC_STOCK(String SPEC_STOCK) {
        this.SPEC_STOCK = SPEC_STOCK;
    }

    public String getWBS_ELEM() {
        return WBS_ELEM;
    }

    public void setWBS_ELEM(String WBS_ELEM) {
        this.WBS_ELEM = WBS_ELEM;
    }
    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

}
