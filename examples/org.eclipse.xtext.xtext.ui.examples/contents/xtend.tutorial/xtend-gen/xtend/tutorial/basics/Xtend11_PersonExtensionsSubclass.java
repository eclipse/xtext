package xtend.tutorial.basics;

import org.eclipse.xtext.xbase.lib.StringExtensions;
import xtend.tutorial.basics.Xtend11_PersonExtensions;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend11_PersonExtensionsSubclass extends Xtend11_PersonExtensions {
  public String fullName(final Person p) {
    String _name = p.getName();
    String _operator_plus = StringExtensions.operator_plus(_name, ", ");
    String _forename = p.getForename();
    String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _forename);
    return _operator_plus_1;
  }
}
