package figures;

import base.Figure;
import base.ICircle;


import static java.lang.Math.pow;

public class Circle extends Figure implements ICircle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }

       @Override
    public double calcArea() {
        return PI * pow(getRadius(), 2);
    }

          @Override
    public double calcCircleLength() {
        return 2 * PI * getRadius();
    }

}
