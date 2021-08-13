package ru.job4j.tracker.output;

public class StubOutput implements Output{
    private StringBuilder output = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null){
            output.append(obj);
        } else {
            output.append(System.lineSeparator());
        }
    }

    @Override
    public String toString() {
        return output.toString();
    }
}
