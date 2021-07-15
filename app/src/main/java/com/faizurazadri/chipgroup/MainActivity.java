package com.faizurazadri.chipgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    private EditText input_tags;
    private ChipGroup chipGroup;
    private ImageView imgadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_tags = findViewById(R.id.add_Tags);
        chipGroup = findViewById(R.id.chip_group_Add);
        imgadd = findViewById(R.id.img_addtag);

        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chip chip = new Chip(MainActivity.this);
                ChipDrawable drawable = ChipDrawable.createFromAttributes(MainActivity.this, null, 0,R.style.Widget_MaterialComponents_Chip_Entry);
                chip.setChipDrawable(drawable);

                chip.setCheckable(false);
                chip.setClickable(false);

                chip.setText(input_tags.getText().toString());

                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chipGroup.removeView(chip);
                    }
                });

                chipGroup.addView(chip);
                input_tags.setText("");
            }
        });
    }
}