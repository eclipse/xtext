/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.ConditionUtils;
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
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class JvmTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements MutableAnnotationTarget, MutableTypeParameterDeclaration {
  public MutableTypeParameterDeclarator getTypeParameterDeclarator() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(((JvmExecutable) _eContainer));
    return ((MutableTypeParameterDeclarator) _memberDeclaration);
  }
  
  public void setSimpleName(final String name) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    JvmTypeParameter _delegate = this.getDelegate();
    _delegate.setName(name);
  }
  
  public void remove() {
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    boolean _equals = Objects.equal(_eContainer, null);
    if (_equals) {
      return;
    }
    JvmTypeParameter _delegate_1 = this.getDelegate();
    EcoreUtil.remove(_delegate_1);
    JvmTypeParameter _delegate_2 = this.getDelegate();
    EObject _eContainer_1 = _delegate_2.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer_1, null));
    if (_notEquals) {
      JvmTypeParameter _delegate_3 = this.getDelegate();
      String _string = _delegate_3.toString();
      String _plus = ("Couldn\'t remove " + _string);
      throw new IllegalStateException(_plus);
    }
  }
  
  public boolean isAssignableFrom(final Type otherType) {
    boolean _equals = Objects.equal(otherType, null);
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
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public MutableAnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }
  
  public Iterable<? extends MutableAnnotationReference> getAnnotations() {
    return CollectionLiterals.<MutableAnnotationReference>emptyList();
  }
  
  public String getQualifiedName() {
    JvmTypeParameter _delegate = this.getDelegate();
    return _delegate.getIdentifier();
  }
  
  public void setUpperBounds(final Iterable<? extends TypeReference> upperBounds) {
    ConditionUtils.checkIterable(upperBounds, "upperBounds");
    JvmTypeParameter _delegate = this.getDelegate();
    EList<JvmTypeConstraint> _constraints = _delegate.getConstraints();
    _constraints.clear();
    for (final TypeReference upper : upperBounds) {
      {
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        final JvmTypeReference typeRef = _compilationUnit.toJvmTypeReference(upper);
        final JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
        jvmUpperBound.setTypeReference(typeRef);
        JvmTypeParameter _delegate_1 = this.getDelegate();
        EList<JvmTypeConstraint> _constraints_1 = _delegate_1.getConstraints();
        _constraints_1.add(jvmUpperBound);
      }
    }
  }
}
