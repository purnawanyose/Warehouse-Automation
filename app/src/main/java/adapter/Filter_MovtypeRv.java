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
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import butterknife.BindView;
import model.MovTypeSelection;

/**
 * Created by yosep on 1/8/2018.
 */

public class Filter_MovtypeRv extends RecyclerView.Adapter<Filter_MovtypeRv.MyViewHolder> {


    private Context context;

    public ArrayList<MovTypeSelection> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textmvtype;
        TextView textSS;
        TextView textRegdate;
        RadioButton checkfilter;
        LinearLayout linear;
        String checked;

        private MyViewHolder(View view) {
            super(view);
            context = view.getContext();
            textmvtype = (TextView) view.findViewById(R.id.textmvtype);
            textSS = (TextView) view.findViewById(R.id.textSS);
            textRegdate = (TextView) view.findViewById(R.id.textRegdate);
            checkfilter = (RadioButton) view.findViewById(R.id.checkfilter);
            linear = (LinearLayout) view.findViewById(R.id.Linear_rv_filter);
        }
    }

    public Filter_MovtypeRv(ArrayList<MovTypeSelection> dataList){
        this.dataList = dataList;
    }

    @Override
    public Filter_MovtypeRv.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filter_movtyperv, parent, false);

        return new Filter_MovtypeRv.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Filter_MovtypeRv.MyViewHolder holder, final int position) {
        Log.e("data check", " "+ dataList.size());
        holder.textmvtype.setText(dataList.get(position).getBWART());
        holder.textSS.setText(dataList.get(position).getSPRAS());
        holder.textRegdate.setText(dataList.get(position).getBTEXT());

        holder.checkfilter.setId(position);


        holder.checkfilter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.checked = dataList.get(position).getBWART();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
