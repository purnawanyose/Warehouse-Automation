package config;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.semenindonesia.sisi.warehouseautomation.ImageViewActivity;
import com.semenindonesia.sisi.warehouseautomation.InterimActivity;
import com.semenindonesia.sisi.warehouseautomation.PostIssuedActivity;
import com.semenindonesia.sisi.warehouseautomation.LoginActivity;
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
        clear(holder, position);
 }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class InterimViewHolder  extends RecyclerView.ViewHolder{
        TextView textView51,textView52, textView53, textView54, textView55, textView56;
        ImageView imgClear;
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
            imgClear = (ImageView) itemView.findViewById(R.id.imgClear);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);


        }
    }
    private void clear(final InterimRv.InterimViewHolder holder, final int position){
        holder.imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String verme =dataList.get(position).getVERME();
                String[] vermeArray = verme.split("\\.");

                int verme1 = Integer.parseInt(vermeArray[0]);
                Log.e("Test Verme", "clear: "+verme1);

                if (verme1 >=0){
                     /*Create handle for the RetrofitInstance interface*/
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    /*Call the method with parameter in the interface to get the employee data*/
//                    Call<InterimResponse> call = apiService.getInterim();
                    Call<ClearResponse> call = apiService.getVermePositif(dataList.get(position).getLGNUM()
                            ,"999" // BWLVS
                            ,dataList.get(position).getMATNR()
                            ,dataList.get(position).getWERKS()
                            ,dataList.get(position).getLGORT()
                            ,dataList.get(position).getCHARG()
                            ,dataList.get(position).getVERME()
                            ,dataList.get(position).getMEINS()
                            ,dataList.get(position).getLQNUM()
                            ,"X"
                            ,LoginActivity.pr_uname
                            ,"X");

                    /*Log the URL called*/
                    Log.wtf("URL Called", call.request().url() + "");

                    call.enqueue(new Callback<ClearResponse>() {

                        @Override
                        public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {
//                            generateInterimResponse((ArrayList<Interim>) response.body().getInterim());
                            Toast.makeText(context,response.body().getContent(),Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onFailure(Call<ClearResponse> call, Throwable t) {
                            Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if (verme1 <=1){

                    /*Create handle for the RetrofitInstance interface*/
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    /*Call the method with parameter in the interface to get the employee data*/
//                    Call<InterimResponse> call = apiService.getInterim();
                    Call<ClearResponse> call = apiService.getVermeNegatif(dataList.get(position).getLGNUM()
                            ,"999" // BWLVS
                            ,dataList.get(position).getMATNR()
                            ,dataList.get(position).getWERKS()
                            ,dataList.get(position).getLGORT()
                            ,dataList.get(position).getCHARG()
                            ,dataList.get(position).getVERME()
                            ,dataList.get(position).getMEINS()
                            ,dataList.get(position).getLQNUM()
                            ,"X"
                            ,LoginActivity.pr_uname
                            ,"X");
                    /*Log the URL called*/
                    Log.wtf("URL Called", call.request().url() + "");

                    call.enqueue(new Callback<ClearResponse>() {

                        @Override
                        public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {

                            Toast.makeText(context,response.body().getContent(),Toast.LENGTH_LONG).show();

//                            generateInterimResponse((ArrayList<Interim>) response.body().getInterim());
                           /* List<Interim> content = response.body().getInterim();
                            String status = response.body().getStatus();
                            if (status.equals("0")){
                                Toast.makeText(context,"Gagal Melakukan Clearing!",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context,"Sukses Melakukan Clearing!",Toast.LENGTH_LONG).show();
                            }
                            if (content.size() < 1){
                                Toast.makeText(context,"Data Not Found!",Toast.LENGTH_LONG).show();
                            }*/
                        }
                        @Override
                        public void onFailure(Call<ClearResponse> call, Throwable t) {
                            Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if (dataList.get(position).getSOBKZ().equalsIgnoreCase("K") && verme1 <=1){
                    /*Create handle for the RetrofitInstance interface*/
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                    /*Call the method with parameter in the interface to get the employee data*/
//                    Call<InterimResponse> call = apiService.getInterim();
                    Call<ClearResponse> call = apiService.getSobkz(dataList.get(position).getLGNUM()
                            ,"999"
                            ,dataList.get(position).getMATNR()
                            ,dataList.get(position).getWERKS()
                            ,dataList.get(position).getLGORT()
                            ,dataList.get(position).getCHARG()
                            ,dataList.get(position).getVERME()
                            ,dataList.get(position).getMEINS()
                            ,dataList.get(position).getLQNUM()
                            ,"X"
                            ,LoginActivity.pr_uname
                            ,"X"
                            ,dataList.get(position).getSOBKZ()
                            ,dataList.get(position).getSONUM());
                    /*Log the URL called*/
                    Log.wtf("URL Called", call.request().url() + "");

                    call.enqueue(new Callback<ClearResponse>() {

                        @Override
                        public void onResponse(Call<ClearResponse> call, Response<ClearResponse> response) {
                            Toast.makeText(context,response.body().getContent(),Toast.LENGTH_LONG).show();


                          /*  generateInterimResponse((ArrayList<Interim>) response.body().getInterim());
                            List<Interim> content = response.body().getInterim();
                            String status = response.body().getStatus();
                            if (status.equals("0")){
                                Toast.makeText(context,"Gagal Melakukan Clearing!",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(context,"Sukses Melakukan Clearing!",Toast.LENGTH_LONG).show();
                            }
                            if (content.size() < 1){
                                Toast.makeText(context,"Data Not Found!",Toast.LENGTH_LONG).show();
                            }*/
                        }
                        @Override
                        public void onFailure(Call<ClearResponse> call, Throwable t) {
                            Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{

                }

            }
        });


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

}