package com.example.findyourdelight.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findyourdelight.R;
import com.example.findyourdelight.api.RestClient;
import com.example.findyourdelight.models.BodyRegister;
import com.example.findyourdelight.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    private EditText edtEmail, edtUsername, edtPhone, edtPass;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtEmail = findViewById(R.id.edtEmail);
        edtUsername = findViewById(R.id.edtUsernameReg);
        edtPhone = findViewById(R.id.edtPhoneNumber);
        edtPass = findViewById(R.id.edtPasswordReg);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyRegister bodyRegister =  new BodyRegister();
                bodyRegister.setEmail(edtEmail.getText().toString());
                bodyRegister.setUsername(edtUsername.getText().toString());
                bodyRegister.setPhoneNumber(edtPhone.getText().toString());
                bodyRegister.setPassword(edtPass.getText().toString());

                RestClient.getService().postRegister(bodyRegister).enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        String responseCode = "Response Code: " + response.code();
                        if (response.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, responseCode, Toast.LENGTH_SHORT).show();
                            Log.i("Response", response.message());
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();
                        }else{
                            if (TextUtils.isEmpty(edtEmail.getText())){
                                Toast.makeText(RegistrationActivity.this, responseCode, Toast.LENGTH_SHORT).show();
                            }else if (TextUtils.isEmpty(edtPhone.getText())){
                                Toast.makeText(RegistrationActivity.this, responseCode, Toast.LENGTH_SHORT).show();
                            }else if (TextUtils.isEmpty(edtUsername.getText())){
                                Toast.makeText(RegistrationActivity.this, responseCode, Toast.LENGTH_SHORT).show();
                            }else if (TextUtils.isEmpty(edtPass.getText())){
                                Toast.makeText(RegistrationActivity.this, responseCode, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
