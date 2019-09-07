package touch.one.life.lifeonetouch.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.FragmentManager;
import touch.one.life.lifeonetouch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends androidx.fragment.app.Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    FloatingActionButton need_donor_home;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        need_donor_home = v.findViewById(R.id.need_donor_home);
        need_donor_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new NeedDonorFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack( "tag" ).commit();

            }
        });

        v.findViewById(R.id.all_donors_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, new AllDonorsFragment()).addToBackStack( "tag" ).commit();
            }
        });
        v.findViewById(R.id.home_emergency).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, new EmergencyFragment()).addToBackStack( "tag" ).commit();
            }
        });

        v.findViewById(R.id.home_helplines).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, new HelplinesFragment()).addToBackStack( "tag" ).commit();
            }
        });

        v.findViewById(R.id.home_bloodbank).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, new BloodBanksFragment()).addToBackStack( "tag" ).commit();
            }
        });



        return v;
    }

}
