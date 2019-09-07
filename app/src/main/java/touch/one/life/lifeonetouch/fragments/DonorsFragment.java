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
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.R;
import touch.one.life.lifeonetouch.Utils.APIService;
import touch.one.life.lifeonetouch.Utils.ApiUtils;
import touch.one.life.lifeonetouch.adaptors.DonorsAdaptor;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonorsFragment extends androidx.fragment.app.Fragment {


    public DonorsFragment() {
        // Required empty public constructor
    }

    public APIService mAPIService;
    private List<Donor> donorList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DonorsAdaptor mAdapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_donors, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_need_donor);
        context =getContext();
        mAdapter = new DonorsAdaptor(donorList,context);
        mAPIService = ApiUtils.getAPIService();
        recyclerView.setHasFixedSize(true);
        String bg = this.getArguments().getString("bg");//get your parameters
        String address = this.getArguments().getString("address");//get your parameters
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        getDonors(bg,address);
        return v;
    }


    public void getDonors(String bg,String address) {
        mAPIService.getDonor(bg,address).enqueue(new Callback<Donor>() {
            @Override
            public void onResponse(Call<Donor> call, Response<Donor> response) {
                if(response.isSuccessful()) {
                    if (response.body().getLoginStatus().equals("true")) {
                        for (int i=0;i<response.body().getData().size();i++) {
                            donorList.add(new Donor(response.body().getData().get(i).getId(), response.body().getData().get(i).getName(), response.body().getData().get(i).getBg(), "", "", "", "", "", response.body().getData().get(i).getPhone(), response.body().getData().get(i).getAddress(), "", ""));
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getActivity(), "Please Try Again", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Donor> call, Throwable t) {

                Toast.makeText(getActivity(), "Got Response Fail" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
