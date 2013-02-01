package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendCompilerTest extends AbstractXtendCompilerTest {
  @Ignore(value = "Fails with old impl")
  @Test
  public void testBug391077() {
    super.testBug391077();
  }
  
  @Ignore(value = "Fails with old impl")
  @Test
  public void testAnnotationWithIntArray() throws Exception {
    super.testAnnotationWithIntArray();
  }
  
  @Ignore(value = "Fails with old impl")
  @Test
  public void testStaticMethod_02() {
    super.testStaticMethod_02();
  }
  
  @Ignore(value = "Fails with old impl")
  @Test
  public void testInstanceMethod() {
    super.testInstanceMethod();
  }
  
  @Ignore(value = "Fails with old impl")
  @Test
  public void testClosureSneakyThrow_02() {
    try {
      super.testClosureSneakyThrow_02();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Refined questionable expectation.
   */
  @Test
  public void testRichStringNoAutoConversionToString_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend2.lib.StringConcatenation;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void test() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("StringConcatenation _builder = new StringConcatenation();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_builder.append(\"SomeString\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("System.out.println(_builder.toString());");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertCompilesTo(
      "class Foo { def test(){ System::out.println(\'\'\'SomeString\'\'\') } }", _builder);
  }
  
  /**
   * Refined questionable expectation.
   */
  @Test
  public void testRichStringNoAutoConversionToString_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend2.lib.StringConcatenation;");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.xbase.lib.InputOutput;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("public class Foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void test() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("StringConcatenation _builder = new StringConcatenation();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("_builder.append(\"SomeString\");");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String _println = InputOutput.<String>println(_builder.toString());");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("System.out.println(_println);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertCompilesTo(
      "class Foo { def test(){ System::out.println(println(\'\'\'SomeString\'\'\')) } }", _builder);
  }
}
