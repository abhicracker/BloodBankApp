package touch.one.life.lifeonetouch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.Utils.APIService;
import touch.one.life.lifeonetouch.Utils.ApiUtils;
import touch.one.life.lifeonetouch.fragments.NeedDonorFragment;

public class LoginActivity extends AppCompatActivity {

    private View parent_view;
    TextInputEditText login_email,login_password;
    private APIService mAPIService;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        parent_view = findViewById(android.R.id.content);
        sharedpreferences = getApplicationContext().getSharedPreferences("blood", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

                login_email = findViewById(R.id.login_email);
                login_password = findViewById(R.id.login_password);
                mAPIService = ApiUtils.getAPIService();
                checkSignIn();
     /*   ((View) findViewById(R.id.forgot_password)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi+ew) {

            }
        });*/
        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
                finish();
            }
        });

        ((View) findViewById(R.id.btn_login)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = login_email.getText().toString();
                String pass = login_password.getText().toString();



                LoginDonor(email,pass);


            }
        });


    }


    public void LoginDonor(String email, String password) {
        mAPIService.loginDonor(email,password).enqueue(new Callback<Donor>() {
            @Override
            public void onResponse(Call<Donor> call, Response<Donor> response) {
                if(response.isSuccessful()) {
                    if (response.body().getLoginStatus().equals("1")) {
                        String custId =response.body().getDid();
                        editor.putString("loginDid", response.body().getDid());
                        editor.putString("loginDonor", "1");
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Successfully logged in", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<Donor> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Got Response Fail" + call.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkSignIn() {
        SharedPreferences myPrefs = this.getSharedPreferences("blood", MODE_PRIVATE);
        String loginDonor = myPrefs.getString("loginDonor",null);
        if (loginDonor != null && loginDonor.equals("1"))
        {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}
