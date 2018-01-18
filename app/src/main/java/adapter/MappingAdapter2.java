package adapter;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.BinActivity;
import com.semenindonesia.sisi.warehouseautomation.MappingAUPB;
import com.semenindonesia.sisi.warehouseautomation.MappingAUPC;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

/**
 * Created by muham on 1/15/2018.
 */

public class MappingAdapter2 extends RecyclerView.Adapter<MappingAdapter2.ViewHolder> {
    private static final String TAG = "MappingAdapter";
    ArrayList<String> lorong;
    String strg;
    private Context context;
    String a;
    String bb;
    TextView c;
    String sbinn;
    public MappingAdapter2(ArrayList<String> lorong) {
        this.lorong = lorong;
    }

    @Override
    public MappingAdapter2.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappingutamarv2, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MappingAdapter2.ViewHolder viewHolder, int i) {
        applyClickEvents(viewHolder,i);
        clickEvents(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return lorong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "MappingAdapter";
        public TextView mNamaLorong, strgBin, AUPC;

        public ViewHolder(View itemView) {
            super(itemView);
            mNamaLorong = itemView.findViewById(R.id.nama_lorong);
            strgBin = itemView.findViewById(R.id.sbinText);
            AUPC = itemView.findViewById(R.id.AUPC);
            context = itemView.getContext();
        }
    }

    private void clickEvents(final ViewHolder holder, final int position){
        c = holder.mNamaLorong;
        holder.mNamaLorong.setText(lorong.get(position));
        a = (String) holder.mNamaLorong.getText();
        sbinn = MappingAUPB.sbin;
        bb = sbinn.substring(0,2);
        Log.e(TAG, "sbibsibidsbsa: "+bb );
        if (bb.equals(lorong.get(position))){
            Log.e(TAG, "clickEvents: assssssssssss"+bb);
            manageBlinkEffect();
        }else{

        }
    }

    private void applyClickEvents(final MappingAdapter2.ViewHolder holder, final int position) {
        sbinn = MappingAUPB.sbin;
        bb = sbinn.substring(0,2);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "MappingAdapter";
            @Override
            public void onClick(View view) {
                final String data = lorong.get(position);
                c = holder.mNamaLorong;
                if(bb.equals(lorong.get(position))){
                    applyClickEventss(holder, position);
                    Log.e(TAG, "SUKSES"+bb);

                }else{
                    Log.e(TAG, "onClick: "+data +c);
                }
            }
        });
    }
    private void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(c, "backgroundColor", Color.WHITE, Color.GREEN,
                Color.WHITE);
        anim.setDuration(800);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }
    private void applyClickEventss(final MappingAdapter2.ViewHolder holder, final int position) {
        holder.mNamaLorong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sbinn = MappingAUPB.sbin;
                bb = sbinn.substring(0,2);
                Intent intent = new Intent(context, BinActivity.class);
                intent.putExtra("namaLorong", bb);
                context = v.getContext();
                v.getContext().startActivity(intent);
            }
        });
    }


}
