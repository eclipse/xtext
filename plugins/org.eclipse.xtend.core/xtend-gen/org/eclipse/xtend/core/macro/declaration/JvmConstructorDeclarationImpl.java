/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmExecutableDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtext.common.types.JvmConstructor;

@SuppressWarnings("all")
public class JvmConstructorDeclarationImpl extends JvmExecutableDeclarationImpl<JvmConstructor> implements MutableConstructorDeclaration {
  public String getSimpleName() {
    MutableTypeDeclaration _declaringType = this.getDeclaringType();
    return _declaringType.getSimpleName();
  }
}
