package sh4rkizz.Lab3;

import java.util.Scanner;

public class Hand {

    public Hand(int armsQuantity, int fingerQuantity) {
        this.armsQuantity = armsQuantity;
        this.fingerQuantity = fingerQuantity;
    }

    private int armsQuantity, fingerQuantity;

    public int getArmsQuantity() {
        return armsQuantity;
    }

    public void setArmsQuantity(int armsQuantity) {
        this.armsQuantity = armsQuantity;
    }

    public int getFingerQuantity() {
        return fingerQuantity;
    }

    public void setFingerQuantity(int fingerQuantity) {
        this.fingerQuantity = fingerQuantity;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "armsQuantity=" + armsQuantity +
                ", fingerQuantity=" + fingerQuantity +
                '}';
    }
}
