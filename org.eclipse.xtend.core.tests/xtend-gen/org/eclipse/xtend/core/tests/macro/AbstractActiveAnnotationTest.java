/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import com.google.inject.Inject;
import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public abstract class AbstractActiveAnnotationTest extends AbstractXtendTestCase {
  @Extension
  protected XtendCompilerTester _xtendCompilerTester;

  @Inject
  public void doInject(final XtendCompilerTester compilerTester) {
    this._xtendCompilerTester = compilerTester;
    this._xtendCompilerTester.setJavaCompilerClassPath(this.getClass().getClassLoader());
  }
}
