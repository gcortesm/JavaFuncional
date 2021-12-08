package functional.funciones;

import java.util.Arrays;
import java.util.List;

public class Sintaxis {
  public static void main(String[] args) {
    //Sintaxis de una lambda.
    List<String> lista = Arrays.asList("Gustavo","Adolfo","Cortes","Mondragon");

    lista.forEach(System.out::println);

    lista.forEach(item->System.out.println(item));
     

  }
}
