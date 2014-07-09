/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMethodDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;

@SuppressWarnings("all")
public class MutableJvmMethodDeclarationImpl extends JvmMethodDeclarationImpl implements MutableMethodDeclaration {
  public void markAsRead() {
    this.checkMutable();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmOperation _delegate = this.getDelegate();
    _readAndWriteTracking.markReadAccess(_delegate);
  }
  
  public Iterable<? extends MutableParameterDeclaration> getParameters() {
    Iterable<? extends ParameterDeclaration> _parameters = super.getParameters();
    return ((Iterable<? extends MutableParameterDeclaration>) _parameters);
  }
  
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    Iterable<? extends TypeParameterDeclaration> _typeParameters = super.getTypeParameters();
    return ((Iterable<? extends MutableTypeParameterDeclaration>) _typeParameters);
  }
  
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
  
  public void setStrictFloatingPoint(final boolean isStrictFloatingPoint) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setStrictFloatingPoint(isStrictFloatingPoint);
  }
  
  public void setNative(final boolean isNative) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setNative(isNative);
  }
  
  public void setReturnType(final TypeReference type) {
    this.checkMutable();
    boolean _notEquals = (!Objects.equal(type, null));
    Preconditions.checkArgument(_notEquals, "returnType cannot be null");
    JvmOperation _delegate = this.getDelegate();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(type);
    _delegate.setReturnType(_jvmTypeReference);
  }
  
  public void setAbstract(final boolean isAbstract) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setAbstract(isAbstract);
  }
  
  public void setFinal(final boolean isFinal) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  public void setStatic(final boolean isStatic) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  public void setSynchronized(final boolean isSynchronized) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setSynchronized(isSynchronized);
  }
  
  public void setDefault(final boolean isDefault) {
    this.checkMutable();
    JvmOperation _delegate = this.getDelegate();
    _delegate.setDefault(isDefault);
  }
}
