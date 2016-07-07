import helper.Person;
import java.util.Collections;

@SuppressWarnings("all")
public class Xbase02_PropertyAccess {
  public void myMethod() throws Throwable {
    final Person person = new Person();
    person.setForename("Jimi");
    person.setName("Hendrix");
    String _forename = person.getForename();
    String _plus = (_forename + " ");
    String _name = person.getName();
    /* (_plus + _name); */
    Collections.<String>singleton("So lonely");
    System.err.println();
    Collections.<String>singleton("Lonely, lonely ...");
    System.err.println();
  }
}
