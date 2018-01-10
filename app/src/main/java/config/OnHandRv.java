package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.Interim;
import model.OnHand;

public class OnHandRv extends RecyclerView.Adapter<OnHandRv.OnHandViewHolder> {

    TextView textView56, textView27;
    private Context context;
    Button button2;

    public ArrayList<OnHand> dataList;

    public OnHandRv(ArrayList<OnHand> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OnHandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.onhand_location_rv, parent, false);
        return new OnHandViewHolder(view);

    }

    @Override
    public void onBindViewHolder(OnHandViewHolder holder, int position) {
        holder.textView64.setText(dataList.get(position).getMATDESC() +"\n"+"\n"+ dataList.get(position).getMATNO());
//        holder.textView65.setText(dataList.get(position).getVALTYPE()+"/"+dataList.get(position).getSPCSTK());
//        holder.textView90.setText(dataList.get(position).getQUANTITY());
//        holder.textView91.setText(dataList.get(position).getUOM());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class OnHandViewHolder  extends RecyclerView.ViewHolder{
        TextView textView64,textView65, textView90, textView91, textView92;
        Button bOnHand;
        LinearLayout linearClear;

        OnHandViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView64 = (TextView) itemView.findViewById(R.id.textView51);
            textView65 = (TextView) itemView.findViewById(R.id.textView52);
            textView90 = (TextView) itemView.findViewById(R.id.textView53);
            textView91 = (TextView) itemView.findViewById(R.id.textView54);
            textView92 = (TextView) itemView.findViewById(R.id.textView55);
            bOnHand = (Button) itemView.findViewById(R.id.button2);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);
        }
    }
    /*private void applyClickEvents(OnHandRv.OnHandViewHolder holder, final int position) {
        holder.bOnHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final OnHand data = dataList.get(position);
                //======== Menuju ke form quant ========
                Intent intent = new Intent(context, QuantDetailActivity.class );
                                intent.putExtra("LGNUM", data.getWHSNO());
                                intent.putExtra("LGTYP", data.getSTYPE());
                                intent.putExtra("LGPLA", data.getSBIN());
                context = view.getContext();
                view.getContext().startActivity(intent);
            }
        });
    }
    private void clearEvent(OnHandRv.OnHandViewHolder holder, final int position) {
        holder.linearClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final OnHand data = dataList.get(position);
                //======== Menuju ke form quant ========
                Intent intent = new Intent(context, QuantDetailActivity.class );
                intent.putExtra("LGNUM", data.getWHSNO());
                intent.putExtra("LGTYP", data.getSTYPE());
                intent.putExtra("LGPLA", data.getSBIN());
                context = view.getContext();
                view.getContext().startActivity(intent);
            }
        });
    }*/
}
