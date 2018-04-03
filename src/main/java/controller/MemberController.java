package controller;

import exceptions.InvalidNameException;
import model.Member;
import repository.MemberRepository;

import java.util.List;

public class MemberController {

    private MemberRepository mr;

    public MemberController(MemberRepository newMr) {
        this.mr = newMr;
    }

    public void addMember(Member aMemebr) throws InvalidNameException {
        Integer.parseInt(aMemebr.getId());

        if (aMemebr.getName().isEmpty()) {
            throw new InvalidNameException();
        }

        for (char c : aMemebr.getName().toCharArray()) {
            if (!Character.isLetter(c))
                throw new InvalidNameException();
        }
        mr.addMember(aMemebr);
    }

    public List<Member> getMemebers() {
        return mr.getMembers();
    }

} 