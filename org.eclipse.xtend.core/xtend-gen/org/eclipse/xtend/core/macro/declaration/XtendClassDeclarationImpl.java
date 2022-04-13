/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtendClassDeclarationImpl extends XtendTypeDeclarationImpl<XtendClass> implements ClassDeclaration {
  @Override
  public Iterable<? extends TypeReference> getImplementedInterfaces() {
    final Function1<JvmTypeReference, TypeReference> _function = (JvmTypeReference it) -> {
      return this.getCompilationUnit().toTypeReference(it);
    };
    return ListExtensions.<JvmTypeReference, TypeReference>map(this.getDelegate().getImplements(), _function);
  }

  @Override
  public TypeReference getExtendedClass() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getExtends());
  }

  @Override
  public boolean isAbstract() {
    return this.getDelegate().isAbstract();
  }

  @Override
  public boolean isFinal() {
    return this.getDelegate().isFinal();
  }

  @Override
  public boolean isStatic() {
    return true;
  }

  @Override
  public boolean isStrictFloatingPoint() {
    return false;
  }

  @Override
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    final Function1<JvmTypeParameter, XtendTypeParameterDeclarationImpl> _function = (JvmTypeParameter it) -> {
      return this.getCompilationUnit().toXtendTypeParameterDeclaration(it);
    };
    return ListExtensions.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>map(this.getDelegate().getTypeParameters(), _function);
  }
}
