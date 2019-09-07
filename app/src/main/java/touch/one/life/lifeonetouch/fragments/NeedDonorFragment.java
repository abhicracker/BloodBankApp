package touch.one.life.lifeonetouch.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import androidx.fragment.app.FragmentManager;
import touch.one.life.lifeonetouch.MainActivity;
import touch.one.life.lifeonetouch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NeedDonorFragment extends androidx.fragment.app.Fragment {


    public NeedDonorFragment() {
        // Required empty public constructor
    }

    String bg,area;

    MainActivity mainActivity = (MainActivity) getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_need_donor, container, false);
        MaterialSpinner spinner = (MaterialSpinner) v.findViewById(R.id.need_donor_bg_spinner);
        spinner.setItems("Select Blood Group", "A +", "A -", "B +", "B -", "AB +","AB -","O -","O +");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item1) {

                //Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                 bg =item1;
            }
        });

        MaterialSpinner spinner_area = (MaterialSpinner) v.findViewById(R.id.need_donor_area_spinner);
        spinner_area.setItems("Select Area","Sai Nagar","Badnera","Rajapeth","Dastur Nagar","Shegaon Naka");
        spinner_area.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item2) {

                //Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                area=item2;
            }
        });


        v.findViewById(R.id.btn_search_donor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("bg",bg);
                bundle.putString("address",area);

                DonorsFragment nextFragment = new DonorsFragment();
                nextFragment.setArguments(bundle);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, nextFragment).addToBackStack("tag").commit();

            }
        });

        return v;
    }


}
