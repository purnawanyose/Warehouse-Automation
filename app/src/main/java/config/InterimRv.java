package config;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.ImageViewActivity;
import com.semenindonesia.sisi.warehouseautomation.InterimActivity;
import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;
import java.util.List;

import model.Interim;
import model.Quant;
import response.ClearResponse;
import response.InterimResponse;
import response.QuantResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import service.ApiClient;
import service.ApiInterface;

import static android.support.v4.content.ContextCompat.startActivity;

public class InterimRv extends RecyclerView.Adapter<InterimRv.InterimViewHolder> {

    TextView textView56, textView27;
    private Context context;

    public ArrayList<Interim> dataList;

    public InterimRv(ArrayList<Interim> dataList) {
        this.dataList = dataList;
    }

    @Override
    public InterimViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.interim_rv, parent, false);
        return new InterimViewHolder(view);


    }
    @Override
    public void onBindViewHolder(InterimViewHolder holder, int position) {
        holder.textView51.setText(dataList.get(position).getmAKTX() +"\n"+"\n"+ dataList.get(position).getMATNR());
        holder.textView52.setText(dataList.get(position).getWERKS()+"/"+dataList.get(position).getLGORT()+"\n"+"\n"+dataList.get(position).getLGNUM()+"/"+dataList.get(position).getLGTYP()+"\n"+"\n"+dataList.get(position).getLGPLA());
        holder.textView53.setText(dataList.get(position).getCHARG()+"\n"+"\n"+dataList.get(position).getSOBKZ());
        holder.textView54.setText(dataList.get(position).getVERME());
        holder.textView55.setText(dataList.get(position).getMEINS());
        holder.textView56.setText(dataList.get(position).getLQNUM());

        applyClickEvents(holder,position);
//        holder.txtEmpEmail.setText(dataList.get(position).getEmail());
//        holder.txtEmpPhone.setText(dataList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class InterimViewHolder  extends RecyclerView.ViewHolder{
        TextView textView51,textView52, textView53, textView54, textView55, textView56;
        LinearLayout linearClear;

        InterimViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView51 = (TextView) itemView.findViewById(R.id.textView51);
            textView52 = (TextView) itemView.findViewById(R.id.textView52);
            textView53 = (TextView) itemView.findViewById(R.id.textView53);
            textView54 = (TextView) itemView.findViewById(R.id.textView54);
            textView55 = (TextView) itemView.findViewById(R.id.textView55);
            textView56 = (TextView) itemView.findViewById(R.id.textView56);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);
        }
    }
    private void applyClickEvents(InterimRv.InterimViewHolder holder, final int position) {
        holder.textView56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Interim data = dataList.get(position);
                //======== Menuju ke form quant ========
                Intent intent = new Intent(context, QuantDetailActivity.class );
                                intent.putExtra("MATNR", data.getMATNR());
                                intent.putExtra("WERKS", data.getWERKS());
                                intent.putExtra("LQNUM", data.getLQNUM());
                                intent.putExtra("LGTYP", data.getLGTYP());
                context = view.getContext();
                view.getContext().startActivity(intent);
            }
        });
    }
    private void clearEvent(InterimRv.InterimViewHolder holder, final int position) {
        holder.linearClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Interim data = dataList.get(position);
                int a = Integer.parseInt(String.valueOf(data.getVERME()));

              /*  if(data.getSOBKZ().equals("K")&&(a < 0)){
                    final Context context = this.getApplicationContext();
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    Call<ClearResponse> call = apiService.getQuant(WERKSS,LGTYPP,LQNUMM,MATNRR);
//        Call<QuantResponse> call = apiService.getQuant("7702","902","602","623-000013");


                    Log.e("aa","bb"+ Call.class);
                    call.enqueue(new Callback<ClearResponse>() {
                        @Override
                        public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {
                            List<Interim> content = response.body().getClear();
                            Log.e("content", "Material No " + content);
                            for (Quant data : content) {
                                Log.e("content", "Material No " + content.toString());

                            }
                        }

                        @Override
                        public void onFailure(Call<ClearResponse> call, Throwable t) {
                            t.printStackTrace();
                            Log.e("Interim", "Material Noooooooooooo"+ call);

                        }
                    });
                }else if(a>0){

                }else if(a<0){

                }else{

                }*/
                //======== Menuju ke form quant ========
                Intent intent = new Intent(context, QuantDetailActivity.class );
                intent.putExtra("MATNR", data.getMATNR());
                intent.putExtra("WERKS", data.getWERKS());
                intent.putExtra("LQNUM", data.getLQNUM());
                intent.putExtra("LGTYP", data.getLGTYP());
                context = view.getContext();
                view.getContext().startActivity(intent);
            }
        });
    }
}
