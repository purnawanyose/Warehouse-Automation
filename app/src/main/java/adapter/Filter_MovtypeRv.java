package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
        @BindView(R.id.textmvtype)
        TextView textmvtype;
        @BindView(R.id.textSS)
        TextView textSS;
        @BindView(R.id.textRegdate)
        TextView textRegdate;
        @BindView(R.id.checkfilter)
        CheckBox checkfilter;

        private MyViewHolder(View view) {
            super(view);
            context = view.getContext();

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
    public void onBindViewHolder(Filter_MovtypeRv.MyViewHolder holder, int position) {
        holder.textmvtype.setText(dataList.get(position).getBWART());
        holder.textSS.setText(dataList.get(position).getSPRAS());
        holder.textRegdate.setText(dataList.get(position).getBTEXT());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
