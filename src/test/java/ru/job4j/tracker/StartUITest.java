package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem(){
        String[] questions = {"Test Item"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(questions);
        StartUI.createItem(input, tracker);
        Item result = tracker.findById(1);
        Item expected = new Item(questions[0]);
        assertThat(result.getName(), is(expected.getName()));
    }
}
