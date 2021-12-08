package functional.funciones;

public class Chainer {
  
  public static void main(String[] args) {
    Say saludador = new Say();
    saludador.hello().adios();
  }

  static class Say{

    public Say hello(){
      System.out.println("Saludando");
      return this;
    }

    public Say adios(){
      System.out.println("Despidiendome");
      return this;
    }
  }

}
