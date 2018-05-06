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

public class IncrementalIntegrationTest {
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
    public void testMemberAndEntry() {
        Member member = new Member("Joe", "23");
        Entry entry = new Entry("cost", 12, 1);
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
            entryController.addEntry(entry);
            assert (true);
        } catch (Exception e) {
            assert (false);
        }
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
