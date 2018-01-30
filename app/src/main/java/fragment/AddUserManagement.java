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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    public static String usernametxt, passwordtxt, role;


    public AddUserManagement() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_user_management, container, false);

        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
        password = (EditText) rootView.findViewById(R.id.password);
        username = (EditText) rootView.findViewById(R.id.username);

        checkBox.setChecked(true);
        password.setVisibility(View.INVISIBLE);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Admin");
        spinnerArray.add("Operator");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems = (Spinner) rootView.findViewById(R.id.spinner);
        sItems.setAdapter(adapter);
        sItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                role = sItems.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        username.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                usernametxt = username.getText().toString();
                return false;
            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                passwordtxt = password.getText().toString();
                return false;
            }
        });



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
