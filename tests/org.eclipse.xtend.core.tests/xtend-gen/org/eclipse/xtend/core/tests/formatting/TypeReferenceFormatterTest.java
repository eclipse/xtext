package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class TypeReferenceFormatterTest extends AbstractFormatterTest {
  public void assertTypeRef(final CharSequence toBeFormatted) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(toBeFormatted, "	");
    _builder.append(" x");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void integration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Foo extends AbstractMap<String, Collection<?>> implements List<String>, Map<String, Collection<?>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String[] field");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String[] methode(String[] param) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val String[] valTypes = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val featureCall1 = <String>newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val featureCall2 = <String, Collection<?>>newHashMap");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val memberFeatureCall1 = featureCall1.<String>toList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val memberFeatureCall2 = featureCall1.<String, Collection<?>>toMap[it]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val constructorCall1 = new ArrayList<String>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val constructorCall2 = new HashMap<String, Collection<?>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val slclosure1 = [Collection<String> x|x]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val slclosure2 = [Collection<String> x, Map<String, Collection<?>> y|x]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val mlclosure1 = [ Collection<String> x |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val mlclosure2 = [ Collection<String> x, Map<String, Collection<?>> y |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("x");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
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
