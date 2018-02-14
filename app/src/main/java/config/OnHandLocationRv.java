package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
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

import adapter.BinAdapter;
import model.OnHandLocation;
import model.Reservation;

public class OnHandLocationRv extends RecyclerView.Adapter<OnHandLocationRv.OnhandLocationViewHolder> {


    private Context context;

    public ArrayList<OnHandLocation> dataList;
    public static String qty;

    public OnHandLocationRv(ArrayList<OnHandLocation> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OnhandLocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.onhand_rv, parent, false);
        return new OnhandLocationViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final OnhandLocationViewHolder holder, final int position) {
        String scanner = dataList.get(position).getQTY();
        String[] scan = scanner.split("\\.");
        int s1 = Integer.parseInt(scan[0]);
        String ttl = String.valueOf(s1);
        Log.e("sss","aaaa"+ttl);

        holder.sbin = dataList.get(position).getSBIN();

        holder.ohl1.setText(dataList.get(position).getSLOC()+"\n"+ dataList.get(position).getWHN());
        holder.ohl2.setText(dataList.get(position).getSTYPE()+"\n"+ dataList.get(position).getSBIN());
        holder.ohl3.setText(dataList.get(position).getBATCH());
        holder.ohl4.setText(dataList.get(position).getSS());
        holder.ohl5.setText(dataList.get(position).getSSK());
        holder.ohl6.setText(ttl);

        if (OnhandLocationActivity.scan.equalsIgnoreCase(dataList.get(position).getSBIN())){
            holder.et2.setEnabled(true);
            holder.et2.setFocusable(true);
        }
//        clickEvents(holder, position);


        clickEvents(holder, position);

    }

    public int getItemCount() {
        return dataList.size();
    }

    public class OnhandLocationViewHolder extends RecyclerView.ViewHolder {
        TextView ohl1, ohl2, ohl3, ohl4, ohl5,ohl6,ohl7, tvScann;
        EditText et2;
        String sbin;

        OnhandLocationViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            ohl1 = (TextView) itemView.findViewById(R.id.ohl1);
            ohl2 = (TextView) itemView.findViewById(R.id.ohl2);
            ohl3 = (TextView) itemView.findViewById(R.id.ohl3);
            ohl4 = (TextView) itemView.findViewById(R.id.ohl4);
            ohl5 = (TextView) itemView.findViewById(R.id.ohl5);
            ohl6 = (TextView) itemView.findViewById(R.id.ohl6);
            et2 = (EditText) itemView.findViewById(R.id.et2);
            tvScann = (TextView) itemView.findViewById(R.id.tvScann);

            et2.setEnabled(true);
        }
    }
    private void clickEvents(final OnHandLocationRv.OnhandLocationViewHolder holder, final int position){
        holder.et2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    if (holder.et2.getText().length() <1){

                    }else{
                        OnhandLocationActivity.qtybroo[position] = Integer.parseInt(holder.et2.getText().toString());
                        OnhandLocationActivity.specialStock[position] =(holder.ohl4.getText().toString());
                        OnhandLocationActivity.wbs_elem[position] = (holder.ohl5.getText().toString());
                        OnhandLocationActivity.val_type[position] = (holder.ohl3.getText().toString());
                    }
                }
                return false;
            }
        });
    }
}
