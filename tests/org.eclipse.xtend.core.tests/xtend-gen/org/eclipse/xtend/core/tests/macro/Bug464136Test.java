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
import org.junit.Test;

@SuppressWarnings("all")
public class Bug464136Test extends AbstractActiveAnnotationTest {
  @Test
  public void testThrownErrorInPreValidation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.Bug464136 class C {}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = new IAcceptor<XtendCompilerTester.CompilationResult>() {
      @Override
      public void accept(final XtendCompilerTester.CompilationResult it) {
        final List<? extends Problem> problems = it.getAllProblems();
        final Function1<Problem, String> _function = new Function1<Problem, String>() {
          @Override
          public String apply(final Problem it) {
            return it.getMessage();
          }
        };
        List<String> _map = ListExtensions.map(problems, _function);
        String _string = _map.toString();
        int _size = problems.size();
        Assert.assertEquals(_string, 1, _size);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Error during annotation processing:");
        _builder.newLine();
        _builder.append("java.lang.LinkageError: Just a test :-/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("at org.eclipse.xtend.core.tests.macro.Bug464136Processor$1.apply(Bug464136Processor.java:23)");
        _builder.newLine();
        String _string_1 = _builder.toString();
        Problem _head = IterableExtensions.head(problems);
        String _message = _head.getMessage();
        Assert.assertEquals(_string_1, _message);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
