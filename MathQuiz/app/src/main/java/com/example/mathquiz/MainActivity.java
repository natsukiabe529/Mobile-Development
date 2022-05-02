package com.example.mathquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_questions, tv_timer, tv_bottomMessage;
    ProgressBar prog_timer;


    int score;
    String question;
    String answer0;
    String answer1;
    String answer2;
    String answer3;
    int numberCorrect = 0;
    int totalQuestions = 0;

    Game g = new Game(numberCorrect, totalQuestions);

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("secondsValue", secondsRemaining);
        outState.putInt("scoreValue", score);
        outState.putString("questionValue", question);
        outState.putString("answer0Value", answer0);
        outState.putString("answer1Value", answer1);
        outState.putString("answer2Value", answer2);
        outState.putString("answer3Value", answer3);
        outState.putInt("numberCorrectValue", numberCorrect);
        outState.putInt("totalQuestionsValue", totalQuestions);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        secondsRemaining = savedInstanceState.getInt("secondsValue");
        score = savedInstanceState.getInt("scoreValue");
        question = savedInstanceState.getString("questionValue");
        answer0 = savedInstanceState.getString("answer0Value");
        answer1 = savedInstanceState.getString("answer1Value");
        answer2 = savedInstanceState.getString("answer2Value");
        answer3 = savedInstanceState.getString("answer3Value");
        numberCorrect = savedInstanceState.getInt("numberCorrectValue");
        totalQuestions = savedInstanceState.getInt("totalQuestionsValue");
        tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
        tv_score.setText(Integer.toString(score));
        tv_questions.setText(question);
        btn_answer0.setText(answer0);
        btn_answer1.setText(answer1);
        btn_answer2.setText(answer2);
        btn_answer3.setText(answer3);
        tv_bottomMessage.setText(numberCorrect  + "/" + (totalQuestions - 1));
        g = new Game(numberCorrect, totalQuestions);


        btn_start.setVisibility(View.INVISIBLE);
        CountDownTimer t = new CountDownTimer(secondsRemaining*1000, 1000) {
            @Override
            public void onTick(long l) {
                secondsRemaining--;
                tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
                prog_timer.setProgress(30 - secondsRemaining);
            }

            @Override
            public void onFinish() {
                btn_answer0.setEnabled(false);
                btn_answer1.setEnabled(false);
                btn_answer2.setEnabled(false);
                btn_answer3.setEnabled(false);

                tv_bottomMessage.setText("Time is up!" + g.getNumberCorrect() + "/" + (g.getTotalQuestions()-1));

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() { btn_start.setVisibility(View.VISIBLE);
                    }
                }, 4000);
            }
        };

        t.start();
    }

    int secondsRemaining = 30;
    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long l) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
            prog_timer.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);

            tv_bottomMessage.setText("Time is up!" + g.getNumberCorrect() + "/" + (g.getTotalQuestions()-1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() { btn_start.setVisibility(View.VISIBLE);
                }
            }, 4000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);

        tv_score = findViewById(R.id.tv_score);
        tv_bottomMessage = findViewById(R.id.tv_bottomMessage);
        tv_questions = findViewById(R.id.tv_questions);
        tv_timer = findViewById(R.id.tv_timer);

        prog_timer = findViewById(R.id.prog_timer);

        tv_timer.setText("0Sec");
        tv_questions.setText("");
        tv_bottomMessage.setText("Press Go");
        tv_score.setText("0pts");

        View.OnClickListener startButtonClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button start_button = (Button) v;
                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining = 30;
                g = new Game(0, 0);
                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Button buttonClicked = (Button) v;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                g.checkAnswers(answerSelected);
                score = g.getScore();
                tv_score.setText(Integer.toString(score));
                nextTurn();
            }
        };

        btn_start.setOnClickListener(startButtonClickListener);

        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
    }

    private void nextTurn(){
        // create a new question
        // set text on answer buttons
        // enable answer buttons
        // start the timer
        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();

        answer0 = Integer.toString(answer[0]);
        answer1 = Integer.toString(answer[1]);
        answer2 = Integer.toString(answer[2]);
        answer3 = Integer.toString(answer[3]);


        btn_answer0.setText(answer0);
        btn_answer1.setText(answer1);
        btn_answer2.setText(answer2);
        btn_answer3.setText(answer3);

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        question = g.getCurrentQuestion().getQuestionPhrase();
        tv_questions.setText(question);
        numberCorrect = g.getNumberCorrect();
        totalQuestions = g.getTotalQuestions();
        tv_bottomMessage.setText(g.getNumberCorrect()  + "/" + (g.getTotalQuestions() - 1));
    }
}