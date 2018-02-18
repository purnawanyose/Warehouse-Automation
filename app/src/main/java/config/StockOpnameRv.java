package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.LoginActivity;
import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.DetailOpActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.Interim;
import model.Opname;
import response.ClearResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class StockOpnameRv extends RecyclerView.Adapter<StockOpnameRv.OpnameViewHolder> {


    private Context context;

    public ArrayList<Opname> dataList;

    public StockOpnameRv(ArrayList<Opname> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OpnameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.opname_rv, parent, false);
        return new OpnameViewHolder(view);


    }
    @Override
    public void onBindViewHolder(OpnameViewHolder holder, int position) {

        holder.textView92.setText(dataList.get(position).getPHYSINVENTORY());
        holder.textView104.setText(dataList.get(position).getPLANT());
        holder.textView105.setText(dataList.get(position).getSTGELOC());
        holder.textView106.setText(dataList.get(position).getFISCALYEAR()+"-"+dataList.get(position).getFISPERIOD());
        holder.textView107.setText(dataList.get(position).getSPECSTOCK());
        if (dataList.get(position).getCOUNTSTATUS().equalsIgnoreCase("")){
            holder.cbOpname.setChecked(true);
        }else{
            holder.cbOpname.setChecked(false);
        }


        applyClickEvents(holder,position);
 }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class OpnameViewHolder  extends RecyclerView.ViewHolder{
        TextView textView92,textView104, textView105, textView106, textView107, textView108;
        ImageView imgDetail;
        LinearLayout linearClear;
        CheckBox cbOpname;

        OpnameViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView92 = (TextView) itemView.findViewById(R.id.textView92);
            textView104 = (TextView) itemView.findViewById(R.id.textView104);
            textView105 = (TextView) itemView.findViewById(R.id.textView105);
            textView106 = (TextView) itemView.findViewById(R.id.textView106);
            textView107 = (TextView) itemView.findViewById(R.id.textView107);
            imgDetail = (ImageView) itemView.findViewById(R.id.imgDetail);
            cbOpname = (CheckBox) itemView.findViewById(R.id.cbOpname);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);


        }
    }
    private void applyClickEvents(StockOpnameRv.OpnameViewHolder holder, final int position) {
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Opname data = dataList.get(position);
                //======== Menuju ke form quant ========
                Intent intent = new Intent(context, DetailOpActivity.class );
                                intent.putExtra("PID", data.getPHYSINVENTORY());
                                intent.putExtra("FYEAR", data.getFISCALYEAR());
                context = view.getContext();
                view.getContext().startActivity(intent);

            }
        });
    }

}