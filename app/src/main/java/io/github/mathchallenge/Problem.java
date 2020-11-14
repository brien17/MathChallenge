package io.github.mathchallenge;

public interface Problem {
    String getProblem();
    int[] getSolutions();
    void generateProblemAndSolutions();
    boolean checkSolution(int solution);
}
