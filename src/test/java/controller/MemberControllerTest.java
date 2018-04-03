package controller;


import exceptions.InvalidNameException;
import model.Contribution;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

public class MemberControllerTest {

    private MemberController memberController;

    @Before
    public void setUp() {
        memberController = new MemberController(new MemberRepository());
    }

    @Test
    public void addValidMember() {
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
    public void addInvalidMember() {
        Member member = new Member("Joe23", "23");
        try {
            memberController.addMember(member);
            assert (false);
        } catch (InvalidNameException e) {
            assert (true);
        }
    }

    @Test
    public void addMemberWithNoId() {
        Member member = new Member("Joe", "");
        try {
            memberController.addMember(member);
            assert (false);
        } catch (NumberFormatException e) {
            assert (true);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addMemberWithNoName() {
        Member member = new Member("", "23");
        try {
            memberController.addMember(member);
            assert (false);
        } catch (InvalidNameException e) {
            assert (true);
        }
    }

}
