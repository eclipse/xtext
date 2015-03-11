/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.List;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.services.Problem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug456264Test extends AbstractActiveAnnotationTest {
  @Test
  public void testAddError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.Bug456264 class C {}");
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
        Problem _head = IterableExtensions.head(problems);
        String _message = _head.getMessage();
        Assert.assertEquals("My error message", _message);
        CompilationUnit _compilationUnit = it.getCompilationUnit();
        Iterable<? extends TypeDeclaration> _sourceTypeDeclarations = _compilationUnit.getSourceTypeDeclarations();
        TypeDeclaration _head_1 = IterableExtensions.head(_sourceTypeDeclarations);
        final List<? extends Problem> specificProblems = it.getProblems(_head_1);
        String _string_1 = specificProblems.toString();
        int _size_1 = problems.size();
        Assert.assertEquals(_string_1, 1, _size_1);
        Problem _head_2 = IterableExtensions.head(specificProblems);
        String _message_1 = _head_2.getMessage();
        Assert.assertEquals("My error message", _message_1);
      }
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
