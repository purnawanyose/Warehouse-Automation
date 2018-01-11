package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import fragment.Filter_material;
import model.Material;
import model.Reservation;

/**
 * Created by yosep on 1/11/2018.
 */

public class Main_ReservationRv extends RecyclerView.Adapter<Main_ReservationRv.MyViewHolder>{

    public ArrayList<Reservation> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView reserveno;
        TextView regdate;
        LinearLayout linear;
        String checked;
        Context context;
        private ArrayList<Reservation> matlist =  new ArrayList<Reservation>();

        private MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            reserveno = (TextView) view.findViewById(R.id.reserve_no);
            regdate = (TextView) view.findViewById(R.id.regdate);
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
        
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
