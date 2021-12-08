package functional.funciones;

import java.util.function.Function;
import java.util.function.Predicate;



public class MathFunctions {
  public static void main(String[] args) {
    Function<Integer,Integer> square= new Function<Integer,Integer>(){
      @Override
      public Integer apply(Integer t) {
        return t*t;
      }
    };


    //forma de escribir una funcion de manera mas rapida.
    Function<Integer,Boolean> isOdd = x -> x%2 == 1;


    //Otra interfaz agregada que se llama un predicate. Esta siempre recibe un valor y 
    // nos va a devolver un boolean.

    Predicate<Integer> isEven = x -> x%2 == 0 ;

    System.out.println("Ejecucion de un predicado que debe "+
    "hacerce con la llamada del metodo test. " + isEven.test(12));
    /*
      Las funciones ahora son tipos por esto se pueden pasar como parametros 
    */
    System.out.println(square.apply(6));
    System.out.println( isOdd.apply(3) );


    Predicate<Car> isHighCcm3= car -> car.getCcm3()>2000.0;

    Car toretoCars = new Car(5000);
    Car noToretoCars = new Car(500);
    System.out.println("Toreto's cars");

    System.out.println(isHighCcm3.test(toretoCars));
    System.out.println(isHighCcm3.test(noToretoCars));

  }

  static class Car{
    private double ccm3;

    public Car(double ccm3) {
      this.ccm3=ccm3;
    }

    public double getCcm3() {
      return ccm3;
    }

    public void setCcm3(double ccm3) {
      this.ccm3 = ccm3;
    }

    
  }



}
