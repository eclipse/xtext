/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.GeneratedExecutableDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.GeneratedConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmConstructor;

@SuppressWarnings("all")
public class GeneratedConstructorDeclarationImpl extends GeneratedExecutableDeclarationImpl<JvmConstructor> implements GeneratedConstructorDeclaration {
  public String getName() {
    GeneratedTypeDeclaration _declaringType = this.getDeclaringType();
    String _simpleName = _declaringType.getSimpleName();
    return _simpleName;
  }
  
  public Expression getBody() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
