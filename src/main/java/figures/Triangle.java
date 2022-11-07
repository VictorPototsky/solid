package figures;

import base.Figure;
import base.INonCircle;


import static java.lang.Math.sqrt;

public class Triangle extends Figure implements INonCircle {
/*
 Считаем, для простоты реализации, что треугольник задается только способом - по трем сторонам.
 Не рассматриваем случаи определения треугольника по двум сторонам и углу между ними и по стороне и прилежащим к ней углам.
 */

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private double sideA, sideB, sideC;

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double calcArea() {
        /*
        Площадь считаем по формуле Герона
         */
        double semiP = calcPerimeter() / 2;
        return sqrt(semiP * (semiP - getSideA()) * (semiP - getSideB()) * (semiP - getSideC()));
    }


    /*     return getSideA() + getSideB() > getSideC() &&
                 getSideA() + getSideC() > getSideB() &&
                 getSideB() + getSideC() > getSideA() &&
                 getSideA() > 0 && getSideB() > 0 && getSideC() > 0;

 */
    @Override
    public double calcPerimeter() {
        return getSideA() + getSideB() + getSideC();
    }


}
