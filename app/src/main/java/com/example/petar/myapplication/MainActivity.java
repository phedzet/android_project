package com.example.petar.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_answer1, b_answer2, b_answer3, b_answer4;

    ImageView iv_flag;

    List<CountryItem> list;

    Random r;

    int turn = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        iv_flag = (ImageView) findViewById(R.id.iv_flag);

        b_answer1 = (Button) findViewById(R.id.b_answer1);
        b_answer2 = (Button) findViewById(R.id.b_answer2);
        b_answer3 = (Button) findViewById(R.id.b_answer3);
        b_answer4 = (Button) findViewById(R.id.b_answer4);

        list = new ArrayList<>();

        //add all flags and names to list

        for(int i = 0; i < new Database().answers.length; i++) {
            list.add(new CountryItem(new Database().answers[i], new  Database().flags[i]));
        }

        //shufle the countries

        Collections.shuffle(list);

        newQuestion(turn);

        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if answer is correct
                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(MainActivity.this, "Bravo!", Toast.LENGTH_SHORT).show();

                    //check if last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), PlayAgainActivity.class);
                        i.putExtra("caller", "MainActivity");
                        startActivity(i);
                        finish();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Pokušaj ponovno!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                    //finish();

                }

            }
        });

        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if answer is correct
                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(MainActivity.this, "Bravo!", Toast.LENGTH_SHORT).show();

                    //check if last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), PlayAgainActivity.class);
                        i.putExtra("caller", "MainActivity");
                        startActivity(i);
                        finish();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Pokušaj ponovno!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                    //finish();
                }

            }
        });

        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if answer is correct
                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(MainActivity.this, "Bravo!", Toast.LENGTH_SHORT).show();

                    //check if last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), PlayAgainActivity.class);
                        i.putExtra("caller", "MainActivity");
                        startActivity(i);
                        finish();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Pokušaj ponovno!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                    //finish();
                }

            }
        });

        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if answer is correct
                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())) {
                    Toast.makeText(MainActivity.this, "Bravo!", Toast.LENGTH_SHORT).show();

                    //check if last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), PlayAgainActivity.class);
                        i.putExtra("caller", "MainActivity");
                        startActivity(i);
                        finish();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Pokušaj ponovno!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, "Stigli smo do kraja!", Toast.LENGTH_SHORT).show();
                    //finish();
                }

            }
        });
    }

    private void newQuestion(int number) {
        //set flag image to the screeen
        iv_flag.setImageResource(list.get(number-1).getImage());

        //decide on which button to place correct answer
        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch (correct_answer) {
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());

                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstButton).getName());

                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(forthButton).getName());
                break;
        }
    }
}
