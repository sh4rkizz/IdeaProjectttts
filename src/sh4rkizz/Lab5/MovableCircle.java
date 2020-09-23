package sh4rkizz.Lab5;

public class MovableCircle implements Movable {
    private double radius;
    private MovablePoint center = new MovablePoint();

    public MovableCircle(int radius) {
        this.radius = radius;
    }

    public void moveUp(double up) {
        center.setX(center.getX()+up);
    }
    public void moveDown(double down) {
        center.setY(center.getY()+down);
    }
    public void moveLeft(double left) {
        center.setX(center.getX()-left);
    }
    public void moveRight(double right) {
        center.setX(center.getX()+right);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
