package fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;
import java.util.List;

import model.Content;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserManagement extends Fragment{
    private ArrayList<Content> contentlist = new ArrayList<Content>();
    RecyclerView recyclerView;
    EditText username;
    CheckBox checkBox;
    EditText password;
    Button save;
    Spinner spinner;


    public AddUserManagement() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_user_management, container, false);
        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
        password = (EditText) rootView.findViewById(R.id.password);

        checkBox.setChecked(true);
        password.setVisibility(View.INVISIBLE);



        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Admin");
        spinnerArray.add("Operator");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) rootView.findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        CheckBox someCheckBox= (CheckBox) rootView.findViewById (R.id.checkBox);
        someCheckBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    password.setVisibility(View.INVISIBLE);
                } else {
                    //CODE TO MAKE THE EDITTEXT DISABLED
                    password.setVisibility(View.VISIBLE);

                }
            }
        });

        return rootView;

    }

}
