package functional;

import java.util.Arrays;
import java.util.List;

import functional.mutable.MutablePerson;

public class Application {
  public static void main(String[] args) {

    List<String> emails =Arrays.asList(
      "Gustavo.cortesm@hotmail.com",
      "cortes@gmail.com");
   MutablePerson person = new MutablePerson("Gustavo","Cortes",emails); 

    System.out.println(person.getEmails());
    badActions(person);
    System.out.println(person.getEmails());
  }

  public static void badActions(MutablePerson persons) {
    persons.setEmails(Arrays.asList("bademail@String.com")); 
  }
}
