/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeParameterDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;

@SuppressWarnings("all")
public class JvmTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements AnnotationTarget, TypeParameterDeclaration {
  public TypeParameterDeclarator getTypeParameterDeclarator() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(((JvmExecutable) _eContainer));
    return ((TypeParameterDeclarator) _memberDeclaration);
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
  
  public String getQualifiedName() {
    JvmTypeParameter _delegate = this.getDelegate();
    return _delegate.getIdentifier();
  }
}
