package config;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.QuantDetailActivity;
import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;
import java.util.List;

import de.mrapp.android.util.view.ViewHolder;
import model.Interim;
import model.User;
import model.UserAdmin;
import response.InterimResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ApiClient;
import service.ApiInterface;

public class UserManagementRv extends RecyclerView.Adapter<UserManagementRv.UserViewHolder> {


    private Context context;
    private ArrayList<UserAdmin> dataUser;

    public UserManagementRv(ArrayList<UserAdmin> users, Context ctx) {

        dataUser = users;
        context = ctx;
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView textView87,textView88;
        UserViewHolder(View v){
            super(v);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_management_rv, parent,false);
        UserViewHolder vh = new UserViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {

        final String username = dataUser.get(position).getUsername();
        holder.textView87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
            }
        });
        holder.textView87.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                return true;
            }
        });
        holder.textView87.setText(username);


 }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return dataUser.size();
    }

}