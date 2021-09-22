package ru.job4j.tracker.input;

public class StubInput implements Input {
    private String[] questions;
    private int position;

    public StubInput(String[] questions) {
        this.questions = questions;
    }

    @Override
    public String askStr(String question) {
        return questions[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
