package controller;

import model.Entry;
import repository.EntryRepository;

import java.util.List;

public class EntryController {
    private EntryRepository entryRepository;

    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void addEntry(Entry entry) {
        if (entry.getType().equals("cost") || entry.getType().equals("income"))
            entryRepository.addEntry(entry);
        else
            throw new RuntimeException("Invalid entry type");
    }

    public List<Entry> getEntries() {
        return entryRepository.getAllEntries();
    }
}
