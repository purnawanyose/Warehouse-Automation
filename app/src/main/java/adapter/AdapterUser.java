package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;

import model.UserModel;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {


    private final OnItemClickListener listener;
    private ArrayList<UserModel> user;


    public AdapterUser(ArrayList<UserModel> user, OnItemClickListener listener) {
        this.user = user;
        this.listener = listener;
    }


    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_user_management, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(AdapterUser.ViewHolder holder, int position) {
        holder.click(user.get(position), listener);
        holder.tvId.setText(String.valueOf(user.get(position).getId()));
        holder.username.setText(user.get(position).getUsername());
        holder.password.setText(user.get(position).getPassword());
    }


    @Override
    public int getItemCount() {
        return user.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, username, password;


        public ViewHolder(View itemView) {
            super(itemView);
//            tvId = (TextView) itemView.findViewById(R.id.tvId);
            username = (TextView) itemView.findViewById(R.id.username);
            password = (TextView) itemView.findViewById(R.id.password);
        }


        public void click(final UserModel articleModel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(articleModel);
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onClick(UserModel item);
    }


} 
