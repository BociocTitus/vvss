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

        this.sum = sum;
    }
}
