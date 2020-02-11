/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.ValidationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class Bug456264Processor extends AbstractClassProcessor {
  @Override
  public void doValidate(final ClassDeclaration annotatedClass, @Extension final ValidationContext context) {
    context.addError(annotatedClass, "My error message");
  }
}
