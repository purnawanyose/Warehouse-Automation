package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import fragment.Filter_material;
import model.Material;
import model.MovTypeSelection;

/**
 * Created by yosep on 1/10/2018.
 */

public class Filter_MaterialRv extends RecyclerView.Adapter<Filter_MaterialRv.MyViewHolder> {

    public ArrayList<Material> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textmatno;
        TextView textmatdesc;
        LinearLayout linear;
        RadioGroup rg;
        String checked;
        Context context;
        private ArrayList<Material> matlist =  new ArrayList<Material>();

        private MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            textmatno = (TextView) view.findViewById(R.id.text_matno);
            textmatdesc = (TextView) view.findViewById(R.id.textdesc);
            rg = (RadioGroup) view.findViewById(R.id.radiogroup);
        }
    }

    public Filter_MaterialRv(ArrayList<Material> dataList){
        this.dataList = dataList;
    }

    @Override
    public Filter_MaterialRv.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filter_materialrv, parent, false);

        return new Filter_MaterialRv.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Filter_MaterialRv.MyViewHolder holder, final int position) {
        Log.e("data check", " "+ dataList.size());
        holder.textmatno.setText(dataList.get(position).getMATNR());
        holder.textmatdesc.setText(dataList.get(position).getMAKTX());

        final RadioButton[] rb = new RadioButton[Filter_material.materiallist];
        Log.e("matlist : ", ""+Filter_material.materiallist);
        rb[position] = new RadioButton(holder.context);
        rb[position].setId(position);
        rb[position].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e("checked : ", ""+rb[position].getId());
                holder.checked = dataList.get(position).getMATNR();
            }
        });
        rb[position].setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("checked : ", ""+rb[position].getId());
                holder.rg.clearCheck();
            }
        });

        holder.rg.addView(rb[position]);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
