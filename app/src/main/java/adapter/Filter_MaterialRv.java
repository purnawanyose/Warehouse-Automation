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
    private int selectedPosition = -1;
    public static String selected;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textmatno;
        TextView textmatdesc;
        LinearLayout linear;
        public CheckBox check;
        String checked;
        Context context;
        private ArrayList<Material> matlist =  new ArrayList<Material>();

        private MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            textmatno = (TextView) view.findViewById(R.id.text_matno);
            textmatdesc = (TextView) view.findViewById(R.id.textdesc);
            check = (CheckBox) view.findViewById(R.id.check);
            linear = (LinearLayout) view.findViewById(R.id.linear_mat);
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
        //Log.e("data check", " "+ dataList.size());
        holder.textmatno.setText(dataList.get(position).getMATNR());
        holder.textmatdesc.setText(dataList.get(position).getMAKTX());

        holder.check.setChecked(position == selectedPosition);
        holder.check.setId(position);
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.checked = dataList.get(position).getMATNR();
                selected = holder.checked;
                Log.e("checked : ", ""+holder.checked);
                itemCheckChanged(v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    //On selecting any view set the current position to selectedPositon and notify adapter
    private void itemCheckChanged(View v) {
        selectedPosition = (Integer) v.getId();
        notifyDataSetChanged();
    }

    public void deleteSelectedPosition() {
        if (selectedPosition != -1) {
            dataList.remove(selectedPosition);
            selectedPosition = -1;//after removing selectedPosition set it back to -1
            notifyDataSetChanged();
        }
    }

}
