package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
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

    @Test
    public void whenReplaceItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("first name");
        tracker.add(item);
        String newName = "new name";
        String[] questions = {"1", newName};
        Input input = new StubInput(questions);
        StartUI.editItem(input, tracker);
        String result = tracker.findById(1).getName();
        assertThat(result, is(newName));
    }

    @Test
    public void whenDeleteItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("Test Item");
        tracker.add(item);
        String[] questions = {"1"};
        Input input = new StubInput(questions);
        StartUI.deleteItem(input, tracker);
        Item result = tracker.findById(1);
        assertThat(result, is(nullValue()));
    }
}














