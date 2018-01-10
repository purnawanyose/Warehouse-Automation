package fragment;

/**
 * Created by muham on 1/9/2018.
 */

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import de.mrapp.android.dialog.model.Dialog;

/**
 * Create a DatePickerFragment class that extends DialogFragment.
 * Define the onCreateDialog() method to return an instance of DatePickerDialog
 */
public  class DatePickerFragment extends DialogFragment {

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),
                (DatePickerDialog.OnDateSetListener)
                        getActivity(), year, month, day);
    }

}