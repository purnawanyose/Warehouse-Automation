package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.HomeActivity;
import com.semenindonesia.sisi.warehouseautomation.OnhandLocationActivity;
import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;
import com.semenindonesia.sisi.warehouseautomation.ReservationDetailActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.Main_ReservationRv;
import model.Cart;
import model.Interim;
import model.Reservation;
import response.CallCartResponse;
import response.ReservationDetailResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClientLocal;
import service.ApiInterface;

import static com.semenindonesia.sisi.warehouseautomation.OnhandLocationActivity.nilaiAkhir;

public class ReservationDetailRv extends RecyclerView.Adapter<ReservationDetailRv.ReservationDetailViewHolder> {

    TextView textView56, textView27;
    private Context context;
    String cc, ccc;
    public static String chart,tampung;
    public static String akhirNilai;
    public static String akhirNilaii[];
    public static String a;
    public static String b;
    public static String c;



    public ArrayList<Reservation> dataList;

    public ReservationDetailRv(ArrayList<Reservation> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ReservationDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.reservation_detail_rv, parent, false);
        return new ReservationDetailViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ReservationDetailViewHolder holder, final int position) {


        String scanner = dataList.get(position).getBDMNG();
        String[] scan = scanner.split("\\.");
        String scannerr = dataList.get(position).getENMNG();
        String[] scann = scannerr.split("\\.");
        int s1 = Integer.parseInt(scan[0]);
        int s2 = Integer.parseInt(scann[0]);
        int total = s1 - s2;
        String ttl = String.valueOf(total);

        Log.e("sdjajsjjfsdfhksdlbfosdhofk", "onBindViewHolder: " + total);
        Log.e("ASfdgdhsjak", "onBindViewHolder: " + scanner);
        Log.e("ASfdgdhsjak", "onBindViewHolder: " + scan);

        holder.textView67.setText(dataList.get(position).getRSPOS());
        holder.textView68.setText(dataList.get(position).getMAKTX()+"\n"+dataList.get(position).getMATNR());
        holder.textView69.setText(scan[0] + "/" + scann[0]);
        holder.textView70.setText(dataList.get(position).getMEINS());

        holder.textView72.setFocusable(false);
        click(holder, position);
        callBack(holder, position);


    }
    // END

    private void callBack(final ReservationDetailViewHolder holder, final int position){
         /*Create handle for the RetrofitInstance interface*/
        final ApiInterface apiService = ApiClientLocal.getClient().create(ApiInterface.class);

        Call<CallCartResponse> call = apiService.getCallCart(dataList.get(position).getRSNUM(),
                dataList.get(position).getRSPOS());

                /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<CallCartResponse>() {

            @Override
            public void onResponse(Call<CallCartResponse> call, Response<CallCartResponse> response) {
                List<Cart> content = response.body().getCart();
                for (Cart data : content) {
                    if (data.getSTATUS().equalsIgnoreCase("1")){

                        Log.e("Test CallBack", "onResponse: "+data.getENTRY_QNT());
                        holder.textView72.setText(data.getENTRY_QNT());
                        cart(holder, position);
                    }else{

                    }
                }
            }

            @Override
            public void onFailure(Call<CallCartResponse> call, Throwable t) {
                Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Log.e("Test", "onFailure: "+Call.class );
            }
        });

    }

    private void cart(final ReservationDetailViewHolder holder, final int position){

        if (holder.textView72.getText() != null){
            ReservationDetailActivity.cart[position] =  1;
            Log.e("Test Textview  " +position, "onResponse: "+holder.textView72.getText());
            Log.e("Test Cart Position Value  " +position, "onResponse: "+ReservationDetailActivity.cart[position]);
            ReservationDetailActivity.cartt = ReservationDetailActivity.cartt +1;
            Log.e("cart update", "cart: "+ReservationDetailActivity.cartt);

        }else{
            ReservationDetailActivity.cart[position] =  0;
            Log.e("Test Cart Position Value  " +position, "onResponse: 0");
        }


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ReservationDetailViewHolder extends RecyclerView.ViewHolder {
        TextView textView67, textView68, textView69, textView70, textView71,textView66;
        EditText textView72;
        LinearLayout linearClear;
        ImageView img;
        Button btnIssued;

        ReservationDetailViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView67 = (TextView) itemView.findViewById(R.id.textView67);
            textView68 = (TextView) itemView.findViewById(R.id.textView68);
            textView69 = (TextView) itemView.findViewById(R.id.textView69);
            textView70 = (TextView) itemView.findViewById(R.id.textView70);
            textView71 = (TextView) itemView.findViewById(R.id.textView71);
            textView72 = (EditText) itemView.findViewById(R.id.textView72);
            textView66 = (EditText) itemView.findViewById(R.id.textView66);
            btnIssued = (Button) itemView.findViewById(R.id.btnGoodIssued);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
    private void click(final ReservationDetailViewHolder holder, final int position) {
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Reservation data = dataList.get(position);
                Intent intent = new Intent(context, OnhandLocationActivity.class);
                intent.putExtra("PLANT", data.getWERKS());
                intent.putExtra("RSVNO", data.getRSNUM());
                intent.putExtra("ORDER", data.getAUFNR());
                intent.putExtra("MATNR", data.getMAKTX()+" "+data.getMATNR());
                intent.putExtra("MATNO", data.getMATNR());
                intent.putExtra("WERKS", data.getBWART());
                intent.putExtra("LGORT", data.getLGORT());
                intent.putExtra("RSPOS", data.getRSPOS());
                context = v.getContext();
                v.getContext().startActivity(intent);
            }
        });
    }
}
