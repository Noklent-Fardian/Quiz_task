package org.o7planning.semester1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Button btn_start, btn_answer0, btn_answer1, btn_answer2, btn_answer3;
    TextView tv_score, tv_question, tv_timer, tv_bottommessage;
    ProgressBar prog_timer;
    ArrayList riwayat = new ArrayList();

    Game g =new Game();
    int kurangDetik=30;

    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            kurangDetik--;
            tv_timer.setText(Integer.toString(kurangDetik)+"detik");
            prog_timer.setProgress(30 - kurangDetik);

        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText("Hasil= "+g.getNumberCorrect()+" Benar dari "+(g.getTotalQuestions()-1)+" Soal");
            final Handler handler=new Handler();
            handler.postDelayed(new Runnable(){
                @Override
                public  void run(){
                    btn_start.setVisibility(View.VISIBLE);
                }
            }, 3000);


        }
    };
    public void other(View view) {
        Intent intent2 = new Intent(MainActivity2.this, Other.class);
        MainActivity2.this.startActivity(intent2);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_start= findViewById(R.id.btn_start);
        btn_answer0=findViewById(R.id.btn_answer0);
        btn_answer1=findViewById(R.id.btn_answer1);
        btn_answer2=findViewById(R.id.btn_answer2);
        btn_answer3=findViewById(R.id.btn_answer3);
        prog_timer = findViewById(R.id.prog_timer);

        tv_score= findViewById(R.id.tv_score);
        tv_bottommessage= findViewById(R.id.tv_bottommessage);
        tv_question=findViewById(R.id.tv_question);
        tv_timer=findViewById(R.id.tv_timer);

        tv_timer.setText("0detik");
        tv_question.setText("");
        tv_bottommessage.setText("Pencet Mulai");
        tv_score.setText("0pts");

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button=(Button)v;

                start_button.setVisibility(View.INVISIBLE);
                kurangDetik=30;
                g=new Game();
                nextTurn();
                timer.start();
            }

        };

        View.OnClickListener answerButtonClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked=(Button) v;

                int answerSelected= Integer.parseInt(buttonClicked.getText().toString());
                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
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
        g.makeNewQuestion();
        int [] answer=g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);
        tv_question.setText(g.getCurrentQuestion().getQuestionPhrase());

        tv_bottommessage.setText(g.getNumberCorrect()+"/"+(g.getTotalQuestions()-1));

    }

}

