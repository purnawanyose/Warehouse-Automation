package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Interim;
import model.Quant;
import model.Reservation;

/**
 * Created by muham on 12/18/2017.
 */

public class ReservationDetailResponse {
    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List <Reservation> reservation;


    public List<Reservation> getReservation() {
        return reservation;
    }

    public String getStatus() {
        return status;
    }
}
