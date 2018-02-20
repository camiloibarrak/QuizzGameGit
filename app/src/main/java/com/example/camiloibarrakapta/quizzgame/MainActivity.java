package com.example.camiloibarrakapta.quizzgame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

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
    static final private int QUIZ_COUNT = 15;

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
            {"Spain", "Madrid", "Mexico City", "Jakarta", "Havana"},
            {"Colombia", "Bogota", "cali", "Medellin", "Popayán"}
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
        countLabel.setText("Kapta Question " + quizCount);

        //Generar un numero entre 0 y 14
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //Seleccionar un quiz
        ArrayList<String> quiz = quizArray.get(randomNum);

        //Setear la pregunta y la respuesta correcta
        //Array format {"Colombia", "Right answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        //Borrar "Country" del quiz y
        quiz.remove(0);
        Collections.shuffle(quiz);

        //Setear opciones
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        //Borrar este quiz de la lista
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view){
        //Capturar el boton presionado
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            //Correcto
            alertTitle = "Correcto!";
            rightAnswerCount ++;
        }else{
            //Incorrecto
            alertTitle = "Incorrecto!";
        }

        //Crear dialogo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: " + rightAnswer);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(quizCount == QUIZ_COUNT){
                    //Mostrar resultado
                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
