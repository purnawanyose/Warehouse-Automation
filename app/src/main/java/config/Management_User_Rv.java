package config;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;
import model.User;

import java.util.List;

/**
 * Created by muham on 1/31/2018.
 */

public class Management_User_Rv extends RecyclerView.Adapter<Management_User_Rv.MyHolder> {

    List<User> list;
    Context context;

    public Management_User_Rv (List<User>list,Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public Management_User_Rv.MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_management_rv, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(Management_User_Rv.MyHolder myHolder, int i) {
        User mylist = list.get(i);
        myHolder.textView87.setText(mylist.username);
        myHolder.textView88.setText(mylist.password);
        myHolder.textView84.setText(mylist.role);

    }

    @Override
    public int getItemCount() {

        int arr= 0;

        try {
            if (list.size()==0){
                arr = 0;
            }else{
                arr=list.size();
            }
        }catch (Exception e){

        }
        return arr;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView87, textView88, textView86, textView84;
        public MyHolder(View itemView) {
            super(itemView);

            textView87 = (TextView) itemView.findViewById(R.id.textView87);
            textView88 = (TextView) itemView.findViewById(R.id.textView88);
            textView86 = (TextView) itemView.findViewById(R.id.textView86);
            textView84 = (TextView) itemView.findViewById(R.id.textView84);


        }
    }
}

