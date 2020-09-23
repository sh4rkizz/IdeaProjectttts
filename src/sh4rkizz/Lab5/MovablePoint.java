package sh4rkizz.Lab5;

public class MovablePoint implements Movable {
    private double x, y;

    public MovablePoint() {
    }

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveUp(double up) {
        y -= up;
    }

    public void moveDown(double down) {
        y += down;
    }

    public void moveLeft(double left) {
        x -= left;
    }

    public void moveRight(double right) {
        x += right;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
