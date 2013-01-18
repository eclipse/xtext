/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmExecutableDeclarationImpl;
import org.eclipse.xtend.lib.macro.CompilationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class JvmConstructorDeclarationImpl extends JvmExecutableDeclarationImpl<JvmConstructor> implements MutableConstructorDeclaration {
  public String getName() {
    MutableTypeDeclaration _declaringType = this.getDeclaringType();
    String _simpleName = _declaringType.getSimpleName();
    return _simpleName;
  }
  
  public Expression getBody() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void setBody(final Function1<? super CompilationContext,? extends CharSequence> compilationStrategy) {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmConstructor _delegate = this.getDelegate();
    _compilationUnit.setCompilationStrategy(_delegate, compilationStrategy);
  }
}
