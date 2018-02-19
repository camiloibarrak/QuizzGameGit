package com.example.camiloibarrakapta.quizzgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            {"China", "Beijing", "Jakarta", "Manila", "Stockholm"},
            {"India", "New Delhi", "Beijing", "Bangkok", "Seoul"},
            {"Indonesia", "Jakarta", "Manila", "New Delhi", "Kuala Lumpur"},
            {"Japan", "Tokyo", "Bangkok", "Taipei", "Jakarta"},
            {"Thailand", "Bangkok", "Berlin", "Havana", "Kingston"},
            {"Brazil", "Brasilia", "Havana", "Bangkok", "Copenhagen"},
            {"Canada", "Ottawa", "Bern", "Copenhagen", "Jakarta"},
            {"Cuba", "Havana", "Bern", "London", "Mexico City"},
            {"Mexico", "Mexico City", "Ottawa", "Copenhagen", "Tokyo"},
            {"United States", "Washington D.C.", "New York", "San Jose", "Buenos Aires"},
            {"France", "Paris", "Ottawa", "Copenhagen", "Tokyo"},
            {"Germany", "Berlin", "Copenhagen", "Bangkok", "Santiago"},
            {"Italy", "Rome", "London", "Paris", "Athens"},
            {"Spain", "Madrid", "Mexico City", "Jakarta", "Havana"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            countLabel = (TextView)findViewById(R.id.countLabel);
            questionLabel = (TextView)findViewById(R.id.questionLabel);
            answerBtn1 = (Button)findViewById(R.id.answerBtn1);
            answerBtn2 = (Button)findViewById(R.id.answerBtn2);
            answerBtn3 = (Button)findViewById(R.id.answerBtn3);
            answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        //Create quizArray from quizData
        for (int i = 0; i < quizData.length; i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //Country
            tmpArray.add(quizData[i][1]); //Right Answer
            tmpArray.add(quizData[i][2]); //Choice1
            tmpArray.add(quizData[i][3]); //Choice2
            tmpArray.add(quizData[i][4]); //Choice3

            //Add tmpArray to quizArray
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz(){
        minuto 4:31 https://www.youtube.com/watch?v=aUQ9ciMDPSE&list=PLRdMAPi4QUfbEk4NfsImoUMudvxBI0bov&index=3
    }
}
