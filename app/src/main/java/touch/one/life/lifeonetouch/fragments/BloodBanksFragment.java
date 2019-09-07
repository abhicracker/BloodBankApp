package touch.one.life.lifeonetouch.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import touch.one.life.lifeonetouch.POJO.BloodBanks;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.R;
import touch.one.life.lifeonetouch.Utils.APIService;
import touch.one.life.lifeonetouch.Utils.ApiUtils;
import touch.one.life.lifeonetouch.adaptors.BloodBankAdaptor;
import touch.one.life.lifeonetouch.adaptors.DonorsAdaptor;
import touch.one.life.lifeonetouch.adaptors.EmergencyAdaptor;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodBanksFragment extends androidx.fragment.app.Fragment {


    public BloodBanksFragment() {
        // Required empty public constructor
    }


    public APIService mAPIService;
    private List<BloodBanks> bloodBanksList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BloodBankAdaptor mAdapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_blood_banks, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_bloodbanks);


        context =getContext();
        mAdapter = new BloodBankAdaptor(bloodBanksList,context);
        mAPIService = ApiUtils.getAPIService();
        recyclerView.setHasFixedSize(true);
        // vertical RecyclerView


        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        getBloodBanks();
        return v;
    }


    public void getBloodBanks() {
        mAPIService.getBloodBanks().enqueue(new Callback<BloodBanks>() {
            @Override
            public void onResponse(Call<BloodBanks> call, Response<BloodBanks> response) {
                if(response.isSuccessful()) {
                    if (response.body().getStatus().equals("true")) {
                        for (int i=0;i<response.body().getData().size();i++) {
                            bloodBanksList.add(new BloodBanks(response.body().getData().get(i).getName(),response.body().getData().get(i).getLat(),response.body().getData().get(i).getLon(),response.body().getData().get(i).getContact(),response.body().getData().get(i).getAddress(),""));
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getActivity(), "Please Try Again", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<BloodBanks> call, Throwable t) {

                Toast.makeText(getActivity(), "Got Response Fail" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }


}
