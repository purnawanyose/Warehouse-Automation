package config;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.R;
import java.util.List;

import de.mrapp.android.dialog.adapter.ArrayAdapter;
import model.Connection;

/**
 * Created by muham on 2/12/2018.
 */

public class ConnectionList extends ArrayAdapter<Connection> {
    private Activity context;
    List<Connection> connections;

    public ConnectionList(Activity context, List<Connection> connections){
        super(context, R.layout.activity_list_item, connections);
        this.context = context;
        this.connections = connections;
    }
}
