package service;

//import muhammadazmib.rertofitbasic.model.Items;
import android.util.Log;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.ScannerReservationDetail;

import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import model.Cart;
import model.Interim;
import model.OnHand;
import model.Reservation;
import response.BonSementaraResponse;
import response.CallCartResponse;
import response.ClearResponse;
import response.DetailResponse;
import response.InterimResponse;
import response.IssuedResponse;
import response.MasterSpecialStockResponse;
import response.MaterialResponse;
import response.MovTypeSelectionResponse;
import response.OnHandLocationResponse;
import response.OnHandResponse;
import response.PostingResponse;
import response.QuantResponse;
import response.ReservationDetailResponse;
import response.ReservationMainResponse;
import response.ScannerReservationDetailResponse;
import response.ScannerReservationPageResponse;
import response.StockOpnameDetailResponse;
import response.StockOpnameResponse;
import response.TranslocResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by muham on 12/12/2017.
 */

public interface ApiInterface {
    @GET("Interim/detail/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=7702&lgtyp[0]=9*")
    Call<InterimResponse> getInterim();

    @GET("Reservation/resumeInterim/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=7702&lgtyp[0]=9*")
    Call<ClearResponse> getHomeInterim();

    @GET("Reservation/resumeReservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=2702&werks[1]=7702")
    Call<ClearResponse> getHomeReservation();

    @GET("Reservation/resumeOpname/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=7702")
    Call<ClearResponse> getHomeOpname();

    @GET("Reservation/stockwm/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<OnHandResponse> getOnHand(
            @Query("text") String text,
            @Query("lgnum") String lgnum,
            @Query("lgtyp") String lgtyp,
            @Query("lgpla") String lgpla
    );
    @GET("Reservation/stockwm/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<OnHandResponse> getOnHandIm(
            @Query("text") String text,
            @Query("plant") String plant,
            @Query("sloc") String sloc
    );
    /*@GET("Reservation/stockwm/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?text=WM&lgnum=204&lgtyp=SG4&lgpla=A.A1.3.02")
    Call<OnHandResponse> getOnHand();
*/

    @GET("Interim/detail/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<QuantResponse> getQuant(
            @Query("werks[0]") String werks,
            @Query("lgtyp[0]") String lgtype,
            @Query("lqnum[0]") String lqnum,
            @Query("matnr[0]") String matnr
            );

    @GET("Interim/clearInterim/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ClearResponse> getClear(
      @Query("data[I_LGNUM]") String i_gnum,
      @Query("data[I_BWLVS]") String i_bwlvs,
      @Query("data[I_MATNR]") String i_matnr,
      @Query("data[I_LGORT]") String i_lgort,
      @Query("data[I_CHARG]") String i_charg,
      @Query("data[I_ANFME]") String i_anfme,
      @Query("data[I_ALTME]") String i_altme,
      @Query("data[I_NLQNR]") String i_nlqnr,
      @Query("data[I_COMMIT_WORK]") String i_commit_work,
      @Query("data[I_BNAME]") String i_bname,
      @Query("data[I_KOMPL]") String i_kompl,
      @Query("data[I_SOBKZ]") String i_sobkz,
      @Query("data[I_SONUM]") String i_sonum
    );

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ReservationDetailResponse> getReservation(
            @Query("werks[1]") String rwerks,
            @Query("rsnum[0]") String rsnum,
            @Query("detail") String detail);


    @GET("Reservation/listBonSementara/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[1]=7702&rsortf[0]=BS*&rdetail=1")
    Call<BonSementaraResponse> getBonSementara();


    @GET("Reservation/listBonSementara/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[1]=7702&rsortf[0]=BS*")
    Call<ClearResponse> getHomeBonSementara();

    @GET("Opname/list/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=7702")
    Call<StockOpnameResponse> getStockOpname();

    @GET("Opname/detail/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<DetailResponse> getOpnameDetail(
            @Query("pid") String pid,
            @Query("fiscalyear") String fiscalyear
    );
    @GET(" Opname/list/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<StockOpnameResponse> getScannerOpnameDetail(
            @Query("werks[0]") String werks,
            @Query("stge[0]") String stge
    );

    @GET(" Opname/count/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<PostingResponse> getCountOpname(
            @Query("pid") String pid,
            @Query("fiscalyear") String fiscalyear,
            @Query("date") String date,
            @Query("items[0][ITEM]") String ITEM,
            @Query("items[0][MATERIAL]") String MATERIAL,
            @Query("items[0][ENTRY_QNT]") String ENTRY_QNT,
            @Query("items[0][ENTRY_UOM]") String ENTRY_UOM
    );
    @GET(" Opname/recount/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<PostingResponse> getRecountOpname(
            @Query("pid") String pid,
            @Query("fiscalyear") String fiscalyear,
            @Query("items[0][ITEM]") String ITEM,
            @Query("items[0][MATERIAL]") String MATERIAL,
            @Query("items[0][ENTRY_QNT]") String ENTRY_QNT,
            @Query("items[0][ENTRY_UOM]") String ENTRY_UOM
    );
    @GET(" Opname/posting/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<PostingResponse> getPostingOpname(
            @Query("pid") String pid,
            @Query("fiscalyear") String fiscalyear,
            @Query("date") String date
    );


    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[0]=7702&rlgort[0]=W210&mvtind=X&includeUnapprove=1")
    Call<ScannerReservationPageResponse> getScannerReservationPage();

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[1]=7702&rlgort[0]=W210&rsnum[0]=51556926&detail=1")
    Call<ScannerReservationDetailResponse> getScannerReservationDetail();

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ReservationMainResponse> getReservationMain(
            @Query("rsnum") String rsnum,
            @Query("rwerks[1]") String rwerks,
            @Query("rbwart[0]") String rbwart,
            @Query("rmatnr") String rmatnr,
            @Query("mvtind") String mvtind,
            @Query("final") String finalz,
            @Query("delete") String delete,
            @Query("bdter_awal") String bdter_awal,
            @Query("bdter_akhir") String bdter_akhir
    );

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ReservationMainResponse> getReservationMainRsv(
            @Query("rsnum[0]") String rsnum,
            @Query("rwerks[1]") String rwerks,
            @Query("rbwart[0]") String rbwart,
            @Query("rmatnr") String rmatnr,
            @Query("mvtind") String mvtind,
            @Query("final") String finalz,
            @Query("delete") String delete,
            @Query("bdter_awal") String bdter_awal,
            @Query("bdter_akhir") String bdter_akhir
    );


    @GET("Master/spesialStok/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<MasterSpecialStockResponse> getMasterSpecialStock();

    @GET("Master/movementType/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<MovTypeSelectionResponse> getMovTypeSelection(
            @Query("bwart[0]") String bwart,
            @Query("sobkz[0]") String sobkz
    );

    @GET("Master/material/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<MaterialResponse> getMaterial(
            @Query("row") String row,
            @Query("matnr[0]") String matnr,
            @Query("maktg[0]") String maktg
    );
    @GET("Reservation/stockMaterial/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<OnHandLocationResponse> getOnhandLocation(
            @Query("werks[0]") String werks,
            @Query("matnr[0]") String matnr
    );

    @GET("Interim/clearInterim/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ClearResponse> getVermePositif(
            @Query("data[I_LGNUM]") String i_lgnum,
            @Query("data[I_BWLVS]") String bwlvs,
            @Query("data[I_MATNR]") String matnr,
            @Query("data[I_WERKS]") String werks,
            @Query("data[I_LGORT]") String lgort,
            @Query("data[I_CHARG]") String charg,
            @Query("data[I_ANFME]") String anfme,
            @Query("data[I_ALTME]") String altme,
            @Query("data[I_VLQNR]") String vlqnr,
            @Query("data[I_COMMIT_WORK]") String commit,
            @Query("data[I_BNAME]") String bname,
            @Query("data[I_KOMPL]") String kompl
    );
    @GET("Interim/clearInterim/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ClearResponse> getVermeNegatif(
            @Query("data[I_LGNUM]") String i_lgnum,
            @Query("data[I_BWLVS]") String bwlvs,
            @Query("data[I_MATNR]") String matnr,
            @Query("data[I_WERKS]") String werks,
            @Query("data[I_LGORT]") String lgort,
            @Query("data[I_CHARG]") String charg,
            @Query("data[I_ANFME]") String anfme,
            @Query("data[I_ALTME]") String altme,
            @Query("data[I_NLQNR]") String nlqnr,
            @Query("data[I_COMMIT_WORK]") String commit,
            @Query("data[I_BNAME]") String bname,
            @Query("data[I_KOMPL]") String kompl
    );
    @GET("Interim/clearInterim/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ClearResponse> getSobkz(
            @Query("data[I_LGNUM]") String i_lgnum,
            @Query("data[I_BWLVS]") String bwlvs,
            @Query("data[I_MATNR]") String matnr,
            @Query("data[I_WERKS]") String werks,
            @Query("data[I_LGORT]") String lgort,
            @Query("data[I_CHARG]") String charg,
            @Query("data[I_ANFME]") String anfme,
            @Query("data[I_ALTME]") String altme,
            @Query("data[I_NLQNR]") String nlqnr,
            @Query("data[I_COMMIT_WORK]") String commit,
            @Query("data[I_BNAME]") String bname,
            @Query("data[I_KOMPL]") String kompl,
            @Query("data[I_SOBKZ]") String sobkz,
            @Query("data[I_SONUM]") String sonum
    );

    @GET("save_detail.php")
    Call<ReservationDetailResponse> getApiLocal(
            @Query("PR_UNAME") String PR_UNAME,
            @Query("PLANT") String PLANT,
            @Query("MOVE_TYPE") String MOVE_TYPE,
            @Query("ENTRY_QNT") String ENTRY_QNT,
            @Query("RESERV_NO") String RESERV_NO,
            @Query("RES_ITEM") String RES_ITEM,
            @Query("STGE_LOC") String STGE_LOC,
            @Query("VAL_TYPE") String VAL_TYPE,
            @Query("SPEC_STOCK") String SPEC_STOCK,
            @Query("WBS_ELEM") String WBS_ELEM
    );
    @GET("list_reservasi.php")
    Call<CallCartResponse> getCallCart(
            @Query("RESERV_NO") String RESERV_NO,
            @Query("RES_ITEM") String RES_ITEM
    );
    @GET("delete_reservasi.php")
    Call<CallCartResponse> getDelete(
            @Query("RESERV_NO") String RESERV_NO
    );

    @GET("all_reservasi.php")
    Call<CallCartResponse> getAll(
            @Query("RESERV_NO") String RESERV_NO
    );

    @GET("cart_count.php")
    Call<CallCartResponse> getCartValue(
            @Query("RESERV_NO") String RESERV_NO
    );


    @GET("Reservation/bonSementara/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<BonSementaraResponse> getUnflagBon(
            @Query("rsnum[]") String rsnum,
            @Query("rspos[]") String rspos,
            @Query("flag") String flag

    );

    @POST("get_data.php")
    @FormUrlEncoded
    Call <IssuedResponse> setPostIssued(
            @Field("DOC_DATE") String DOC_DATE,
            @Field("PSTNG_DATE") String PSTNG_DATE,
            @Field("HEADER_TXT") String HEADER_TXT,
            @Field("RESERV_NO") String RESERV_NO

    );


    @POST ("Reservation/goodIssue/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    @FormUrlEncoded
    Call <IssuedResponse> setGoodIssued(
            @Field("header[PSTNG_DATE]") String PSTNG_DATE,
            @Field("header[DOC_DATE]") String DOC_DATE,
            @Field("header[HEADER_TXT]") String HEADER_TXT,
            @Field("detail[][PR_UNAME]") ArrayList<String> PR_UNAME,
            @Field("detail[][PLANT]") ArrayList<String> PLANT,
            @Field("detail[][MOVE_TYPE]") ArrayList<String> MOVE_TYPE,
            @Field("detail[][ENTRY_QNT]") ArrayList<String> ENTRY_QNT,
            @Field("detail[][RESERV_NO]") ArrayList<String> RESERV_NO,
            @Field("detail[][RES_ITEM]") ArrayList<String> RES_ITEM,
            @Field("detail[][STGE_LOC]") ArrayList<String> STGE_LOC,
            @Field("detail[][VAL_TYPE]") ArrayList<String> VAL_TYPE,
            @Field("detail[][SPEC_STOCK]") ArrayList<String> SPEC_STOCK,
            @Field("detail[][WBS_ELEM]") ArrayList<String> WBS_ELEM
    );

    @POST ("get_transloc.php")
    @FormUrlEncoded
    Call <TranslocResponse> setTransloc(
            @Field("PSTNG_DATE") String PSTNG_DATE,
            @Field("DOC_DATE") String DOC_DATE,
            @Field("HEADER_TXT") String HEADER_TXT,
            @Field("MATERIAL") String MATERIAL,
            @Field("PLANT") String PLANT,
            @Field("STGE_LOC") String STGE_LOC,
            @Field("MOVE_TYPE") String MOVE_TYPE,
            @Field("VAL_TYPE") String VAL_TYPE,
            @Field("ENTRY_QNT") String ENTRY_QNT,
            @Field("MOVE_STLOC") String MOVE_STLOC,
            @Field("SPEC_STOCK") String SPEC_STOCK,
            @Field("WBS_ELEM") String WBS_ELEM
    );


}
















