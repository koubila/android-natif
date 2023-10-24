package com.itakademy.monquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itakademy.monquizz.pojos.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // declare global scope variables, warning obj null
    private TextView tvQuestion;
    private TextView tvScore;
    private Button trueButton;
    private Button falseButton;
    private Context context;
    private List<Question> questions = new ArrayList<>();
    private int index = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //déclare le layout de l'activité principale
        setContentView(R.layout.activity_main);

        // recupere les éléments
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        trueButton = findViewById(R.id.vrai);
        falseButton = findViewById(R.id.faux);
        // recupere context application
        context = getApplicationContext();

        // Créer les questions
        questions.add(new Question(getString(R.string.question_ai), true));
        questions.add(new Question(getString(R.string.question_taxi_driver), true));
        questions.add(new Question(getString(R.string.question_2001), false));
        questions.add(new Question(getString(R.string.question_reservoir_dogs), true));
        questions.add(new Question(getString(R.string.question_citizen_kane), false));

        // afficher la question 1
        tvQuestion.setText(questions.get(0).getText());

        // Listener avec un click avec interface View
        trueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Si la réponse de la question est bien vrai
                if (questions.get(index).isAnswer()){

                    // affiche un toast
                    CharSequence text = "Bonne réponse +1 point !";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // incremente score
                    score = score +1;

                    // afficher le score
                    tvScore.setText( "Score :"+ score);
                }else{
                    // affiche un toast
                    CharSequence text = "Mauvaise réponse!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if ( index <= questions.size() ){
                    // incremente index meme si ce nest pas true
                    index = index +1;

                    // affiche la question de l'index suivant
                    tvQuestion.setText(questions.get(index).getText());
                }


            }
        });

        falseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // Si la réponse de la question est bien faux
                if (!questions.get(index).isAnswer()){

                    // affiche un toast
                    CharSequence text = "Bonne réponse!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    // incremente score
                    score = score +1;
                    // afficher le score pas besoin si pas de changement
                    tvScore.setText( "Score :"+ score);
                }else{
                    // affiche un toast
                    CharSequence text = "Mauvaise réponse!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if ( index <= questions.size() || index !=4){
                    // incremente index meme si ce nest pas true
                    index = index +1;

                    // affiche la question de l'index suivant
                    tvQuestion.setText(questions.get(index).getText());
                }

            }
        });



    }
}