package model;

public class Contribution {
    private Integer sum;
    @Override
    public String toString() {
        return "Contribution{" +
                "sum=" + sum +
                '}';
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Contribution(Integer sum) {
        if (Integer.MAX_VALUE <= sum || sum <= Integer.MIN_VALUE) {
            throw new RuntimeException("Invalid contribution sum");
        }
        this.sum = sum;
    }
}
