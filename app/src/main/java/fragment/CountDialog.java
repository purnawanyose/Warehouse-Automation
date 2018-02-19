package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.leavjenn.smoothdaterangepicker.date.SmoothDateRangePickerFragment;
import com.semenindonesia.sisi.warehouseautomation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountDialog extends Fragment {

    TextView pid, fiscal;
    EditText curdate;
    public static String rangeDate;

    public CountDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_count_dialog, container, false);
        pid = view.findViewById(R.id.pidno);
        fiscal = view.findViewById(R.id.fiscal);
        curdate = view.findViewById(R.id.currentyear);
        curdate.setFocusable(false);
        curdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmoothDateRangePickerFragment smoothDateRangePickerFragment = SmoothDateRangePickerFragment.newInstance(
                        new SmoothDateRangePickerFragment.OnDateRangeSetListener() {
                            @Override
                            public void onDateRangeSet(SmoothDateRangePickerFragment view,
                                                       int yearStart, int monthStart,
                                                       int dayStart, int yearEnd,
                                                       int monthEnd, int dayEnd) {
                                // grab the date range, do what you want
                                curdate.setText(dayStart + "-"
                                        + (monthStart + 1) + "-" + yearStart + " to " + dayEnd + "-"
                                        + (monthEnd + 1) + "-" + yearEnd);

                                String monthStart2 = String.valueOf(monthStart);
                                if (monthStart2.length() == 1) {
                                    monthStart2 = "0" + (monthStart2 + 1);
                                }
                                String monthEnd2 = String.valueOf(monthEnd);
                                if (monthEnd2.length() == 1) {
                                    monthEnd2 = "0" + (monthEnd2 + 1);
                                }
                                String dayStart2 = String.valueOf(dayStart);
                                if (dayStart2.length() == 1) {
                                    dayStart2 = "0" + dayStart2;
                                }
                                String dayEnd2 = String.valueOf(dayEnd);
                                if (dayEnd2.length() == 1) {
                                    dayEnd2 = "0" + dayEnd2;
                                }

                                rangeDate = yearStart + monthStart2 + dayStart2;
                            }
                        });

                smoothDateRangePickerFragment.show(getActivity().getFragmentManager(), "smoothDateRangePicker");
            }
        });

        return view;
    }


}
