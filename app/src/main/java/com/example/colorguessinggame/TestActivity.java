package com.example.colorguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, color_test_btn, endBtn;
    private String[] colors = {"Black", "Gold", "Yellow", "Orange", "Pink", "Green", "Gray", "Blue", "Brown", "Violet", "Indigo", "Red", "Silver"};
    private String[] hexCode = {"#000000", "#FFD700", "#FFFF00", "#FFA500", "#FF69B4", "#008000", "#808080", "#00BFFF", "#A52A2A", "#8A2BE2", "#4B0082", "#FF0000", "#C0C0C0"};
    int ansIndex;
    List<Integer> doneColors;
    Random random;
    String ansColor;
    int selectedBtn;
    int score = 0;
    int total = 0;
    HashMap<Integer, Button> buttons;
    List<Integer> chosenColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        color_test_btn = findViewById(R.id.color_test_btn);
        endBtn = findViewById(R.id.endBtn);
        chosenColors = new ArrayList<>();
        playGame();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedBtn == 0) {
                    score++;

                } else {
                    score = score + 0;

                }
                total++;
                playGame();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedBtn == 1) {
                    score++;

                } else {
                    score = score + 0;

                }
                total++;
                playGame();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedBtn == 2) {
                    score++;

                } else {
                    score = score + 0;

                }
                total++;
                playGame();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedBtn == 3) {
                    score++;

                } else {
                    score = score + 0;

                }
                total++;
                playGame();
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "You Scored " + score + " out of " + total, Toast.LENGTH_LONG).show();
                startActivity(new Intent(TestActivity.this, MainActivity.class));
            }
        });


    }


    private void playGame() {
        random = new Random();

        ansIndex = random.nextInt(colors.length);

        color_test_btn.setBackgroundColor(Color.parseColor(hexCode[ansIndex]));
        ansColor = colors[ansIndex];
        selectedBtn = random.nextInt(4);
        buttons = new HashMap<>();
        buttons.put(0, btn1);
        buttons.put(1, btn2);
        buttons.put(2, btn3);
        buttons.put(3, btn4);

        switch (selectedBtn) {
            case 0:
                btn1.setText(ansColor);
                break;

            case 1:
                btn2.setText(ansColor);
                break;

            case 2:
                btn3.setText(ansColor);
                break;

            case 3:
                btn4.setText(ansColor);
                break;
        }
        int select_random_colors;
        doneColors = new ArrayList<>();
        doneColors.add(ansIndex);
        /*for (int i = 0; i < 4; i++) {
            if (selectedBtn == i) {
                continue;
            } else {
                select_random_colors = random.nextInt(colors.length);
                while (true) {
                    if (select_random_colors == ansIndex) {
                        select_random_colors = random.nextInt(colors.length);
                    } else {
                        break;
                    }
                }
                if (doneColors.size() == 0) {
                    buttons.get(i).setText(colors[select_random_colors]);
                    doneColors.add(select_random_colors);
                } else {
                    select_random_colors = random.nextInt(colors.length);
                    while (true) {
                        if (select_random_colors == ansIndex && doneColors.contains(select_random_colors)) {
                            select_random_colors = random.nextInt(colors.length);
                        } else {
                            doneColors.add(select_random_colors);
                            buttons.get(i).setText(colors[select_random_colors]);
                            break;
                        }
                    }

                }
            }


        }*/

        for(int j=0;j<4;j++){
            if(selectedBtn==j){
                continue;
            }else{
                select_random_colors=random.nextInt(colors.length);
                while(true){
                    if(doneColors.contains(select_random_colors)){
                        select_random_colors=random.nextInt(colors.length);
                    }else{
                        buttons.get(j).setText(colors[select_random_colors]);
                        doneColors.add(select_random_colors);
                        break;
                    }
                }
            }
        }
    }



    }


