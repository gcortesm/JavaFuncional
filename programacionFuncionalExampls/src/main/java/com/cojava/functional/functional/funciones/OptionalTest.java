package functional.funciones;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        //System.out.println(unTexto().length());
        //Este nos da un nullPointe
        nameReturn().ifPresent(texto -> System.out.println(texto));
        if(nameReturn().isPresent()){
            System.out.println("Encontramos el valor");
        }
        nameReturn().flatMap((s) -> Optional.of(s.toUpperCase())).ifPresent(System.out::println);

        nameReturn().orElseGet( () ->"Invalid Value");
    }

    public static String unTexto(){
        return null;
    }
    public static Optional<String> nameReturn(){
            if(false){
                return Optional.of("Gustavo desde optional");
            }
        return Optional.empty();
    }
}
