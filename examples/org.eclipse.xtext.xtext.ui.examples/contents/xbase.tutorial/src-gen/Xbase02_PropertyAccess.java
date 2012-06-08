import helper.Person;
import java.util.Collections;

@SuppressWarnings("all")
public class Xbase02_PropertyAccess {
  public static void main(final String[] args) {
    try {
        Person _person = new Person();
        final Person person = _person;
        person.setForename("Jimi");
        person.setName("Hendrix");
        String _forename = person.getForename();
        String _plus = (_forename + " ");
        String _name = person.getName();
        /*(_plus + _name);*/
        Collections.<String>singleton("So lonely");
        System.err.println();
    } catch (Throwable t) {}
  }
}
