package config;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.ItemDetailOpname;
import model.Opname;

public class DetailStockOpnameRv extends RecyclerView.Adapter<DetailStockOpnameRv.DetailOpnameViewHolder> {


    private Context context;

    public ArrayList<ItemDetailOpname> dataList;

    public DetailStockOpnameRv(ArrayList<ItemDetailOpname> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DetailOpnameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.detail_opname_rv, parent, false);
        return new DetailOpnameViewHolder(view);


    }
    @Override
    public void onBindViewHolder(DetailOpnameViewHolder holder, int position) {

        holder.textView108.setText(dataList.get(position).getITEM());
        /*holder.textView104.setText(dataList.get(position).getPLANT());
        holder.textView105.setText(dataList.get(position).getSTGELOC());
        holder.textView106.setText(dataList.get(position).getFISCALYEAR()+"-"+dataList.get(position).getFISPERIOD());
        holder.textView107.setText(dataList.get(position).getSPECSTOCK());
        if (dataList.get(position).getCOUNTSTATUS().equalsIgnoreCase("")){
            holder.cbOpname.setChecked(true);
        }else{
            holder.cbOpname.setChecked(false);
        }*/


//        applyClickEvents(holder,position);
 }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DetailOpnameViewHolder  extends RecyclerView.ViewHolder{
        TextView textView108,textView104, textView105, textView106, textView107;
        ImageView imgDetail;
        LinearLayout linearClear;
        CheckBox cbOpname;

        DetailOpnameViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView108 = (TextView) itemView.findViewById(R.id.textView108);
            textView104 = (TextView) itemView.findViewById(R.id.textView104);
            textView105 = (TextView) itemView.findViewById(R.id.textView105);
            textView106 = (TextView) itemView.findViewById(R.id.textView106);
            textView107 = (TextView) itemView.findViewById(R.id.textView107);
            imgDetail = (ImageView) itemView.findViewById(R.id.imgDetail);
            cbOpname = (CheckBox) itemView.findViewById(R.id.cbOpname);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);


        }
    }
}