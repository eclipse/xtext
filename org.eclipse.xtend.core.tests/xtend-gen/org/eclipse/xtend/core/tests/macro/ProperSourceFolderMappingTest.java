/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ProperSourceFolderMappingTest extends AbstractActiveAnnotationTest {
  /**
   * checks that the configured target folder matches what is used by the generator.
   * I.e. in case of xtend it is xtend-gen
   */
  @Test
  public void testChangeGeneratedJava() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@org.eclipse.xtend.core.tests.macro.__GeneratedSourceModifingAnnotation");
    _builder.newLine();
    _builder.append("class MyClass {}");
    _builder.newLine();
    final IAcceptor<XtendCompilerTester.CompilationResult> _function = (XtendCompilerTester.CompilationResult it) -> {
    };
    this._xtendCompilerTester.compile(_builder, _function);
  }
}
