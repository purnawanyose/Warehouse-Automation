package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.OnhandLocationActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.OnHandLocation;
import model.Reservation;

public class OnHandLocationRv extends RecyclerView.Adapter<OnHandLocationRv.OnhandLocationViewHolder> {


    private Context context;

    public ArrayList<OnHandLocation> dataList;

    public OnHandLocationRv(ArrayList<OnHandLocation> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OnhandLocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.onhand_location_rv, parent, false);
        return new OnhandLocationViewHolder(view);

    }

    @Override
    public void onBindViewHolder(OnhandLocationViewHolder holder, int position) {

        holder.textView64.setText(dataList.get(position).getSLOC()+"\n"+ dataList.get(position).getWHN());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class OnhandLocationViewHolder extends RecyclerView.ViewHolder {
        TextView textView64, textView65, textView30, textView90, textView91;
        EditText et2;

        OnhandLocationViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView64 = (TextView) itemView.findViewById(R.id.textView64);
            textView65 = (TextView) itemView.findViewById(R.id.textView65);
            textView30 = (TextView) itemView.findViewById(R.id.textView30);
            textView90 = (TextView) itemView.findViewById(R.id.textView90);
            textView91 = (TextView) itemView.findViewById(R.id.textView91);
            et2 = (EditText) itemView.findViewById(R.id.et2);

        }
    }

}
