package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class XtypeFormatterTest extends AbstractFormatterTest {
  public CharSequence refToFile(final CharSequence string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(string, "	");
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
  
  public void assertTypeRef(final CharSequence expectation, final CharSequence toBeFormatted) {
    CharSequence _refToFile = this.refToFile(expectation);
    CharSequence _refToFile_1 = this.refToFile(toBeFormatted);
    this.assertFormatted(_refToFile, _refToFile_1);
  }
  
  public void assertTypeParam(final CharSequence expectation, final CharSequence toBeFormatted) {
    CharSequence _paramToFile = this.paramToFile(expectation);
    CharSequence _paramToFile_1 = this.paramToFile(toBeFormatted);
    this.assertFormatted(_paramToFile, _paramToFile_1);
  }
  
  @Test
  public void integration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("abstract class Foo extends AbstractList<String> implements List<String>, Collection<String> {");
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
    _builder.append("val featureCall2 = <String, String>newHashMap");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val memberFeatureCall1 = featureCall1.<String>toList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val memberFeatureCall2 = featureCall1.<String, String>toMap[it]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val constructorCallTypes = new ArrayList<String>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val closure1 = [Collection<String> x|x]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val closure2 = [Collection<String> x, Collection<String> y|x]");
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
    this.assertTypeRef("String", "String");
  }
  
  @Test
  public void array1() {
    this.assertTypeRef("String[]", "String  []");
  }
  
  @Test
  public void array2() {
    this.assertTypeRef("String[][]", "String  []  []");
  }
  
  @Test
  public void function0() {
    this.assertTypeRef("=>void", "=>  void");
  }
  
  @Test
  public void function1() {
    this.assertTypeRef("()=>void", "(  )  =>  void");
  }
  
  @Test
  public void function2() {
    this.assertTypeRef("(String)=>String", "(  String  )  =>  String");
  }
  
  @Test
  public void function3() {
    this.assertTypeRef("(Collection<?>)=>Collection<?>", "(  Collection  <  ?  >  )  =>  Collection  <  ?  >");
  }
  
  @Test
  public void function4() {
    this.assertTypeRef("(Collection<? extends String>)=>Collection<? extends String>", 
      "(  Collection  <  ?  extends  String  >  )  =>  Collection  <  ?  extends  String  >");
  }
  
  @Test
  public void function5() {
    this.assertTypeRef("(String, String)=>String", "(  String  ,  String)  =>  String");
  }
  
  @Test
  public void parameters1() {
    this.assertTypeRef("Collection<String>", "Collection  <  String  >");
  }
  
  @Test
  public void parameters2() {
    this.assertTypeRef("Map<String, String>", "Map  <  String  , String  >");
  }
  
  @Test
  public void parametersNested() {
    this.assertTypeRef("Map<Collection<String>, Collection<String>>", 
      "Map  <  Collection  <  String  >  , Collection  <  String  >  >");
  }
  
  @Test
  public void parametersUpperBound() {
    this.assertTypeRef("Collection<? extends String>", "Collection  <  ?  extends  String  >");
  }
  
  @Test
  public void parametersLowerBound() {
    this.assertTypeRef("Collection<? super String>", "Collection  <  ?  super  String  >");
  }
}
