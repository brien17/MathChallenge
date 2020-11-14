package io.github.mathchallenge;

public class ProblemFactory {
    public Problem generateProblemAndSolution(String type) {
        switch (type) {
            case "addition" : return new AdditionProblem();
            default: return new AdditionProblem();
        }
    }
}
