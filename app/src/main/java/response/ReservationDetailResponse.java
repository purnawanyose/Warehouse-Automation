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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}
