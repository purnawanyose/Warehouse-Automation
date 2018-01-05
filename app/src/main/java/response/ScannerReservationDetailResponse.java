package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Reservation;

/**
 * Created by muham on 12/20/2017.
 */

public class ScannerReservationDetailResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Reservation> scannerreservationdetail;

    public List<Reservation> getScannerReservationDetail() {
        return scannerreservationdetail;
    }

    public String getStatus() {
        return status;
    }
}
