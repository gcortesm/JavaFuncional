package functional.funciones;

public class Default {
  

  @FunctionalInterface
  interface DefaultInterface{
    int getValue();

    default void operate(){
      Integer value = getValue();
      while(value-- > 0){
        System.out.println("Algo desde aca por default");
      }
    }
  }


  public static void main(String[] args) {
    DefaultInterface inter = () -> 6;
    inter.operate();
  }

}
