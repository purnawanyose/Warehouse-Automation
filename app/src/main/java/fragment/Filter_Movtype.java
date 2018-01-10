package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;
import java.util.List;


import adapter.Filter_MovtypeRv;
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
public class Filter_Movtype extends Fragment {

    private ArrayList<Content> contentlist = new ArrayList<Content>();
    Spinner spinner;
    RecyclerView recyclerView;
    Button search;
    EditText tv_movtype;
    String SelectedItem, movtype = "*";
    private Filter_MovtypeRv adapter;
    private ArrayList<MovTypeSelection> movlist;

    public Filter_Movtype() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_movtype, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinnerSS);
        recyclerView = (RecyclerView) view.findViewById(R.id.filter_recyleview);
        search = (Button) view.findViewById(R.id.btn_search_filter);
        tv_movtype = (EditText) view.findViewById(R.id.mvtype);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);*/
        getdata();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedItem = contentlist.get(position).getCode();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movtype = tv_movtype.getText().toString();
                searchdata(movtype,SelectedItem);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //fillspinner();
    }

    private void fillspinner(){
        // you need to have a list of data that you want the spinner to display
        List<String> spinnerArray =  new ArrayList<String>();

        for (int i = 0; i < contentlist.size(); i++) {
            spinnerArray.add(contentlist.get(i).getName());
            Log.e("spinner test: ", contentlist.get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }

    public void getdata(){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MasterSpecialStockResponse> call = apiService.getMasterSpecialStock();
        call.enqueue(new Callback<MasterSpecialStockResponse>() {
            @Override
            public void onResponse(Call<MasterSpecialStockResponse>call, retrofit2.Response<MasterSpecialStockResponse> response) {

                Log.e("spinner test: ", response.body().getStatus());
                List<Content> contentmain = response.body().getContent();
                for (Content data : contentmain){
                    Content cat = new Content(data.getCode(),data.getName());
                    contentlist.add(cat);
                }
                fillspinner();
            }

            @Override
            public void onFailure(Call<MasterSpecialStockResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("Error Retrofit: ", t.toString());
                return;
            }
        });
    }

    public void searchdata(String bwart, String sobkz){
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MovTypeSelectionResponse> call = apiService.getMovTypeSelection(bwart,sobkz);
        call.enqueue(new Callback<MovTypeSelectionResponse>() {
            @Override
            public void onResponse(Call<MovTypeSelectionResponse>call, retrofit2.Response<MovTypeSelectionResponse> response) {
                movlist = new ArrayList<MovTypeSelection>();
                Log.e("spinner test: ", response.body().getStatus().toString());
                List<MovTypeSelection> contentmain = response.body().getContent();
                for (MovTypeSelection data : contentmain){
                    MovTypeSelection mov = new MovTypeSelection(data.getSPRAS(),data.getBWART(),data.getSOBKZ(),
                            data.getKZBEW(),data.getKZZUG(),data.getKZVBR(),data.getBTEXT());
                    movlist.add(mov);
                }
                adapter = new Filter_MovtypeRv(movlist);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                if (movlist.size() < 1){
                    Toast.makeText(getActivity().getApplicationContext(),"Data Not Found!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovTypeSelectionResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("Error Retrofit: ", t.toString());
                return;
            }
        });
    }

}
