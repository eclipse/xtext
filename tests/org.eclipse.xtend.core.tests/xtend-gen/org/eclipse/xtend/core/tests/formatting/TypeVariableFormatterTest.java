package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class TypeVariableFormatterTest extends AbstractXtendFormatterTest {
  public CharSequence refToFile(final CharSequence string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(string, "\t");
    _builder.append(" x");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence paramToFile(final CharSequence string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo");
    _builder.append(string, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public void assertTypeParam(final CharSequence toBeFormatted) {
    CharSequence _paramToFile = this.paramToFile(toBeFormatted);
    this.assertFormatted(_paramToFile);
  }
  
  @Test
  public void integration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo<T super Collection<?>, K super Collection<?>> {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new<A super Collection<?>, B super Collection<?>>() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U super Collection<?>, V super Collection<?>> void methode() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void tparam1() {
    this.assertTypeParam("<T>");
  }
  
  @Test
  public void tparam2() {
    this.assertTypeParam("<T, K>");
  }
  
  @Test
  public void tparamUpperBound() {
    this.assertTypeParam("<T extends String>");
  }
  
  @Test
  public void tparamLowerBound() {
    this.assertTypeParam("<T super String>");
  }
  
  @Test
  public void tparamUpperBound2() {
    this.assertTypeParam("<T extends Collection<?>>");
  }
  
  @Test
  public void tparamLowerBound2() {
    this.assertTypeParam("<T super Collection<?>>");
  }
  
  @Test
  public void tparamUpperBound3() {
    this.assertTypeParam("<T extends Collection<?>, K extends Collection<?>>");
  }
  
  @Test
  public void tparamLowerBound3() {
    this.assertTypeParam("<T super Collection<?>, K super Collection<?>>");
  }
  
  @Test
  public void tparamUpperBound4() {
    this.assertTypeParam("<T extends Collection<?> & List<?>>");
  }
}
