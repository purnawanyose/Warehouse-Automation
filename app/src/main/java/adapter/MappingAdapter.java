package adapter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import config.InterimRv;
import model.Interim;

/**
 * Created by muham on 1/15/2018.
 */

public class MappingAdapter extends RecyclerView.Adapter<MappingAdapter.ViewHolder> {
    ArrayList<String> lorong;
    String strg;

    String a;
    public MappingAdapter(ArrayList<String> lorong) {
        this.lorong = lorong;
    }

    @Override
    public MappingAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappingutamarv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MappingAdapter.ViewHolder viewHolder, int i) {
        viewHolder.mNamaLorong.setText(lorong.get(i));
        a = (String) viewHolder.mNamaLorong.getText();

        applyClickEvents(viewHolder,i);
    }

    @Override
    public int getItemCount() {
        return lorong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "MappingAdapter";
        public TextView mNamaLorong, strgBin;
        public ViewHolder(View itemView) {
            super(itemView);
            mNamaLorong = itemView.findViewById(R.id.nama_lorong);
            strgBin = itemView.findViewById(R.id.sbinText);
        }
    }

    private void applyClickEvents(final ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "MappingAdapter";

            @Override
            public void onClick(View view) {
                final String data = lorong.get(position);
                //======== Menuju ke form quant ========
                Log.e(TAG, "onClick: "+data );
            }
        });
    }

}
