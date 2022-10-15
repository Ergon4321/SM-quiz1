package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    private int currentIndex = 0;

    Question[] questions = new Question[]
            {
              new Question(R.string.pyt1, true),
              new Question(R.string.pyt2, false),
              new Question(R.string.pyt3, true),
              new Question(R.string.pyt4, true),
              new Question(R.string.pyt5, false),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button true_button = findViewById(R.id.true_button);
        Button false_button = findViewById(R.id.false_button);
        Button next_button = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);


        true_button.setOnClickListener(v -> {
            int resultMessageId = questions[currentIndex].isTrueAnswer()
                    ? R.string.correct
                    : R.string.wrong;
            Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
        });

        false_button.setOnClickListener(v -> {
            int resultMessageId = !questions[currentIndex].isTrueAnswer()
                    ? R.string.correct
                    : R.string.wrong;
            Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
        });

        next_button.setOnClickListener(v ->{
            currentIndex = (currentIndex + 1) % questions.length;
            setNextQuestion();
        });


    }
    public void setNextQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionId());

    }
}