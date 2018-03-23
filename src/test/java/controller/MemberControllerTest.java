package controller;


import exceptions.InvalidNameException;
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
    public void addMember() {
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
        member.setName("Joe42");
        try {
            memberController.addMember(member);
            assert (false);
        } catch (InvalidNameException e) {
            assert (true);
        }


    }

    @Test
    public void getMemebers() {
    }
}
