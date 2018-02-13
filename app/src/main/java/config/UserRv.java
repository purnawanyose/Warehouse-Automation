package config;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

/**
 * Created by yosep on 2/13/2018.
 */

public class UserRv extends RecyclerView.Adapter<UserRv.BonViewHolder> {

    public class BonViewHolder  extends RecyclerView.ViewHolder {
        TextView textView43, textView44, textView45, textView46, textView47;
        CheckBox cb1, cb2, cb3;
        Button button11;
        String checked;

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


    @Override
    public UserRv.BonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(UserRv.BonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
