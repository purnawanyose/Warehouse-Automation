package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.BinActivity;
import com.semenindonesia.sisi.warehouseautomation.MappingUtamaActivity;
import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;
import com.semenindonesia.sisi.warehouseautomation.ReservationDetailActivity;

import java.util.ArrayList;

import config.InterimRv;
import fragment.Filter_material;
import model.Interim;
import model.Material;
import model.Reservation;

/**
 * Created by yosep on 1/11/2018.
 */

public class Main_ReservationRv extends RecyclerView.Adapter<Main_ReservationRv.MyViewHolder>{
    private Context context;
    public ArrayList<Reservation> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView reserveno;
        TextView regdate;
        LinearLayout linear;
        String checked;
        Context context;
        ImageView img_search;
        private ArrayList<Reservation> matlist =  new ArrayList<Reservation>();


        private MyViewHolder(View view) {
            super(view);

            reserveno = (TextView) view.findViewById(R.id.reserve_no);
            regdate = (TextView) view.findViewById(R.id.regdate);
            img_search = (ImageView) view.findViewById(R.id.img_search);
            context = view.getContext();
        }
    }

    public Main_ReservationRv(ArrayList<Reservation> dataList){
        this.dataList = dataList;
    }

    @Override
    public Main_ReservationRv.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reservation_main_rv, parent, false);

        return new Main_ReservationRv.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Main_ReservationRv.MyViewHolder holder, final int position) {
        Log.e("data check", " "+ dataList.size());
        holder.reserveno.setText(dataList.get(position).getRSNUM());
        holder.regdate.setText(dataList.get(position).getBDART());
        click(holder, position);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void click(final Main_ReservationRv.MyViewHolder holder, final int position){
        holder.img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Reservation data = dataList.get(position);
                Intent intent = new Intent(holder.context, ReservationDetailActivity.class);
                intent.putExtra("RSNUM", data.getRSNUM());
                intent.putExtra("WERKS", data.getWERKS());
                intent.putExtra("LGORT", data.getLGORT());

                context = v.getContext();
                v.getContext().startActivity(intent);

            }
        });
    }
}

