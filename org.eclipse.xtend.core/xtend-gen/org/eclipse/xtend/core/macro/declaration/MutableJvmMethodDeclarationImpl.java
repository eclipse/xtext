/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Preconditions;
import org.eclipse.xtend.core.macro.declaration.JvmMethodDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;

@SuppressWarnings("all")
public class MutableJvmMethodDeclarationImpl extends JvmMethodDeclarationImpl implements MutableMethodDeclaration {
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
  
  @Override
  public void setStrictFloatingPoint(final boolean isStrictFloatingPoint) {
    this.checkMutable();
    this.getDelegate().setStrictFloatingPoint(isStrictFloatingPoint);
  }
  
  @Override
  public void setNative(final boolean isNative) {
    this.checkMutable();
    this.getDelegate().setNative(isNative);
  }
  
  @Override
  public void setReturnType(final TypeReference type) {
    this.checkMutable();
    Preconditions.checkArgument((type != null), "returnType cannot be null");
    this.getDelegate().setReturnType(this.getCompilationUnit().toJvmTypeReference(type));
  }
  
  @Override
  public void setAbstract(final boolean isAbstract) {
    this.checkMutable();
    this.getDelegate().setAbstract(isAbstract);
  }
  
  @Override
  public void setFinal(final boolean isFinal) {
    this.checkMutable();
    this.getDelegate().setFinal(isFinal);
  }
  
  @Override
  public void setStatic(final boolean isStatic) {
    this.checkMutable();
    this.getDelegate().setStatic(isStatic);
  }
  
  @Override
  public void setSynchronized(final boolean isSynchronized) {
    this.checkMutable();
    this.getDelegate().setSynchronized(isSynchronized);
  }
  
  @Override
  public void setDefault(final boolean isDefault) {
    this.checkMutable();
    this.getDelegate().setDefault(isDefault);
  }
}
