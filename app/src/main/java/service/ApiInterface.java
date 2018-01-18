package service;

//import muhammadazmib.rertofitbasic.model.Items;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.ScannerReservationDetail;

import javax.xml.transform.Result;

import model.Reservation;
import response.BonSementaraResponse;
import response.ClearResponse;
import response.InterimResponse;
import response.MasterSpecialStockResponse;
import response.MaterialResponse;
import response.MovTypeSelectionResponse;
import response.OnHandResponse;
import response.QuantResponse;
import response.ReservationDetailResponse;
import response.ReservationMainResponse;
import response.ScannerReservationDetailResponse;
import response.ScannerReservationPageResponse;
import response.StockOpnameResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by muham on 12/12/2017.
 */

public interface ApiInterface {
    @GET("Interim/detail/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=7702&lgtyp[0]=9*")
    Call<InterimResponse> getInterim();

    @GET("Reservation/resumeReservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=2702&werks[1]=7702")
    Call<ReservationMainResponse> getHomeReservation();

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

    @GET("Opname/list/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?werks[0]=7702")
    Call<StockOpnameResponse> getStockOpname();

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[0]=7702&rlgort[0]=W210&mvtind=X&includeUnapprove=1")
    Call<ScannerReservationPageResponse> getScannerReservationPage();

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[1]=7702&rlgort[0]=W210&rsnum[0]=51556926&detail=1")
    Call<ScannerReservationDetailResponse> getScannerReservationDetail();
//
//    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8?rwerks[X1]={plant}&rsnum[1]={norev}&rbwart[0]={movtype}&matnr={matno}")
//    Call<ReservationMainResponse> getReservationMain(@Path("plant") String plant, @Path("norev") String norev, @Path("movtype") String movtype, @Path("matno") String matno);

    @GET("Reservation/reservasi/X-API-KEY/80ccwwsk44ko4k8ko0wgw0sog484s8kg44ooc8s8")
    Call<ReservationMainResponse> getReservationMain(
            @Query("rwerks[1]") String rwerks,
            @Query("rlgort[0]") String rlgort,
            @Query("rsnum[0]") String rsnum,
            @Query("detail") String detail

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


}
