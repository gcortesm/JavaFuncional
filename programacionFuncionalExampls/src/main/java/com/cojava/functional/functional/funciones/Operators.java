package functional.funciones;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Operators {
  public static void main(String[] args) {
    UnaryOperator<String> quota = text -> "\"" + text + "\"";
    System.out.println(quota.apply("Gustavo"));

    BiFunction<Integer, Integer, Integer> multiplicacio = (x, y) -> x * y;
    System.out.println(multiplicacio.apply(3, 4));

    BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
    System.out.println(binaryOperator.apply(12, 13));

    BiFunction<Integer, String, String> leftPad = (number, text) -> 
                                  String.format("%" + number + "s", text);

    System.out.println(leftPad.apply(5,"Gus"));

    

  }
}
