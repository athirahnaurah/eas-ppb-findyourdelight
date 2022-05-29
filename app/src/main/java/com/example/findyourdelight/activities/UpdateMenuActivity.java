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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateMenuActivity extends AppCompatActivity {
    private EditText menuName, menuDesc;
    private Button btnSave;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        menuName = findViewById(R.id.edtMenuName);
        menuDesc = findViewById(R.id.edtDescription);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BodyCreateMenu bodyUpdateMenu = new BodyCreateMenu();
                bodyUpdateMenu.setMenuname(menuName.getText().toString());
                bodyUpdateMenu.setDescription(menuDesc.getText().toString());

                RestClient.getService().updateMenu("5f5eccf4e923d0aca3e7d441",bodyUpdateMenu).enqueue(new Callback<CreateMenuResponse>() {
                    @Override
                    public void onResponse(Call<CreateMenuResponse> call, Response<CreateMenuResponse> response) {
                        if (!response.isSuccessful()){
                            Toast.makeText(UpdateMenuActivity.this, "Response Code : " + response.code() + "Menu data was not successfully updated", Toast.LENGTH_SHORT);
                        }
                        Toast.makeText(UpdateMenuActivity.this, "Menu data successfully updated", Toast.LENGTH_SHORT);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<CreateMenuResponse> call, Throwable t) {
                        Toast.makeText(UpdateMenuActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
