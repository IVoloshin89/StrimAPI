package Core.Lession1.HW1;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b); // Деление на ноль

        calc.println.accept(a);
        calc.println.accept(b);
        calc.println.accept(c);
    }
}

class Calculator {
    static Supplier calc1;
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> { //x / y; //Возможно деление на 0
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("Произошло деление на ноль" + e.getMessage());
            return 0;
        }
    };


    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

}