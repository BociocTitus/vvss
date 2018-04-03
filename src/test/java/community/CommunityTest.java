package community;

import model.Community;
import model.Contribution;
import model.Member;
import org.junit.Before;
import org.junit.Test;

public class CommunityTest {
    private Community community;

    @Before
    public void setUp() {
        community = new Community();
    }

    @Test
    public void addValidContribution() {
        try {
            community.addMember(new Member("Joe", "2333"), new Contribution(100));
            assert (true);
        } catch (Exception e) {
            e.printStackTrace();
            assert (false);
        }
    }

    @Test
    public void addInvalidHigherContribution() {
        try {
            community.addMember(new Member("Joe", "2333"), new Contribution(Integer.MAX_VALUE));
            assert (false);
        } catch (Exception e) {
            assert (true);
        }
    }

    @Test
    public void addInvalidLowerContribution() {
        try {
            community.addMember(new Member("Joe", "2333"), new Contribution(Integer.MIN_VALUE));
            assert (false);
        } catch (Exception e) {
            assert (true);
        }
    }


}
