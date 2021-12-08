package functional.mutable;

import java.util.*;

public class MutablePerson {

  private String name;
  private String lastName;
  private List<String> emails;

  public MutablePerson(String name, String lastName, List<String> emails) {
    this.name = name;
    this.lastName = lastName;
    this.emails = emails;  
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

}
