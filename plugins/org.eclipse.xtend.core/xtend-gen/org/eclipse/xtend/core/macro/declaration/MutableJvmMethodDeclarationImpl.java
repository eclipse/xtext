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
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class MutableJvmMethodDeclarationImpl extends JvmMethodDeclarationImpl implements MutableMethodDeclaration {
  public Iterable<? extends MutableParameterDeclaration> getParameters() {
    Iterable<? extends ParameterDeclaration> _parameters = super.getParameters();
    return ((Iterable<? extends MutableParameterDeclaration>) _parameters);
  }
  
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    Iterable<? extends TypeParameterDeclaration> _typeParameters = super.getTypeParameters();
    return ((Iterable<? extends MutableTypeParameterDeclaration>) _typeParameters);
  }
  
  public MutableAnnotationReference findAnnotation(final Type annotationType) {
    AnnotationReference _findAnnotation = super.findAnnotation(annotationType);
    return ((MutableAnnotationReference) _findAnnotation);
  }
  
  public Iterable<? extends MutableAnnotationReference> getAnnotations() {
    Iterable<? extends AnnotationReference> _annotations = super.getAnnotations();
    return ((Iterable<? extends MutableAnnotationReference>) _annotations);
  }
  
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
  
  public void setStrictFloatingPoint(final boolean isStrictFloatingPoint) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setStrictFloatingPoint(isStrictFloatingPoint);
  }
  
  public void setNative(final boolean isNative) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setNative(isNative);
  }
  
  public void setReturnType(final TypeReference type) {
    boolean _notEquals = (!Objects.equal(type, null));
    Preconditions.checkArgument(_notEquals, "returnType cannot be null");
    JvmOperation _delegate = this.getDelegate();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(type);
    _delegate.setReturnType(_jvmTypeReference);
  }
  
  public void setAbstract(final boolean isAbstract) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setAbstract(isAbstract);
  }
  
  public void setFinal(final boolean isFinal) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  public void setStatic(final boolean isStatic) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  public void setSynchronized(final boolean isSynchronized) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setSynchronized(isSynchronized);
  }
  
  public void setDefault(final boolean isDefault) {
    JvmOperation _delegate = this.getDelegate();
    _delegate.setDefault(isDefault);
  }
}
