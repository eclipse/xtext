package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.junit4.formatter.FormatterTestRequest;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterBugTests extends AbstractXtendFormatterTest {
  @Test
  public void testBug398718() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def testVisibilityOfDispatchMethods() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("```");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("package foo;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public class NoSuchElementException {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("```");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String _decode = this.decode(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.append("class bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def testVisibilityOfDispatchMethods() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("```");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("public class NoSuchElementException {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("```");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    String _decode_1 = this.decode(_builder_1);
    this.assertFormatted(_decode, _decode_1);
  }
  
  @Test
  public void testBug434976() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Baz[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug398625() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def modify(List<? extends MutableMethodDeclaration> annotatedMethods,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ModifyContext context) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setExceptions(\"42\", [])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug398625_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def modify(List<? extends MutableMethodDeclaration> annotatedMethods,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ModifyContext context) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setExceptions(\"42\")[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug398625_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def modify(List<? extends MutableMethodDeclaration> annotatedMethods,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ModifyContext context) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx = context");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("annotatedMethods.forEach [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val type = addTypeParameter(\'A\')");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("addParameter(\'myParam\',");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("compilationUnit.typeReferenceProvider.newTypeReference(type))");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("setExceptions(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("newArrayList(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("compilationUnit.typeReferenceProvider.newTypeReference(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("\'java.lang.Exception\')))[]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug400030() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** foo */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val bar = 3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug400025() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void testBug400025_11() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{ // foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void testBug400025_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* foo");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void testBug400025_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Ignore("Conflict")
  @Test
  public void testBug400025_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val foo = 42");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("val bar = 42");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void testBug400024() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("typeof(XtextAntlrGeneratorFragment).getInstance => [");
    _builder.newLine();
    _builder.append("// \t\t\toptions = new AntlrOptions => [");
    _builder.newLine();
    _builder.append("// \t\t\t\tbacktrack = true");
    _builder.newLine();
    _builder.append("// \t\t\t]");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug400024_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("typeof(XtextAntlrGeneratorFragment).getInstance => [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("/*");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("* Foo.");
    _builder.newLine();
    _builder.append("\t\t\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void testBug455582() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract package class XtendTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static final def void foo() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("  ");
    _builder_1.append("abstract  package  class  XtendTest  {  static  final  def  void  foo  (  )  {  }  }");
    this.assertFormatted(_builder, _builder_1);
  }
  
  @Test
  public void bug462628() {
    final Procedure1<FormatterTestRequest> _function = new Procedure1<FormatterTestRequest>() {
      @Override
      public void apply(final FormatterTestRequest it) {
        final Procedure1<MapBasedPreferenceValues> _function = new Procedure1<MapBasedPreferenceValues>() {
          @Override
          public void apply(final MapBasedPreferenceValues it) {
            it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(120));
          }
        };
        it.preferences(_function);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class Foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("def void format() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("mmmmmmmmmmmmmmmcontainsBlockExprmmmmmmmexprcasesemptymmmmexprmmdefaultmmmmmmmm &&");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("mexprmcasesmexists[multiline] && mexprmmdefaultmmultilineOrInNewLine");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it.setToBeFormatted(_builder);
      }
    };
    this.tester.assertFormatted(_function);
  }
}
