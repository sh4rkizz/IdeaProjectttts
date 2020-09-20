package sh4rkizz.Lab3;

public class Head {
    private String hairColor;
    private double hairLength;

    public Head(String hairColor, double hairLength) {
        this.hairColor = hairColor;
        this.hairLength = hairLength;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public double getHairLength() {
        return hairLength;
    }

    public void setHairLength(double hairLength) {
        this.hairLength = hairLength;
    }

    @Override
    public String toString() {
        return "Head{" +
                "hairColor='" + hairColor + '\'' +
                ", hairLength=" + hairLength +
                '}';
    }
}
