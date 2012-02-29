package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.tests.compiler.AbstractOutputComparingCompilerTests;
import org.junit.Test;

@SuppressWarnings("all")
public class CompilerTests2 extends AbstractOutputComparingCompilerTests {
  @Test
  public void testVariableDeclaration() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = 42");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final int x = 42;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testVariableDeclaration1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = \'foo\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = a");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final String a = \"foo\";");
    _builder_1.newLine();
    _builder_1.append("final String x = a;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testVariableDeclaration2() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val x = \'foo\'.toUpperCase");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("final String x = \"foo\".toUpperCase();");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug367144() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo::bar::SubOfClassWithStatics::MY_STATIC_FIELD");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("return foo.bar.SubOfClassWithStatics.MY_STATIC_FIELD;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug367144_1() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo::bar::SubOfClassWithStatics::MY_STATIC_METHOD");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("String _MY_STATIC_METHOD = foo.bar.SubOfClassWithStatics.MY_STATIC_METHOD();");
    _builder_1.newLine();
    _builder_1.append("return _MY_STATIC_METHOD;");
    _builder_1.newLine();
    this.compilesTo(_builder, _builder_1);
  }
}
