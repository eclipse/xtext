package xtend.tutorial.basics;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import xtend.tutorial.basics.Xtend11_PersonExtensions;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend11_Modularization {
  /**
   * Other Java or Xtend methods are made accessible by means of an
   * @Inject declaration. If you add the extension keyword the
   * methods can be accessed using the extension syntax.
   * 
   * The nice thing is that you only program against the type
   * signatures but can switch the actual implementation without
   * touching the client code.
   */
  @Inject
  private Xtend11_PersonExtensions extensions;
  
  public void printTheName(final Person person) {
    String _fullName = this.extensions.fullName(person);
    InputOutput.<String>println(_fullName);
  }
}
