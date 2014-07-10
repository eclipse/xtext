/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TypeParameterDeclarationImpl extends AbstractElementImpl<JvmTypeParameter> implements TypeParameterDeclaration {
  public Iterable<? extends TypeReference> getUpperBounds() {
    JvmTypeParameter _delegate = this.getDelegate();
    EList<JvmTypeConstraint> _constraints = _delegate.getConstraints();
    Iterable<JvmUpperBound> _filter = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
    final Function1<JvmUpperBound, TypeReference> _function = new Function1<JvmUpperBound, TypeReference>() {
      public TypeReference apply(final JvmUpperBound it) {
        CompilationUnitImpl _compilationUnit = TypeParameterDeclarationImpl.this.getCompilationUnit();
        JvmTypeReference _typeReference = it.getTypeReference();
        return _compilationUnit.toTypeReference(_typeReference);
      }
    };
    Iterable<TypeReference> _map = IterableExtensions.<JvmUpperBound, TypeReference>map(_filter, _function);
    return IterableExtensions.<TypeReference>toList(_map);
  }
  
  public String getSimpleName() {
    JvmTypeParameter _delegate = this.getDelegate();
    return _delegate.getName();
  }
  
  public String getQualifiedName() {
    JvmTypeParameter _delegate = this.getDelegate();
    return _delegate.getIdentifier();
  }
  
  public TypeParameterDeclarator getTypeParameterDeclarator() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(((JvmExecutable) _eContainer));
    return ((TypeParameterDeclarator) _memberDeclaration);
  }
  
  public Iterable<? extends AnnotationReference> getAnnotations() {
    return CollectionLiterals.<AnnotationReference>emptyList();
  }
  
  public AnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }
  
  public boolean isAssignableFrom(final Type otherType) {
    boolean _tripleEquals = (otherType == null);
    if (_tripleEquals) {
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
}
