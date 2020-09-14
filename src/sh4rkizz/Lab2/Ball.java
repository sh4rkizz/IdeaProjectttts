package sh4rkizz.Lab2;

public class Ball {
    private String ballType;
    private double weight;

    public Ball() {
        this.ballType = "None";
        this.weight = 0;
    }

    public Ball(String ballType) {
        this.ballType = ballType;
        this.weight = 0;
    }

    public Ball(String ballType, double weight) {
        this.ballType = ballType;
        this.weight = weight;
    }

    public String getBallType() {
        return this.ballType;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String toString() {
        return "Ball{" +
                "ballType='" + ballType + '\'' +
                ", weight=" + weight +
                '}';
    }
}