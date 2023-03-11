/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug456264Test extends AbstractActiveAnnotationTest {
  @Test
  public void testAddError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.Bug456264 class C {}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
      final List<? extends Problem> problems = it.getAllProblems();
      final Function1<Problem, String> _function_1 = (Problem it_1) -> {
        return it_1.getMessage();
      };
      Assert.assertEquals(ListExtensions.map(problems, _function_1).toString(), 1, problems.size());
      Assert.assertEquals("My error message", IterableExtensions.head(problems).getMessage());
      final List<? extends Problem> specificProblems = it.getProblems(IterableExtensions.head(it.getCompilationUnit().getSourceTypeDeclarations()));
      Assert.assertEquals(specificProblems.toString(), 1, problems.size());
      Assert.assertEquals("My error message", IterableExtensions.head(specificProblems).getMessage());
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
