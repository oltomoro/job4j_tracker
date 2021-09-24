package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        String[] expected = {"0", "1", "2"};
        String expected1 = "0";
        String expected2 = "1";
        String expected3 = "2";
        Input in = new StubInput(expected);
        ValidateInput input = new ValidateInput(out, in);
        String result = input.askStr("Enter menu:");
        assertThat(expected1, is(result));
        result = input.askStr("Enter menu:");
        assertThat(expected2, is(result));
        result = input.askStr("Enter menu:");
        assertThat(expected3, is(result));
    }

    @Test
    public void whenInvalidInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }

    @Test
    public void whenInvalidInputStringNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
}
