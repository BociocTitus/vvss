package repository;

import model.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> members = new ArrayList<Member>();

    private final static String filenameMember = "membersF.txt";

    @SuppressWarnings("resource")
    public MemberRepository() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String currentLine = null;
        try {

            fileReader = new FileReader(filenameMember);
            bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                String line[] = currentLine.split(";");
                Member m = new Member(line[0], line[1]);
                this.members.add(m);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void addMember(Member m) {
        members.add(m);
    }

    public List<Member> getMembers() {
        return members;
    }
}
