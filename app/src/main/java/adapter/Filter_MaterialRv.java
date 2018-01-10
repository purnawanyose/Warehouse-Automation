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
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.Material;
import model.MovTypeSelection;

/**
 * Created by yosep on 1/10/2018.
 */

public class Filter_MaterialRv extends RecyclerView.Adapter<Filter_MaterialRv.MyViewHolder> {

    private Context context;
    public ArrayList<Material> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textmatno;
        TextView textmatdesc;
        RadioButton checkmat;
        LinearLayout linear;
        String checked;

        private MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            textmatno = (TextView) view.findViewById(R.id.materialno);
            textmatdesc = (TextView) view.findViewById(R.id.matdesc);
            checkmat = (RadioButton) view.findViewById(R.id.checkmat);
            linear = (LinearLayout) view.findViewById(R.id.Linear_rv_filter);
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
        holder.textmatdesc.setText(dataList.get(position).getMAKTG());
        holder.checkmat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.checked = dataList.get(position).getMATNR();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
