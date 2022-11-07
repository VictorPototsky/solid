package figures;

import base.INonCircle;


public class Square extends Rectangle implements INonCircle {
    private double side;

    public Square(double side) {
        super(side, side);
    }

}
