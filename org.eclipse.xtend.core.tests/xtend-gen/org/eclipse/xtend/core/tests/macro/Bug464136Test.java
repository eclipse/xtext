/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import java.util.Objects;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class Bug464136Test extends AbstractActiveAnnotationTest {
  @Test
  public void testThrownErrorInPreValidation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.Bug464136 class C {}");
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
      _builder_1.append("java.lang.LinkageError: Just a test :-/");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("at org.eclipse.xtend.core.tests.macro.Bug464136Processor.lambda$doTransform$0(Bug464136Processor.java:22)");
      _builder_1.newLine();
      final String messageJava = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Error during annotation processing:");
      _builder_2.newLine();
      _builder_2.append("java.lang.LinkageError: Just a test :-/");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("at org.eclipse.xtend.core.tests.macro.Bug464136Processor.lambda$0(Bug464136Processor.java:22)");
      _builder_2.newLine();
      final String messageEclipse = _builder_2.toString();
      if (((!Objects.equals(messageJava, IterableExtensions.head(problems).getMessage())) && (!Objects.equals(messageEclipse, IterableExtensions.head(problems).getMessage())))) {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("Expected one of the following problem messages:");
        _builder_3.newLine();
        _builder_3.newLine();
        _builder_3.append(messageJava);
        _builder_3.newLineIfNotEmpty();
        _builder_3.newLine();
        _builder_3.append(messageEclipse);
        _builder_3.newLineIfNotEmpty();
        _builder_3.newLine();
        _builder_3.append("But got:");
        _builder_3.newLine();
        _builder_3.newLine();
        String _message = IterableExtensions.head(problems).getMessage();
        _builder_3.append(_message);
        _builder_3.newLineIfNotEmpty();
        Assert.fail(_builder_3.toString());
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
