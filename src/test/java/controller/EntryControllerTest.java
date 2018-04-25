package controller;


import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.List;

public class EntryControllerTest {

    private EntryController entryController;
    private MemberRepository memberRepository;

    @Before
    public void setUp() {
        memberRepository = new MemberRepository();
        entryController = new EntryController(memberRepository, new EntryRepository());
        memberRepository.addMember(new Member("Joe", "1"));
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
    public void addEntryWithValidMember() {
        Entry entry = new Entry("cost", 12, 1);
        try {
            entryController.addEntry(entry);
        } catch (Exception e) {
            assert (false);
        }
    }

    @Test
    public void addEntryWithInvalidMember() {
        Entry entry = new Entry("cost", 12, 123);
        try {
            entryController.addEntry(entry);
            assert (false);
        } catch (Exception e) {
            assert (true);
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

    @Test
    public void testGetEntries() {
        Entry entry = new Entry("cost", 12, 1);
        try {
            entryController.addEntry(entry);
        } catch (Exception e) {
            assert (false);
        }
        List<Entry> entries = entryController.getEntries();
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 100 && entry1.getIdMember() == 1 && entry1.getType().equals("income")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 50 && entry1.getIdMember() == 1 && entry1.getType().equals("income")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 10 && entry1.getIdMember() == 2 && entry1.getType().equals("income")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 40 && entry1.getIdMember() == 1 && entry1.getType().equals("income")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 20 && entry1.getIdMember() == 2 && entry1.getType().equals("income")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 90 && entry1.getIdMember() == 1 && entry1.getType().equals("cost")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 10 && entry1.getIdMember() == 2 && entry1.getType().equals("cost")));
        assert(entries.stream().anyMatch(entry1 -> entry1.getValue() == 10 && entry1.getIdMember() == 3 && entry1.getType().equals("cost")));
    }
}
