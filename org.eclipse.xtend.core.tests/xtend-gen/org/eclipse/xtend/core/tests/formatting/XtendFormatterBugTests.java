/**
 * Copyright (c) 2013, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.formatting;

import java.util.function.Consumer;
import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendFormatterBugTests extends AbstractXtendFormatterTest {
  @Test
  public void testCoreIssue527_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static SUPER_LONG_LIST_TO_TEST_IF_FORMATTING_WORKS_HERE_AND_SUCH = #[]");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def fn() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return SUPER_LONG_LIST_TO_TEST_IF_FORMATTING_WORKS_HERE_AND_SUCH.map [ l |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("SUPER_LONG_LIST_TO_TEST_IF_FORMATTING_WORKS_HERE_AND_SUCH");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void testtestCoreIssue527_02() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class ModuleDeclaration {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<Object> moduleComponents");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class AbstractTypeDeclaration {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class AliasDeclaration extends AbstractTypeDeclaration {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class JavaGenerator {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void generateCommon(String projectSourceRootPath,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("ModuleDeclaration module) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (element : module.moduleComponents.filter(AbstractTypeDeclaration).");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("filter [ e |");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("!(e instanceof AliasDeclaration)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("]) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setToBeFormatted(_builder);
    };
    this.formatterTestHelper.assertFormatted(_function);
  }

  @Test
  public void testBug402917_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Dully {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated extension IntegerExtensions y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated extension IntegerExtensions x");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def all(@Deprecated extension IntegerExtensions x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension IntegerExtensions foo = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val c = [ extension IntegerExtensions p |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("123.bitwiseAnd(1)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void testBug402917_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Dully {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("IntegerExtensions y");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated   extension    IntegerExtensions x");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def all(@Deprecated   extension    IntegerExtensions x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension    IntegerExtensions foo = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val c = [ extension    IntegerExtensions p |");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("123.bitwiseAnd(1)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def all2(   extension  @Deprecated  IntegerExtensions x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class Dully {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Deprecated");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("extension IntegerExtensions y");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Deprecated extension IntegerExtensions x");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def all(@Deprecated extension IntegerExtensions x) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val extension IntegerExtensions foo = null");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val c = [ extension IntegerExtensions p |");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("123.bitwiseAnd(1)");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("]");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def all2(extension @Deprecated IntegerExtensions x) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedTo(_builder, _builder_1);
  }

  @Test
  public void testBug398718() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def testVisibilityOfDispatchMethods() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("```");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("package foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@SuppressWarnings(\"all\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public class NoSuchElementException {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("```");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("class bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def testVisibilityOfDispatchMethods() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("```");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("public class NoSuchElementException {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.newLine();
    _builder_1.append("\t\t\t  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("```");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedTo(this.decode(_builder), this.decode(_builder_1));
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
    this.assertUnformattedEqualsFormatted(_builder);
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
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
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
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
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
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
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
    this.assertUnformattedEqualsFormatted(_builder);
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
    this.assertUnformattedEqualsFormatted(_builder);
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
    this.assertUnformattedEqualsFormatted(_builder);
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
    this.assertUnformattedEqualsFormatted(_builder);
  }

  @Test
  public void testBug_xtext_xtend_194() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static val SOME_MULTI_LINE_THINGY = new StringBuilder(\'a\').append(\'b\').");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("append(\'c\').append(\'d\').append(\'e\').append(\'f\').append(\'g\').append(\'h\').");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("append(\'i\').append(\'j\').append(\'k\').append(\'l\').append(\'m\').toString;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var bar = new Object");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(80));
    };
    this.assertUnformattedEqualsFormatted(_builder, _function);
  }

  @Test
  public void testBug455582() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract  package  class  XtendTest  {  static  final  def  void  foo  (  )  {  }  }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("abstract package class XtendTest {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("static final def void foo() {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Consumer<MapBasedPreferenceValues> _function = (MapBasedPreferenceValues it) -> {
      it.<Boolean>put(XtendFormatterPreferenceKeys.keepOneLineMethods, Boolean.valueOf(false));
    };
    this.assertFormattedTo(_builder, _builder_1, _function);
  }

  @Test
  public void bug462628() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(120));
      };
      it.preferences(_function_1);
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
    };
    this.formatterTestHelper.assertFormatted(_function);
  }

  @Test
  public void bug403823() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(120));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void format(String a, String b, String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (a != b)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("(");
      _builder.append("«", "\t\t\t");
      _builder.append("c");
      _builder.append("»", "\t\t\t");
      _builder.append(")");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("else");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setToBeFormatted(_builder);
    };
    this.formatterTestHelper.assertFormatted(_function);
  }

  @Test
  public void bug403823_1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(120));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void format(String a, String b, String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (a != b) ");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("(");
      _builder.append("«", "\t\t");
      _builder.append("c");
      _builder.append("»", "\t\t");
      _builder.append(")");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append(" else \'\'");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setToBeFormatted(_builder);
    };
    this.formatterTestHelper.assertFormatted(_function);
  }

  @Test
  public void bug403340() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(120));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void format(String v1, String v2) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (v1 === v2)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("Same");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("else");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("Not the Same");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.append("\'", "\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setToBeFormatted(_builder);
    };
    this.formatterTestHelper.assertFormatted(_function);
  }

  @Test
  public void bug403340_1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(120));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void format(String v1, String v2) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (v1 === v2) ");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("Same");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append(" else ");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("Not the Same");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.append("\'", "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setToBeFormatted(_builder);
    };
    this.formatterTestHelper.assertFormatted(_function);
  }
}
