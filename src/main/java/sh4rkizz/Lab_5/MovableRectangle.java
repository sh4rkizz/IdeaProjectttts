package sh4rkizz.Lab_5;

public class MovableRectangle {
    private double width, length;
    private double perimeter, area;
    private final MovablePoint leftAngle;
    private final MovablePoint rightAngle;

    public MovableRectangle(MovablePoint leftAngle, MovablePoint rightAngle) {
        this.leftAngle = leftAngle;
        this.rightAngle = rightAngle;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void recalculateParameters(MovablePoint rightAngle, MovablePoint leftAngle) {
        this.length = Math.abs(rightAngle.getX() - leftAngle.getX());
        this.width = Math.abs(rightAngle.getY() - leftAngle.getY());
        this.perimeter = 2 * (this.width + this.length);
        this.area = this.width * this.length;
    }

    @Override
    public String toString() {
        recalculateParameters(rightAngle, leftAngle);

        return "\nMovableRectangle {" +
                "\nLeftAngle = " + leftAngle +
                ", rightAngle = " + rightAngle +
                "\nWidth = " + width +
                ", length = " + length +
                "\nPerimeter = " + perimeter +
                ", area = " + area +
                "\n}";
    }
}
