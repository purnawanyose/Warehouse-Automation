package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.Interim;
import model.OnHand;

public class OnHandRv extends RecyclerView.Adapter<OnHandRv.OnHandViewHolder> {

    TextView textView56, textView27;
    private Context context;
    Button button2;

    public ArrayList<OnHand> dataList;

    public OnHandRv(ArrayList<OnHand> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OnHandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.onhand_location_rv, parent, false);
        return new OnHandViewHolder(view);

    }

    @Override
    public void onBindViewHolder(OnHandViewHolder holder, int position) {

        String scanner = dataList.get(position).getQUANTITY();
        String[] scan = scanner.split("\\.");
        int s1 = Integer.parseInt(scan[0]);
        String ttl = String.valueOf(s1);
        Log.e("sss","aaaa"+ttl);

        holder.textView64.setText(dataList.get(position).getMATDESC() +"\n"+"\n"+ dataList.get(position).getMATNO());
        holder.textView30.setText(dataList.get(position).getSPCSTK());
        holder.textView65.setText(dataList.get(position).getVALTYPE());
        holder.textView90.setText(ttl);
        holder.textView91.setText(dataList.get(position).getUOM());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class OnHandViewHolder  extends RecyclerView.ViewHolder{
        TextView textView64,textView65, textView90, textView91, textView92,textView30;
        Button bOnHand;
        LinearLayout linearClear;

        OnHandViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView64 = (TextView) itemView.findViewById(R.id.textView64);
            textView65 = (TextView) itemView.findViewById(R.id.textView65);
            textView30 = (TextView) itemView.findViewById(R.id.textView30);
            textView90 = (TextView) itemView.findViewById(R.id.textView90);
            textView91 = (TextView) itemView.findViewById(R.id.textView91);
            bOnHand = (Button) itemView.findViewById(R.id.button2);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);
        }
    }
}
