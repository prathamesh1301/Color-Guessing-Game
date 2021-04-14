package com.example.colorguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LearnActivity extends AppCompatActivity {
    private Button colorButton;
    private TextView colorName;
    private ImageView prevArrow,nextArrow;
    private String[] colors={"Black","Gold","Yellow","Orange","Pink","Green","Gray","Blue","Brown","Violet","Indigo","Red","Silver"};
    private String[] hexCode={"#000000","#FFD700","#FFFF00","#FFA500","#FF69B4","#008000","#808080","#00BFFF","#A52A2A","#8A2BE2","#4B0082","#FF0000","#C0C0C0"};
    private Integer currentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        colorButton=findViewById(R.id.colorButton);
        colorName=findViewById(R.id.colorName);
        prevArrow=findViewById(R.id.prevArrow);
        nextArrow=findViewById(R.id.nextArrow);

        colorName.setText(colors[currentIndex]);
        colorButton.setBackgroundColor(Color.parseColor(hexCode[currentIndex]));

        prevArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex--;
                if(currentIndex<0){
                    currentIndex=colors.length-1;
                }
                colorButton.setBackgroundColor(Color.parseColor(hexCode[currentIndex]));
                colorName.setText(colors[currentIndex]);

            }
        });

        nextArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if(currentIndex>colors.length-1){
                    currentIndex=0;
                }
                colorButton.setBackgroundColor(Color.parseColor(hexCode[currentIndex]));
                colorName.setText(colors[currentIndex]);
            }
        });

    }
}