package config;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.semenindonesia.sisi.warehouseautomation.R;

import model.Reservation;
import model.User;
import model.UserAdmin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muham on 1/31/2018.
 */

public class Management_User_Rv extends RecyclerView.Adapter<Management_User_Rv.MyHolder> {

    ArrayList<UserAdmin> list;
    Context context;


    public Management_User_Rv(ArrayList<UserAdmin> list) {
        this.list = list;
    }


    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textView87,textView88;
        UserViewHolder(View v){
            super(v);
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_management_rv, parent,false);
        MyHolder vh = new MyHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(Management_User_Rv.MyHolder myHolder, int i) {
        UserAdmin mylist = list.get(i);
        myHolder.textView87.setText(mylist.getUsername());
//        myHolder.textView88.setText(mylist.password);
        myHolder.textView84.setText(mylist.getRole());

    }

    @Override
    public int getItemCount() {
        return list.size();
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

