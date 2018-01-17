package adapter;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.MappingUtamaActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

/**
 * Created by muham on 1/15/2018.
 */

public class MappingAdapter3 extends RecyclerView.Adapter<MappingAdapter3.ViewHolder> {
    private static final String TAG = "MappingAdapter";
    ArrayList<String> lorong3;
    String strg;

    String a;
    String bb;
    TextView c;
    String sbinn;
    public MappingAdapter3(ArrayList<String> lorong3) {
        this.lorong3 = lorong3;
    }

    @Override
    public MappingAdapter3.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappingutamarv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MappingAdapter3.ViewHolder viewHolder, int i) {
        applyClickEvents(viewHolder,i);
        clickEvents(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return lorong3.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "MappingAdapter";
        public TextView mNamaLorong, strgBin;
        public ViewHolder(View itemView) {
            super(itemView);
            mNamaLorong = itemView.findViewById(R.id.nama_lorong);
            strgBin = itemView.findViewById(R.id.sbinText);
        }
    }

    private void clickEvents(final ViewHolder holder, final int position){
        c = holder.mNamaLorong;
        holder.mNamaLorong.setText(lorong3.get(position));
        a = (String) holder.mNamaLorong.getText();
        sbinn = MappingUtamaActivity.sbin;
        bb = sbinn.substring(0,2);
        Log.e(TAG, "sbibsibidsbsa: "+bb );
        if (bb.equals(lorong3.get(position))){
            Log.e(TAG, "clickEvents: assssssssssss"+bb);
            manageBlinkEffect();

        }else{

        }
    }

        private void applyClickEvents(final ViewHolder holder, final int position) {
            sbinn = MappingUtamaActivity.sbin;
            bb = sbinn.substring(0,2);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                public static final String TAG = "MappingAdapter";
                @Override
                public void onClick(View view) {
                    final String data = lorong3.get(position);
                    c = holder.mNamaLorong;
                   if(bb.equals(lorong3.get(position))){
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

}
