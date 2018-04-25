import controller.EntryController;
import controller.MemberController;
import exceptions.InvalidNameException;
import model.Entry;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.List;

public class IntegrationTest {
    private EntryController entryController;
    private MemberController memberController;

    @Before
    public void setUp() {
        MemberRepository memberRepository = new MemberRepository();
        memberController = new MemberController(memberRepository);
        entryController = new EntryController(memberRepository, new EntryRepository());
        memberRepository.addMember(new Member("Joe", "1"));
    }

    @Test
    public void testMember() {
        Member member = new Member("Joe", "23");
        try {
            memberController.addMember(member);
            memberController.getMemebers()
                    .stream()
                    .filter(nmember -> nmember.getId()
                            .equals("23")).findAny()
                    .ifPresent(nmember -> {
                        assert (nmember.getName().equals("Joe"));
                        assert (nmember.getId().equals("23"));
                    });

        } catch (InvalidNameException e) {
            assert (false);
        }
    }

    @Test
    public void testAddEntry() {
        Entry entry = new Entry("cost", 12, 1);
        try {
            entryController.addEntry(entry);
            assert (true);
        } catch (Exception e) {
            assert (false);
        }
    }

    @Test
    public void testGetAll() {
        List<Entry> entries = entryController.getEntries();
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 100 && entry1.getIdMember() == 1 && entry1.getType().equals("income")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 50 && entry1.getIdMember() == 1 && entry1.getType().equals("income")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 10 && entry1.getIdMember() == 2 && entry1.getType().equals("income")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 40 && entry1.getIdMember() == 1 && entry1.getType().equals("income")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 20 && entry1.getIdMember() == 2 && entry1.getType().equals("income")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 90 && entry1.getIdMember() == 1 && entry1.getType().equals("cost")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 10 && entry1.getIdMember() == 2 && entry1.getType().equals("cost")));
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 10 && entry1.getIdMember() == 3 && entry1.getType().equals("cost")));
    }

    @Test
    public void testIntegration() {
        Member member = new Member("Joe", "23");
        try {
            memberController.addMember(member);
            memberController.getMemebers()
                    .stream()
                    .filter(nmember -> nmember.getId()
                            .equals("23")).findAny()
                    .ifPresent(nmember -> {
                        assert (nmember.getName().equals("Joe"));
                        assert (nmember.getId().equals("23"));
                    });

        } catch (InvalidNameException e) {
            assert (false);
        }

        Entry entry = new Entry("cost", 12, 23);
        try {
            entryController.addEntry(entry);
            assert (true);
        } catch (Exception e) {
            assert (false);
        }

        List<Entry> entries = entryController.getEntries();
        assert (entries.stream().anyMatch(entry1 -> entry1.getValue() == 12 && entry1.getIdMember() == 23 && entry1.getType().equals("cost")));
    }
}
