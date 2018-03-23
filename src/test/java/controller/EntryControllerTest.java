package controller;


import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;

public class EntryControllerTest {

    private EntryController entryController;

    @Before
    public void setUp() {
        entryController = new EntryController(new EntryRepository());
    }

    @Test
    public void addEntry() {
    }
}
