package controller;

import model.Entry;
import repository.EntryRepository;

import java.util.List;

public class EntryController {
    private EntryRepository entryRepository;

    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void addEntry(Entry entry){
        entryRepository.addEntry(entry);
    }

    public List<Entry> getEntries(){
        return entryRepository.getAllEntries();
    }
}
