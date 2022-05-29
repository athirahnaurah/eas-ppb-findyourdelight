package com.example.findyourdelight.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.findyourdelight.R;
import com.example.findyourdelight.adapter.MenuAdapter;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    String vName, vDesc, vId, vImg1, vImg2, vImg3;
    HashMap<String, String> Hash_file_maps;
    SliderLayout sliderLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDesc = findViewById(R.id.tvDescription);
        sliderLayout = findViewById(R.id.daimajia_slider_image);
        ImageView btnEdit = findViewById(R.id.btnEdit);

        Intent item = getIntent();
        vImg1 = item.getStringExtra("image1");
        vImg2 = item.getStringExtra("image2");
        vImg3 = item.getStringExtra("image3");
        vName = item.getStringExtra("name");
        vDesc = item.getStringExtra("desc");
        vId = item.getStringExtra("id");

        tvName.setText(vName);
        tvDesc.setText(vDesc);
        Hash_file_maps = new HashMap<>();
        Hash_file_maps.put("Image 1",vImg1);
        Hash_file_maps.put("Image 2",vImg2);
        Hash_file_maps.put("Image 3",vImg3);

        for (String name : Hash_file_maps.keySet()) {

            TextSliderView textSliderView = new TextSliderView(DetailActivity.this);
            textSliderView
                    .description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            textSliderView.bundle(new Bundle());
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UpdateMenuActivity.class);
                intent.putExtra("name",vName);
                intent.putExtra("desc",vDesc);
                intent.putExtra("id",vId);
                startActivity(intent);
                DetailActivity.this.finish();
            }
        });
    }
}

