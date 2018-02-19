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

public class ScannerDetailStockOpnameRv extends RecyclerView.Adapter<ScannerDetailStockOpnameRv.DetailOpnameViewHolder> {


    private Context context;

    public ArrayList<ItemDetailOpname> dataList;

    public ScannerDetailStockOpnameRv(ArrayList<ItemDetailOpname> dataList) {
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
        holder.textView109.setText(dataList.get(position).getMATNRDESCRIPTION()+"\n"+dataList.get(position).getMATERIAL()
                                    +"\n"+dataList.get(position).getSPECSTOCK()+" - "+dataList.get(position).getVENDOR());
        holder.textView110.setText(dataList.get(position).getBOOKQTY());
        holder.textView111.setText(dataList.get(position).getQUANTITY());
        holder.textView112.setText(dataList.get(position).getDIFFVALUE());
        holder.textView113.setText(dataList.get(position).getBASEUOM());

 }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DetailOpnameViewHolder  extends RecyclerView.ViewHolder{
        TextView textView108,textView109, textView110, textView111, textView112,textView113;
        ImageView imgDetail;
        LinearLayout linearClear;
        CheckBox cbOpname;

        DetailOpnameViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView108 = (TextView) itemView.findViewById(R.id.textView108);
            textView109 = (TextView) itemView.findViewById(R.id.textView109);
            textView110 = (TextView) itemView.findViewById(R.id.textView110);
            textView111 = (TextView) itemView.findViewById(R.id.textView111);
            textView112 = (TextView) itemView.findViewById(R.id.textView112);
            textView113 = (TextView) itemView.findViewById(R.id.textView113);
            imgDetail = (ImageView) itemView.findViewById(R.id.imgDetail);
            cbOpname = (CheckBox) itemView.findViewById(R.id.cbOpname);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);


        }
    }
}