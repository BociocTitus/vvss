package model;

import java.util.HashMap;
import java.util.Map;

public class Community {
    private Map<Member, Contribution> contributionHashMap;

    public Map<Member, Contribution> getContributionHashMap() {
        return contributionHashMap;
    }

    public void setContributionHashMap(Map<Member, Contribution> contributionHashMap) {
        this.contributionHashMap = contributionHashMap;
    }

    public Community() {
        this.contributionHashMap = new HashMap<>();
    }

    public void addMember(Member m, Contribution contribution) {
        if (Integer.MAX_VALUE < contribution.getSum() || contribution.getSum() < Integer.MIN_VALUE) {
            throw new RuntimeException("Invalid contribution sum");
        }
        contributionHashMap.put(m, contribution);
    }
}
