import helper.Person;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xbase02_PropertyAccess {
  public static void main(final String[] args) {
    try {
    	Person _person = new Person();
    	final Person person = _person;
    	person.setForename("Jimi");
    	person.setName("Hendrix");
    	String _forename = person.getForename();
    	String _operator_plus = StringExtensions.operator_plus(_forename, " ");
    	String _name = person.getName();
    	StringExtensions.operator_plus(_operator_plus, _name);
    } catch (Throwable t) {}
  }
}
