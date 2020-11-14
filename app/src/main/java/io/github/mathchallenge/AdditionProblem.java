package io.github.mathchallenge;

import java.util.Random;

public class AdditionProblem implements Problem {
    private String problem;
    private int[] solutions;
    private int correctSolution;
    private Random numberGenerator;

    public AdditionProblem() {
        numberGenerator = new Random();
        solutions = new int[4];
        generateProblemAndSolutions();
    }

    @Override
    public String getProblem() {
        return problem;
    }

    @Override
    public int[] getSolutions() {
        return solutions;
    }

    @Override
    public boolean checkSolution(int solution) {
        return solution == correctSolution;
    }

    @Override
    public void generateProblemAndSolutions() {
        correctSolution = generateProblem();
        fillSolutionsArrayWithIncorrectSolutions(correctSolution);

        solutions[numberGenerator.nextInt(4)] = correctSolution;
    }

    private int generateProblem() {
        int firstNumber = numberGenerator.nextInt(50) +1;
        int secondNumber = numberGenerator.nextInt(50) + 1;
        problem = firstNumber + " + " + secondNumber;
        return firstNumber + secondNumber;
    }

    private void fillSolutionsArrayWithIncorrectSolutions(int correctSolution) {
        for (int i = 0; i < solutions.length; i++) {
            solutions[i] = (numberGenerator.nextBoolean()
                    ? correctSolution - numberGenerator.nextInt(10) - 1
                    : correctSolution + numberGenerator.nextInt(10) + 1);
        }
    }



}
