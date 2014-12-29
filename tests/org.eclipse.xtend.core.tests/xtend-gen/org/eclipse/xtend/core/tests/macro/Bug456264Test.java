/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.tests.macro.AbstractActiveAnnotationTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug456264Test extends AbstractActiveAnnotationTest {
  @Test
  public void testAddError() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@org.eclipse.xtend.core.tests.macro.Bug456264 class C {}");
      _builder.newLine();
      final IAcceptor<XtendCompilerTester.CompilationResult> _function = new IAcceptor<XtendCompilerTester.CompilationResult>() {
        public void accept(final XtendCompilerTester.CompilationResult it) {
          Assert.fail("nothing to assert");
        }
      };
      this._xtendCompilerTester.compile(_builder, _function);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
        String _message = e.getMessage();
        boolean _contains = _message.contains("My error message");
        Assert.assertTrue(_contains);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
