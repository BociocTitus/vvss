package controller;


import model.Entry;
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
        Entry entry = new Entry("cost", 12, 1);
        try {
            entryController.addEntry(entry);
            assert (true);
        } catch (Exception e) {
            assert (false);
        }
    }

    @Test
    public void addEntryInvalid() {
        Entry entry = new Entry("costs", 12, 1);
        try {
            entryController.addEntry(entry);
            assert (false);
        } catch (Exception e) {
            assert (true);
        }
    }
}
