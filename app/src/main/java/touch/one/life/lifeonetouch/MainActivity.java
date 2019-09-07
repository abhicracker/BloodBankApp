package touch.one.life.lifeonetouch;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import touch.one.life.lifeonetouch.fragments.AllDonorsFragment;
import touch.one.life.lifeonetouch.fragments.BloodBanksFragment;
import touch.one.life.lifeonetouch.fragments.EmergencyFragment;
import touch.one.life.lifeonetouch.fragments.HelplinesFragment;
import touch.one.life.lifeonetouch.fragments.HomeFragment;
import touch.one.life.lifeonetouch.fragments.NeedDonorFragment;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack( "1" ).commit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        sharedpreferences = getApplicationContext().getSharedPreferences("blood", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new NeedDonorFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack( "tag" ).commit();


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

/*    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {

                //Toast.makeText(this, ""+getSupportFragmentManager().getBackStackEntryCount(), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                                //StudentActivity.super.onBackPressed();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            } else {


                getSupportFragmentManager().popBackStack();

            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        ft = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            ft.replace(R.id.frame,new HomeFragment()).addToBackStack( "tag" ).commit();
        } else if (id == R.id.nav_bb_list) {
            ft.replace(R.id.frame,new BloodBanksFragment()).addToBackStack( "tag" ).commit();
        } else if (id == R.id.nav_need_donor) {
            ft.replace(R.id.frame,new NeedDonorFragment()).addToBackStack( "tag" ).commit();
        } else if (id == R.id.nav_donor_list) {
            ft.replace(R.id.frame,new AllDonorsFragment()).addToBackStack( "tag" ).commit();
        } else if (id == R.id.nav_emergency) {
            ft.replace(R.id.frame,new EmergencyFragment()).addToBackStack( "tag" ).commit();
        } else if (id == R.id.nav_helplines) {
            ft.replace(R.id.frame,new HelplinesFragment()).addToBackStack( "tag" ).commit();
        }else if (id == R.id.nav_logout) {
            editor.putString("loginDonor", "0");
            editor.commit();
            Intent main = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(main);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
