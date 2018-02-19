package config;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.ItemDetailOpname;

public class ScannerDetailStockOpnameRv extends RecyclerView.Adapter<ScannerDetailStockOpnameRv.DetailOpnameViewHolder> {


    private Context context;
    private int selectedPosition = -1;
    public ArrayList<ItemDetailOpname> dataList;

    public static String ITEM;
    public static String MATERIAL;
    public static String ENTRY_QNT;
    public static String ENTRY_UOM;

    public ScannerDetailStockOpnameRv(ArrayList<ItemDetailOpname> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DetailOpnameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.scanner_detail_opname_rv, parent, false);
        return new DetailOpnameViewHolder(view);


    }
    @Override
    public void onBindViewHolder(DetailOpnameViewHolder holder, int position) {

        holder.etCount.setEnabled(false);

        holder.textView108.setText(dataList.get(position).getITEM());
        holder.textView109.setText(dataList.get(position).getMATNRDESCRIPTION()+"\n"+dataList.get(position).getMATERIAL()
                                    +"\n"+dataList.get(position).getSPECSTOCK()+" - "+dataList.get(position).getVENDOR());
        holder.textView110.setText(dataList.get(position).getBOOKQTY());
//        holder.textView111.setText(dataList.get(position).getQUANTITY());
        holder.textView112.setText(dataList.get(position).getDIFFVALUE());
        holder.textView113.setText(dataList.get(position).getBASEUOM());


        holder.checkBox4.setChecked(position == selectedPosition);
        holder.checkBox4.setId(position);
        holder.checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* holder.rsnum = dataList.get(position).getRSNUM();
                holder.rspos = dataList.get(position).getRSPOS();
                selectedRSNUM = holder.rsnum;
                selectedRSPOS = holder.rspos;
                Log.e("checked1"," "+selectedRSNUM);
                Log.e("checked2"," "+selectedRSPOS);*/
                itemCheckChanged(v);
            }
        });

        if (holder.checkBox4.isChecked()){
            holder.etCount.setEnabled(true);
            ITEM = dataList.get(position).getITEM();
            MATERIAL = dataList.get(position).getMATERIAL();
            ENTRY_UOM = dataList.get(position).getENTRYUOM();
            ENTRY_QNT = dataList.get(position).getENTRYQNT();
            Log.e("TESTING ITM MATERIAL", "onBindViewHolder: "+dataList.get(position).getMATNRDESCRIPTION());
        }else{

        }


 }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DetailOpnameViewHolder  extends RecyclerView.ViewHolder{
        TextView textView108,textView109, textView110, textView111, textView112,textView113;
        ImageView imgDetail;
        LinearLayout linearClear;
        CheckBox checkBox4;
        EditText etCount;

        DetailOpnameViewHolder(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            textView108 = (TextView) itemView.findViewById(R.id.textView108);
            textView109 = (TextView) itemView.findViewById(R.id.textView109);
            textView110 = (TextView) itemView.findViewById(R.id.textView110);
//            textView111 = (TextView) itemView.findViewById(R.id.textView111);
            textView112 = (TextView) itemView.findViewById(R.id.textView112);
            textView113 = (TextView) itemView.findViewById(R.id.textView113);
            imgDetail = (ImageView) itemView.findViewById(R.id.imgDetail);
            checkBox4 = (CheckBox) itemView.findViewById(R.id.checkBox4);
            etCount = (EditText) itemView.findViewById(R.id.etCount);
            linearClear = (LinearLayout) itemView.findViewById(R.id.linearClear);


        }
    }
    private void itemCheckChanged(View v) {
        selectedPosition = (Integer) v.getId();
        notifyDataSetChanged();
    }
}