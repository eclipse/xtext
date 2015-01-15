/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.core.tests.macro.MutableAssert;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

@SuppressWarnings("all")
public class CheckMutableFieldDeclarationProcessor extends AbstractFieldProcessor {
  @Override
  public void doTransform(final MutableFieldDeclaration annotatedField, @Extension final TransformationContext context) {
    final Procedure0 _function = new Procedure0() {
      @Override
      public void apply() {
        annotatedField.setInitializer(((CompilationStrategy) null));
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "initializer cannot be null", _function);
    final Procedure0 _function_1 = new Procedure0() {
      @Override
      public void apply() {
        annotatedField.setType(null);
      }
    };
    MutableAssert.<IllegalArgumentException>assertThrowable(IllegalArgumentException.class, "type cannot be null", _function_1);
  }
}
