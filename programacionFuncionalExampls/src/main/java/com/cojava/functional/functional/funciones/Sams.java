package functional.funciones;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class Sams {

  @FunctionalInterface
  interface Trifunction<T, U, V, R> {
    R apply(T t, U u, V v);
  }
 

  public static void main(String[] args) {

    Function<Integer, String> addZero = (x) -> x < 10 ? "0" + x : String.valueOf(x);

    Trifunction<Integer, Integer, Integer, LocalDate> parseToDate = (year, month, days) -> 
      LocalDate.parse(year + "-" + addZero.apply(month) + "-" + addZero.apply(days));
  
    Trifunction<Integer, Integer, Integer, Integer> age = (year, month, day) -> 
      Period.between( parseToDate.apply(year, month, day),LocalDate.now()).getYears();

      System.out.println(age.apply(1994,6,25));
  }
}
