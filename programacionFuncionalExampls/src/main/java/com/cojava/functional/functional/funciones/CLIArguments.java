package functional.funciones;

import java.util.function.Consumer;
import java.util.function.Supplier;


public class CLIArguments {

  private boolean isHelp;

  public boolean isHelp() {
    return isHelp;
  }

  public void setHelp(boolean isHelp) {
    this.isHelp = isHelp;
  }

  public static void main(String[] args) {
    Consumer<Integer> consumer = new Consumer<Integer>(){
      @Override
      public void accept(Integer t) {
        System.out.println("Algo que paso al consumer " + t);
      }
    };

    Supplier<Integer> supplier = new Supplier<Integer>(){
      @Override
      public Integer get() {
        return 1;
      }
    };

    //consumer.accept(supplier.get()); //Esto puede ser confuso creo que esta mal.

    consumer.accept(123);
    

  }
}
