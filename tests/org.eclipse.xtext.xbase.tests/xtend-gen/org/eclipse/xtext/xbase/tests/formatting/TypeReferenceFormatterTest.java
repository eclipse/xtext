package org.eclipse.xtext.xbase.tests.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.tests.formatting.AbstractXbaseFormatterTest;
import org.junit.Test;

@SuppressWarnings("all")
public class TypeReferenceFormatterTest extends AbstractXbaseFormatterTest {
  public void assertTypeRef(final CharSequence toBeFormatted) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var ");
    _builder.append(toBeFormatted, "\t");
    _builder.append(" x");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void simple() {
    this.assertTypeRef("String");
  }
  
  @Test
  public void array1() {
    this.assertTypeRef("String[]");
  }
  
  @Test
  public void array2() {
    this.assertTypeRef("String[][]");
  }
  
  @Test
  public void function0() {
    this.assertTypeRef("=>void");
  }
  
  @Test
  public void function1() {
    this.assertTypeRef("()=>void");
  }
  
  @Test
  public void function2() {
    this.assertTypeRef("(String)=>String");
  }
  
  @Test
  public void function3() {
    this.assertTypeRef("(Collection<?>)=>Collection<?>");
  }
  
  @Test
  public void function4() {
    this.assertTypeRef("(Collection<? extends String>)=>Collection<? extends String>");
  }
  
  @Test
  public void function5() {
    this.assertTypeRef("(String, String)=>String");
  }
  
  @Test
  public void parameters1() {
    this.assertTypeRef("Collection<String>");
  }
  
  @Test
  public void parameters2() {
    this.assertTypeRef("Map<String, String>");
  }
  
  @Test
  public void parametersNested() {
    this.assertTypeRef("Map<Collection<String>, Collection<String>>");
  }
  
  @Test
  public void parametersUpperBound() {
    this.assertTypeRef("Collection<? extends String>");
  }
  
  @Test
  public void parametersLowerBound() {
    this.assertTypeRef("Collection<? super String>");
  }
}
