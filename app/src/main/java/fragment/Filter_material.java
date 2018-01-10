package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.semenindonesia.sisi.warehouseautomation.R;

import java.util.ArrayList;
import java.util.List;

import adapter.Filter_MaterialRv;
import adapter.Filter_MovtypeRv;
import model.Content;
import model.Material;
import model.MovTypeSelection;
import response.MaterialResponse;
import response.MovTypeSelectionResponse;
import retrofit2.Call;
import retrofit2.Callback;
import service.ApiClient;
import service.ApiInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class Filter_material extends Fragment {

    EditText matno;
    EditText matdesc;
    EditText maxrow;
    Button search;
    RecyclerView recyclerView_mat;
    private Filter_MaterialRv adapter ;
    private ArrayList<Material> matlist =  new ArrayList<Material>();

    public Filter_material() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_material, container, false);

        matno = (EditText) view.findViewById(R.id.materialno);
        matdesc = (EditText) view.findViewById(R.id.matdesc);
        maxrow = (EditText) view.findViewById(R.id.maxrow);
        search = (Button) view.findViewById(R.id.btn_search_mat);
        recyclerView_mat = (RecyclerView) view.findViewById(R.id.filter_recyleview_mat);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(maxrow.getText().toString(),matno.getText().toString(),matdesc.getText().toString());
            }
        });

        return view;
    }

    public void search(String row, String matnr, String maktg){

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MaterialResponse> call = apiService.getMaterial(row,matnr,maktg);
        call.enqueue(new Callback<MaterialResponse>() {
            @Override
            public void onResponse(Call<MaterialResponse>call, retrofit2.Response<MaterialResponse> response) {

                Log.e("spinner test: ", response.body().getStatus().toString());
                List<Material> contentmain = response.body().getContent();
                for (Material data : contentmain){
                    Material mat = new Material(data.getMATNR(),data.getSPRAS(),data.getMAKTX(),data.getMATNR());
                    matlist.add(mat);
                }
                adapter = new Filter_MaterialRv(matlist);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView_mat.setLayoutManager(mLayoutManager);
                recyclerView_mat.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                if (matlist.size() < 1){
                    Toast.makeText(getActivity().getApplicationContext(),"Data Not Found!",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MaterialResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("Error Retrofit: ", t.toString());
                return;
            }
        });

    }

}
