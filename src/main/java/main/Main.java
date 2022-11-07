package main;

import base.Figure;
import base.ICircle;
import base.INonCircle;
import figures.Circle;
import figures.Rectangle;
import figures.Square;
import figures.Triangle;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        List<Figure> list = new ArrayList<>();
        List<Double> p ;  //new ArrayList<>();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        // Создаем массив из 5 рандомных фигур
        for (int i = 0; i < 5; i++) {
            int figureType = r.nextInt(4);
            p = addParameters(figureType, sc);

            try {
                if (figureType == 3 && !isValidCreation(p)) {
                    throw new MyException();
                }
            } catch (MyException e) {
                System.out.println("Треугольник с заданными сторонами не может быть построен !!!");
                p.clear();
                if (i > 0) {
                    i--;
                    continue;
                }
            }
            try {
                switch (figureType) {
                    case 0 -> list.add(new Circle(p.get(0)));
                    case 1 -> list.add(new Square(p.get(0)));
                    case 2 -> list.add(new Rectangle(p.get(0), p.get(1)));
                    case 3 -> list.add(new Triangle(p.get(0), p.get(1), p.get(2)));
                    default -> throw new MyException();
                }
            } catch (MyException e) {
                System.out.println("Ошибка создани фигуры");
            }

            System.out.println(p);
        }
        sc.close();

    // По всем фигурам в массиве выдаем выведем характеристики объема и периметра (длины окружности)

        for (Figure f : list
        ) {
            printInfo(f);
        }
    }


    // Задаем параметры фигуры
    public static List<Double> addParameters(int type, Scanner sc) {
        List<Double> parameters = new ArrayList<>();
        int n = 1;
        String message = "";
        String typeName = "";

        switch (type) {
            case 0 -> {
                typeName = "Круг";
                message = "Введите значение радиуса окружности : ";
            }
            case 1 -> typeName = "Квадрат";
            case 2 -> {
                typeName = "Прямоугольник";
                n = 2;
            }
            case 3 -> {
                typeName = "Треугольник";
                n = 3;
            }
            default -> n =0;
        }
        System.out.println("Фигура - " + typeName);
        for (int i = 0; i < n; i++) {

            double value = 0.0;
            String st;
            if (type > 0) {
                char side = (char) (65 + i);
                message = "Введите значение стороны ";
                message = message + side + " : ";
            }
            boolean isContinue;

            do {
                try {
                    System.out.print(message);
                    st = sc.nextLine();
                    if (st.trim().isBlank()) {
                        throw new MyException();
                    } else {
                        value = Double.parseDouble(st);
                        if (value <= 0.0) {
                            throw new MyException();
                        }
                    }
                    isContinue = false;
                } catch (MyException e) {
                    System.out.println("Ошибка. Некорректный ввод данных.");
                    isContinue = true;
                } catch (NumberFormatException | InputMismatchException | IllegalStateException e) {
                    System.out.println("Введено некорректное числовое значение. Повторите попытку");
                    isContinue = true;
                }
            } while (isContinue);


            parameters.add(value);


        }
        return parameters;
    }
    // Дополнительный критерий проверки возможности построения треугольника по 3-м заданным сторонам
    private static boolean isValidCreation(List<Double> val) {
        return val.get(0) + val.get(1) > val.get(2) &&
                val.get(0) + val.get(2) > val.get(1) &&
                val.get(1) + val.get(2) > val.get(0);
    }


    public static void printInfo(Figure f) {

        String kind = switch (f.getClass().getSimpleName()) {
            case "Circle" -> "Круг";
            case "Rectangle" -> "Прямоугольник";
            case "Square" -> "Квадрат";
            case "Triangle" -> "Треугольник";
            default -> "";
        };
        System.out.println("********************************");
        System.out.println(kind);
        System.out.println("--------------------------------");
        System.out.println("Площадь равна " + f.calcArea());
        if (f instanceof ICircle) {
            System.out.println("Длина окружности равна " + ((Circle) f).calcCircleLength());
        }
        if (f instanceof INonCircle) {
            System.out.println("Периметр равен " + ((INonCircle) f).calcPerimeter());
        }
        System.out.println("--------------------------------");
    }

}


