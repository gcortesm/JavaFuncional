package functional.funciones;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {


    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Gustavo","Adolfo","Cortes","Mondragon");
        nombres.stream().forEach(System.out::println);
        Stream<String> courses = Stream.of("Matematicas","español", "Ingles", "Quimica","otra");
        courses.map(e->e.toUpperCase()).forEach(System.out::println);
        Stream<Integer> length = courses.map(s -> s.length());
        Optional<Integer> posibleMaximo = length.max((x, y) -> x - y);
        posibleMaximo.ifPresent(n -> System.out.println(n));



    }
}
