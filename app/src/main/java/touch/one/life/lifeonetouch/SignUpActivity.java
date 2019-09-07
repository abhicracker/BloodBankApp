package touch.one.life.lifeonetouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.Utils.APIService;
import touch.one.life.lifeonetouch.Utils.ApiUtils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class SignUpActivity extends AppCompatActivity {


    TextInputEditText name,email,password,address,phone,age,weight;
    AppCompatRadioButton gender;
    MaterialSpinner spinner,spinner_address_signup;
    String Strname,Stremail,Strpassword,Straddress,Strphone,Strage,Strweight,Strbg,Strgender;
    Button sign_in_button;
    private RadioGroup rg_gender;
    private RadioButton radio_male;
    private APIService mAPIService;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAPIService = ApiUtils.getAPIService();
        sharedpreferences = getApplicationContext().getSharedPreferences("blood", Context.MODE_PRIVATE);
        editor= sharedpreferences.edit();
        rg_gender = findViewById(R.id.gender);
        radio_male = findViewById(R.id.radio_male);
        name = findViewById(R.id.tv_name_signup);
        email = findViewById(R.id.tv_email_signup);
        password = findViewById(R.id.tv_password_signup);
        phone = findViewById(R.id.tv_phone_signup);
        age = findViewById(R.id.tv_age_signup);
        weight = findViewById(R.id.tv_weight_signup);
        sign_in_button = findViewById(R.id.sign_in_button);








        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems("Select Blood Group", "A +", "A -", "B +", "B -", "AB +","AB -","O -","O +");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Strbg=item;
            }
        });


        spinner_address_signup = (MaterialSpinner) findViewById(R.id.spinner_address_signup);
        spinner_address_signup.setItems("Select Area","Sai Nagar","Badnera","Rajapeth","Dastur Nagar","Shegaon Naka");
        spinner_address_signup.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Straddress=item;
            }
        });



        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = rg_gender.getCheckedRadioButtonId();
                radio_male = findViewById(selectedId);


                Strname =name.getText().toString();
                Stremail  = email.getText().toString();
                Strpassword = password.getText().toString();
                Strphone = phone.getText().toString();
                Strage = age.getText().toString();
                Strweight = weight.getText().toString();

             if (Strname.isEmpty()||Strbg.isEmpty()||Stremail.isEmpty()||Strpassword.isEmpty()||Strphone.isEmpty()||Straddress.isEmpty()||Strweight.isEmpty()||Strage.isEmpty())
                {
                    Toast.makeText(SignUpActivity.this, "Please Fill All Fields Correcty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Strgender = radio_male.getText().toString();
                    regDonor(Strname,Strbg,Stremail,Strpassword,Strgender,Straddress,Strphone,Strage,Strweight);
                }

            }
        });
    }


    public void regDonor(String name ,String bg,String email,String password ,String gender,String address ,String phone,String age,String Weight) {
        mAPIService.regDonor(name,bg,email,password,gender,address,phone,age,Weight).enqueue(new Callback<Donor>() {

            @Override
            public void onResponse(Call<Donor> call, Response<Donor> response) {
                if(response.isSuccessful()) {
                    editor.putString("loginDid", response.body().getId());
                    editor.putString("loginDonor", "1");
                    editor.commit();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Donor> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Got Response Fail" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
