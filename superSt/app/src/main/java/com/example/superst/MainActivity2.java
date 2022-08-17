package com.example.superst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
Button rock , scissors , paper;
TextView score;
ImageView iv_yourChoice, iv_computerChoice;

int HumanScore, ComputerScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView customerNameT1 = findViewById(R.id.textView2);
        TextView Hello = findViewById(R.id.textView);
        TextView yourChoice = findViewById(R.id.yourChoice);
        TextView computerChoice = findViewById(R.id.computerChoice);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);
        rock = (Button) findViewById(R.id.rock);
        iv_computerChoice =(ImageView) findViewById(R.id.iv_computerChoice);
        iv_yourChoice = (ImageView) findViewById(R.id.iv_yourChoice);
        score = (TextView) findViewById(R.id.score);

                Bundle bundle = getIntent().getExtras();



        // name
        String name = bundle.getString("name");
        customerNameT1.setText(name);



    paper.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        iv_yourChoice.setImageResource(R.drawable.paper2);
       String message =  play_turn("paper");
        Toast .makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
        score.setText("Score Human :"+ Integer.toString(HumanScore)+ "Computer:"+ Integer.toString(ComputerScore));

    }
});

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_yourChoice.setImageResource(R.drawable.rock);
                String message =  play_turn("rock");
                Toast .makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Score Human :"+ Integer.toString(HumanScore)+ "Computer:"+ Integer.toString(ComputerScore));
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_yourChoice.setImageResource(R.drawable.scissors2);
                String message =  play_turn("scissors");
                Toast .makeText(MainActivity2.this, message, Toast.LENGTH_SHORT).show();
                score.setText("Score Human :"+ Integer.toString(HumanScore)+ "Computer:"+ Integer.toString(ComputerScore));
            }
        });




    }
    public String play_turn(String player_choice){
        String computer_choice ="";
        Random random = new Random();

     // choose 1 2 or 3
        int computer_choice_number = random.nextInt(3) + 1;
        if (computer_choice_number==1) {
            computer_choice = "rock";
        } else

        if (computer_choice_number==2) {
            computer_choice = "scissors";
        } else

        if (computer_choice_number==3) {
            computer_choice = "paper";
        }
        // set the computer image based on his choice
        if (computer_choice == "rock"){
            iv_computerChoice.setImageResource(R.drawable.rock);
    }else
        if (computer_choice == "paper"){
            iv_computerChoice.setImageResource(R.drawable.paper2);
        }else
        if (computer_choice == "scissors"){
            iv_computerChoice.setImageResource(R.drawable.scissors2);
        }
        // مقارنه للفوز

        if (computer_choice == player_choice) {
            return"لا تحاتي محد فاز";
        }
        else if (player_choice == "rock"&& computer_choice == "scissors"){
           HumanScore++;
            return "مبرووك فزت";
        }
        else if (player_choice == "rock"&& computer_choice == "paper"){
            ComputerScore++;
            return "هاردلك";
        }
        else if (player_choice == "scissors"&& computer_choice == "rock") {
        ComputerScore++;
            return "هاردلك";
        }
        else if (player_choice == "scissors"&& computer_choice == "paper"){
            HumanScore++;
            return "مبرووك فزت";
        }
        else if (player_choice == "paper"&& computer_choice == "rock"){
            HumanScore++;
            return "مبرووك فزت";
        }
        else if (player_choice == "paper"&& computer_choice == "scissors") {
        ComputerScore++;
            return "هاردلك";
        }

       else return "not sure";
    }


}