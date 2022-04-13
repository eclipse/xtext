/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;

@SuppressWarnings("all")
public class MutableJvmConstructorDeclarationImpl extends JvmConstructorDeclarationImpl implements MutableConstructorDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
  }

  @Override
  public Iterable<? extends MutableParameterDeclaration> getParameters() {
    Iterable<? extends ParameterDeclaration> _parameters = super.getParameters();
    return ((Iterable<? extends MutableParameterDeclaration>) _parameters);
  }

  @Override
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    Iterable<? extends TypeParameterDeclaration> _typeParameters = super.getTypeParameters();
    return ((Iterable<? extends MutableTypeParameterDeclaration>) _typeParameters);
  }

  @Override
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
}
