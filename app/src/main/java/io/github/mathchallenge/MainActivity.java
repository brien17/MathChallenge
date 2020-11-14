package io.github.mathchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView highScoreText;
    private TextView currentScoreText;
    private TextView timeRemaining;
    private TextView currentProblem;
    private TextView option1;
    private TextView option2;
    private TextView option3;
    private TextView option4;
    private Button playButton;
    private Problem problem;
    private ScoreManager manager;
    private ProblemFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        factory = new ProblemFactory();


        manager = ScoreManager.getScoreManager();
        manager.getHighScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer newHighScore) {
                highScoreText.setText(newHighScore.toString());
            }
        });
        manager.setNewHighScore(readSavedHighScore());

        manager.getCurrentScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer currentScore) {
                currentScoreText.setText(currentScore.toString());
            }
        });
    }

    private void setupViews() {
        highScoreText = findViewById(R.id.high_score);
        currentScoreText = findViewById(R.id.current_score);
        timeRemaining = findViewById(R.id.time_remaining);
        currentProblem = findViewById(R.id.current_problem);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        playButton = findViewById(R.id.playButton);
        setVisibilityTextViews(View.INVISIBLE);
    }

    // TODO
    private int readSavedHighScore() {
        return 0;
    }

    public void startGame(View v) {
        setVisibilityTextViews(View.VISIBLE);
        playButton.setVisibility(View.INVISIBLE);
        manager.setCurrentScore(0);
        showProblem();

    }

    private void setVisibilityTextViews(int visibility) {
        highScoreText.setVisibility(visibility);
        currentScoreText.setVisibility(visibility);
        timeRemaining.setVisibility(visibility);
        currentProblem.setVisibility(visibility);
        option1.setVisibility(visibility);
        option2.setVisibility(visibility);
        option3.setVisibility(visibility);
        option4.setVisibility(visibility);
    }


    private void showProblem() {
        problem = factory.generateProblemAndSolution("addition");
        currentProblem.setText(problem.getProblem());
        int[] solutions = problem.getSolutions();
        option1.setText(String.format(Integer.toString(solutions[0])));
        option2.setText(String.format(Integer.toString(solutions[1])));
        option3.setText(String.format(Integer.toString(solutions[2])));
        option4.setText(String.format(Integer.toString(solutions[3])));
    }


}