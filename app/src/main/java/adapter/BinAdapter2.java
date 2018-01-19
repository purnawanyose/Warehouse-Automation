package adapter;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.LayoutKedua;
import com.semenindonesia.sisi.warehouseautomation.LayoutPertama;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

/**
 * Created by muham on 1/15/2018.
 */

public class BinAdapter2 extends RecyclerView.Adapter<BinAdapter2.ViewHolder> {
    private static final String TAG = "BinAdapter";
    ArrayList<String> bin;
    String strg;
    private Context context;
    String a,aa;
    String bbb,bb,bbbb;
    TextView c;
    String sbinn,sbinFull;
    public BinAdapter2(ArrayList<String> bin) {
        this.bin = bin;
    }

    @Override
    public BinAdapter2.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mappingutamarv, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BinAdapter2.ViewHolder viewHolder, int i) {
        applyClickEvents(viewHolder,i);
        clickEvents(viewHolder, i);
    }

    @Override
    public int getItemCount() {
        return bin.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "BinAdapter2";
        public TextView mNamaLorong, strgBin, AUPC, textView733;

        public ViewHolder(View itemView) {
            super(itemView);
            mNamaLorong = itemView.findViewById(R.id.nama_lorong);
            strgBin = itemView.findViewById(R.id.sbinText);
            AUPC = itemView.findViewById(R.id.AUPC);
            textView733 = (TextView) itemView.findViewById(R.id.textView733);
            context = itemView.getContext();
        }
    }
    private void applyClickEvents(final BinAdapter2.ViewHolder holder, final int position) {
        sbinn = LayoutKedua.sbinnn;
        sbinFull = LayoutKedua.sbinFull;
        bb = String.valueOf(sbinFull.charAt(2));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "BinAdapter";
            @Override
            public void onClick(View view) {
                final String data = bin.get(position);
                c = holder.mNamaLorong;
                if(bb.equals(bin.get(position))){
                    Log.e(TAG, "SUKSES"+bb);

                }else{
                    Log.e(TAG, "onClick: "+data +c);
                }
            }
        });
    }
    private void clickEvents(final BinAdapter2.ViewHolder holder, final int position){
        c = holder.mNamaLorong;
        holder.mNamaLorong.setText(bin.get(position));
        a = (String) holder.mNamaLorong.getText();
        sbinn = LayoutKedua.sbinnn;
        String aa = sbinn.substring(0,2);
        sbinFull = LayoutKedua.sbinFull;
        bb = String.valueOf(sbinFull.charAt(4));
        aa = sbinFull.substring(3);
        String cc = String.valueOf(sbinFull.charAt(3));
        Log.e(TAG, "clickEvents: AZis"+cc );
        Log.e(TAG, "sbibsibidsbsa: "+bb );
        String ee = sbinFull.substring(3);
        Log.e(TAG, "lllllllllllll"+ee);

        if (bb.equals(bin.get(position)) && cc.equals("0")){
            Log.e(TAG, "clickEvents: assssssssssss"+bb);
            manageBlinkEffect();
        }else if (aa.equals(bin.get(position)) && cc.equals("1")){
                manageBlinkEffect();

        }
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
