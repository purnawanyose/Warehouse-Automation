package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Reservation;

/**
 * Created by muham on 12/20/2017.
 */

public class ScannerReservationPageResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Reservation> scannerreservationpage;

    public List<Reservation> getScannerReservationPage() {
        return scannerreservationpage;
    }

    public String getStatus() {
        return status;
    }
}
