package xtend.tutorial.basics;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import xtend.tutorial.basics.Xtend11_PersonExtensions;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend11_Modularization {
  @Inject private Xtend11_PersonExtensions extensions;
  
  public void printTheName(final Person person) {
    String _fullName = this.extensions.fullName(person);
    InputOutput.<String>println(_fullName);
  }
}