package xtend.tutorial.basics;

import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend08_RichStrings extends TestCase {
  public void testRichStrings() {
    Person _person = new Person("Joe", "Developer");
    StringConcatenation _writeLetterTo = this.writeLetterTo(_person);
    InputOutput.<StringConcatenation>println(_writeLetterTo);
  }
  
  /**
   * Rich strings are a special feature for readable code
   * concatenation. They support a unique automatic indentation
   * handling, which is also refelected tooling-wise.
   * Note the indentation before the call to signature.
   */
  public StringConcatenation writeLetterTo(final Person p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Dear ");
    String _forename = p.getForename();
    _builder.append(_forename, "");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("bla bla foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Yours sincerely,");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Joe Developer");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    StringConcatenation _signature = this.signature();
    _builder.append(_signature, "	");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation signature() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Bla bla Foo Bar");
    _builder.newLine();
    _builder.append("(c) 2011 - all rights reserved");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("- note the multiline, and the correct indentation -");
    _builder.newLine();
    return _builder;
  }
}
