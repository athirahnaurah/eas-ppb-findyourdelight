package com.example.findyourdelight.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findyourdelight.MainActivity;
import com.example.findyourdelight.R;
import com.example.findyourdelight.api.RestClient;
import com.example.findyourdelight.models.BodyCreateMenu;
import com.example.findyourdelight.models.CreateMenuResponse;
import com.google.android.gms.cast.framework.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateMenuActivity extends AppCompatActivity {
    private Button btnCreate;
    private EditText edtMenu, edtDesc;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_menu_activity);

        edtMenu = findViewById(R.id.edtMenuCreate);
        edtDesc = findViewById(R.id.edtDescCreate);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyCreateMenu bodyMenu = new BodyCreateMenu();
                bodyMenu.setMenuname(edtMenu.getText().toString());
                bodyMenu.setDescription(edtDesc.getText().toString());

                RestClient.getService().createMenu("5f5eccf3e923d0aca3e7d41c",bodyMenu).enqueue(new Callback<CreateMenuResponse>() {
                    @Override
                    public void onResponse(Call<CreateMenuResponse> call, Response<CreateMenuResponse> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(CreateMenuActivity.this, "Menu added successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(CreateMenuActivity.this, "Response Code: " + response.code()+ "Menu failed to add", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CreateMenuResponse> call, Throwable t) {
                        Toast.makeText(CreateMenuActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
