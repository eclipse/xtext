package xtend.tutorial.basics;

import xtend.tutorial.basics.Xtend11_PersonExtensions;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend11_PersonExtensionsSubclass extends Xtend11_PersonExtensions {
  public String fullName(final Person p) {
    String _name = p.getName();
    String _plus = (_name + ", ");
    String _forename = p.getForename();
    String _plus_1 = (_plus + _forename);
    return _plus_1;
  }
}
