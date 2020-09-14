package sh4rkizz.Lab3;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 10;
        color = "pink";
    }

    public Circle(double radius) {
        this.radius = radius;
        color = "green";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double calculateArea() {
        return radius * radius * Math.PI;
    }
}
