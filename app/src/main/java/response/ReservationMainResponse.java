package response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import model.Reservation;

/**
 * Created by muham on 12/21/2017.
 */

public class ReservationMainResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("content")
    private List<Reservation> reservationmain;


    public List<Reservation> getReservationMain() {
        return reservationmain;
    }

    public String getStatus() {
        return status;
    }
}
