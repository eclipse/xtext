/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("https://github.com/eclipse/xtext-xtend/issues/6")
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
      List<String> _map = ListExtensions.map(problems, _function_1);
      String _string = _map.toString();
      int _size = problems.size();
      Assert.assertEquals(_string, 1, _size);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Error during annotation processing:");
      _builder_1.newLine();
      _builder_1.append("java.lang.LinkageError: Just a test :-/");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("at org.eclipse.xtend.core.tests.macro.Bug464136Processor$1.apply(Bug464136Processor.java:23)");
      _builder_1.newLine();
      String _string_1 = _builder_1.toString();
      Problem _head = IterableExtensions.head(problems);
      String _message = _head.getMessage();
      Assert.assertEquals(_string_1, _message);
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
