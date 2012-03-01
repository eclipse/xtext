package xtend.tutorial.basics;

import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend11_PersonExtensions {
  public String fullName(final Person p) {
    String _forename = p.getForename();
    String _plus = (_forename + " ");
    String _name = p.getName();
    String _plus_1 = (_plus + _name);
    return _plus_1;
  }
}
