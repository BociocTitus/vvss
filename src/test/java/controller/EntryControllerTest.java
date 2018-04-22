package controller;


import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

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
}
