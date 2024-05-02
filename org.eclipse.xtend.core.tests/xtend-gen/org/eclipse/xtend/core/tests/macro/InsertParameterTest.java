/**
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Didier Vojtisek - Initial contribution and API
 */
@SuppressWarnings("all")
public class InsertParameterTest extends AbstractActiveAnnotationTest {
  @Test
  public void testInsertIndex0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno(classRef=String) ");
    _builder.newLine();
    _builder.append("class MyStringHelper {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def String concat(String stringParam_1) {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("_self.concat(stringParam_1) ");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("static def String concat2(String stringParam_1, String stringParam_2) {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("_self + stringParam_1 + stringParam_2");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@InsertParameterMiniHelperAnno(classRef = String.class)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyStringHelper {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static String concat(final String _self, final String stringParam_1) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _self.concat(stringParam_1);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static String concat2(final String _self, final String stringParam_1, final String stringParam_2) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ((_self + stringParam_1) + stringParam_2);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testInsertIndex1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno(classRef=String, position=1) ");
    _builder.newLine();
    _builder.append("class MyStringHelper {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def String concat(String stringParam_1) {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("_self.concat(stringParam_1) ");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("static def String concat2(String stringParam_1, String stringParam_2) {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("_self + stringParam_1 + stringParam_2");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@InsertParameterMiniHelperAnno(classRef = String.class, position = 1)");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class MyStringHelper {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static String concat(final String stringParam_1, final String _self) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _self.concat(stringParam_1);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public static String concat2(final String stringParam_1, final String _self, final String stringParam_2) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return ((_self + stringParam_1) + stringParam_2);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this._xtendCompilerTester.assertCompilesTo(_builder, _builder_1);
  }

  @Test
  public void testInsertIndexOutOfBound() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.InsertParameterMiniHelperAnno(classRef=String, position=2) ");
    _builder.newLine();
    _builder.append("class MyStringHelper {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static def String concat(String stringParam_1) {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("_self.concat(stringParam_1) ");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("static def String concat2(String stringParam_1, String stringParam_2) {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    _builder.append("_self + stringParam_1 + stringParam_2");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final List<? extends Problem> problems = it.getAllProblems();
      final Function1<Problem, String> _function_1 = (Problem it_1) -> {
        return it_1.getMessage();
      };
      Assert.assertEquals(ListExtensions.map(problems, _function_1).toString(), 1, problems.size());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Error during annotation processing:");
      _builder_1.newLine();
      _builder_1.append("\t\t\t\t");
      _builder_1.append("org.eclipse.emf.common.util.AbstractEList$BasicIndexOutOfBoundsException: index=2, size=1");
      _builder_1.newLine();
      final String messageJava = _builder_1.toString();
      boolean _startsWith = IterableExtensions.head(problems).getMessage().startsWith(messageJava);
      if (_startsWith) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Expected the following problem message:");
        _builder_2.newLine();
        _builder_2.newLine();
        _builder_2.append(messageJava);
        _builder_2.newLineIfNotEmpty();
        _builder_2.newLine();
        _builder_2.append("But got:");
        _builder_2.newLine();
        _builder_2.newLine();
        String _message = IterableExtensions.head(problems).getMessage();
        _builder_2.append(_message);
        _builder_2.newLineIfNotEmpty();
        Assert.fail(_builder_2.toString());
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
