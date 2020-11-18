package sh4rkizz.Lab_3;

public class Leg {
    private int fingerQuantity, legSize;

    public Leg(int fingerQuantity, int legSize) {
        this.fingerQuantity = fingerQuantity;
        this.legSize = legSize;
    }

    public int getFingerQuantity() {
        return fingerQuantity;
    }

    public void setFingerQuantity(int fingerQuantity) {
        this.fingerQuantity = fingerQuantity;
    }

    public int getLegSize() {
        return legSize;
    }

    public void setLegSize(int legSize) {
        this.legSize = legSize;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "fingerQuantity=" + fingerQuantity +
                ", legSize=" + legSize +
                '}';
    }
}
