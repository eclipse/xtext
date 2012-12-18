/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.compiler.XtendCompilerErrorHandlingTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class XtendCompilerErrorHandlingTest2 extends XtendCompilerErrorHandlingTest {
  @Test
  @Ignore(value = "TODO")
  public void testUnresolvedReturnType() {
    super.testUnresolvedReturnType();
  }
  
  @Test
  @Ignore(value = "TODO")
  public void testFieldInitializerTypeError() {
    super.testFieldInitializerTypeError();
  }
  
  @Test
  @Ignore(value = "TODO")
  public void testFieldInitializerLinkError() {
    super.testFieldInitializerLinkError();
  }
  
  @Test
  @Ignore(value = "TODO")
  public void testMethodBodyTypeError() {
    super.testMethodBodyTypeError();
  }
  
  @Test
  @Ignore(value = "TODO")
  public void testMethodBodyLinkError() {
    super.testMethodBodyLinkError();
  }
}
