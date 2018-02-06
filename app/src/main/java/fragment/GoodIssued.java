package fragment;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adapter.Filter_MovtypeRv;
import de.mrapp.android.dialog.model.Dialog;
import model.Content;
import model.MovTypeSelection;
import response.MasterSpecialStockResponse;
import response.MovTypeSelectionResponse;
import retrofit2.Call;
import retrofit2.Callback;
import service.ApiClient;
import service.ApiInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodIssued extends Fragment{


    EditText docDate, postDate;
    Date dateObject;
    String date1,date2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_issued, container, false);

         docDate = (EditText) view.findViewById(R.id.docDate);

        docDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });

       return view;
    }
    public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
            public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        public void populateSetDate(int year, int month, int day) {
            docDate.setText(month+"/"+day+"/"+year);
        }

    }
}
