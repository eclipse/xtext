/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeParameterDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class JvmTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements MutableAnnotationTarget, MutableTypeParameterDeclaration {
  public MutableTypeParameterDeclarator getTypeParameterDeclarator() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(((JvmExecutable) _eContainer));
    return ((MutableTypeParameterDeclarator) _memberDeclaration);
  }
  
  public void setName(final String name) {
    JvmTypeParameter _delegate = this.getDelegate();
    _delegate.setName(name);
  }
  
  public void remove() {
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    boolean _equals = ObjectExtensions.operator_equals(_eContainer, null);
    if (_equals) {
      return;
    }
    JvmTypeParameter _delegate_1 = this.getDelegate();
    EObject _eContainer_1 = _delegate_1.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    JvmTypeParameter _delegate_2 = this.getDelegate();
    _eContents.remove(_delegate_2);
    JvmTypeParameter _delegate_3 = this.getDelegate();
    EObject _eContainer_2 = _delegate_3.eContainer();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_eContainer_2, null);
    if (_notEquals) {
      JvmTypeParameter _delegate_4 = this.getDelegate();
      String _plus = ("Couldn\'t remove " + _delegate_4);
      IllegalStateException _illegalStateException = new IllegalStateException(_plus);
      throw _illegalStateException;
    }
  }
  
  public boolean isAssignableFrom(final Type otherType) {
    boolean _equals = ObjectExtensions.operator_equals(otherType, null);
    if (_equals) {
      return false;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider = _compilationUnit.getTypeReferenceProvider();
    final TypeReference thisTypeRef = _typeReferenceProvider.newTypeReference(this);
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider_1 = _compilationUnit_1.getTypeReferenceProvider();
    final TypeReference thatTypeRef = _typeReferenceProvider_1.newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }
  
  public MutableAnnotationReference addAnnotation(final Type annotationType) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public MutableAnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }
  
  public Iterable<? extends MutableAnnotationReference> getAnnotations() {
    return CollectionLiterals.<MutableAnnotationReference>emptyList();
  }
}
