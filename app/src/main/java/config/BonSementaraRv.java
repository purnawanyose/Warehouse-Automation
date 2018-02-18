package config;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.BonSementara;
import model.Interim;
import model.MovTypeSelection;

import static android.R.id.list;
import static com.semenindonesia.sisi.warehouseautomation.R.id.combo1;
import static com.semenindonesia.sisi.warehouseautomation.R.id.checkBox;
import static com.semenindonesia.sisi.warehouseautomation.R.id.sad;

/**
 * Created by muham on 1/4/2018.
 */

public class BonSementaraRv extends RecyclerView.Adapter<BonSementaraRv.BonViewHolder>{

    public ArrayList<BonSementara> dataList;
    CheckBox cb2, cb1, cb3;
    private int selectedPosition = -1;
    public static String selectedRSPOS;
    public static String selectedRSNUM;



    public BonSementaraRv(ArrayList<BonSementara> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BonSementaraRv.BonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.bon_sementara_rv, parent, false);

        return new BonSementaraRv.BonViewHolder(view);

    }
    @Override
    public void onBindViewHolder(final BonSementaraRv.BonViewHolder holder, final int position) {


        holder.textView43.setText(dataList.get(position).getRSNUM()+"\t\t"+dataList.get(position).getRSPOS());
        holder.textView44.setText(dataList.get(position).getMAKTX()+"\n"+dataList.get(position).getMATNR());
        holder.textView45.setText(dataList.get(position).getWERKS()+"\n"+dataList.get(position).getLGORT());
        holder.textView46.setText(dataList.get(position).getBDMNG());
        holder.textView47.setText(dataList.get(position).getMEINS());



        holder.cb1.setChecked(position == selectedPosition);
        holder.cb1.setId(position);
        holder.cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.rsnum = dataList.get(position).getRSNUM();
                holder.rspos = dataList.get(position).getRSPOS();
                selectedRSNUM = holder.rsnum;
                selectedRSPOS = holder.rspos;
                Log.e("checked1"," "+selectedRSNUM);
                Log.e("checked2"," "+selectedRSPOS);
                itemCheckChanged(v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class BonViewHolder  extends RecyclerView.ViewHolder {
        TextView textView43, textView44, textView45, textView46, textView47;
        CheckBox cb1, cb2, cb3;
        Button button11;
        String rsnum;
        String rspos;

        BonViewHolder(final View itemView) {
            super(itemView);
            textView43 = itemView.findViewById(R.id.textView43);
            textView44 = itemView.findViewById(R.id.textView44);
            textView45 = itemView.findViewById(R.id.textView45);
            textView46 = itemView.findViewById(R.id.textView46);
            textView47 = itemView.findViewById(R.id.textView47);
            cb1 = itemView.findViewById(R.id.combo1);
            button11 = itemView.findViewById(R.id.button11);

        }
    }

    private void itemCheckChanged(View v) {
        selectedPosition = (Integer) v.getId();
        notifyDataSetChanged();
    }
}
