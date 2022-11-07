package figures;

import base.Figure;
import base.INonCircle;


public class Rectangle extends Figure implements INonCircle {
    private double sideA, sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public double calcArea() {
        return getSideA() * getSideB();
    }

    @Override
    public double calcPerimeter() {
        return 2 * (getSideA() + getSideB());
    }

}
