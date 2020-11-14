package io.github.mathchallenge;

import androidx.lifecycle.MutableLiveData;

public class ScoreManager {
    private MutableLiveData<Integer> highScore;
    private MutableLiveData<Integer> currentScore;
    private static ScoreManager manager = null;

    private ScoreManager() {
        highScore = new MutableLiveData<>();
        highScore.setValue(0);
        currentScore = new MutableLiveData<>();
        currentScore.setValue(0);
    }

    public static ScoreManager getScoreManager() {
        if (manager == null) {
            manager = new ScoreManager();
        }
        return manager;
    }

    public void setNewHighScore(int highScore) {
        if (this.highScore.getValue() < highScore) {
            this.highScore.setValue(highScore);
        }
    }

    public void setNewHighScore() {
        if (highScore.getValue() < currentScore.getValue()) {
            highScore.setValue(currentScore.getValue());
        }
    }

    public MutableLiveData<Integer> getHighScore() {
        return highScore;
    }

    public MutableLiveData<Integer> getCurrentScore() {
        return currentScore;
    }

    public void incrementCurrentScore() {
        currentScore.setValue(currentScore.getValue() + 1);
        setNewHighScore(currentScore.getValue());
    }

    public void setCurrentScore(int score) {
        currentScore.setValue(score);
    }

}
