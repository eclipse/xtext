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
import org.eclipse.xtend.core.macro.declaration.JvmTypeParameterDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;

@SuppressWarnings("all")
public class MutableJvmTypeParameterDeclarationImpl extends JvmTypeParameterDeclarationImpl implements MutableAnnotationTarget, MutableTypeParameterDeclaration {
  public void markAsRead() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmTypeParameter _delegate = this.getDelegate();
    _readAndWriteTracking.markReadAccess(_delegate);
  }
  
  public MutableTypeParameterDeclarator getTypeParameterDeclarator() {
    TypeParameterDeclarator _typeParameterDeclarator = super.getTypeParameterDeclarator();
    return ((MutableTypeParameterDeclarator) _typeParameterDeclarator);
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
  
  public AnnotationReference addAnnotation(final AnnotationReference annotationReference) {
    throw new UnsupportedOperationException("It is not possible to add an annotation.");
  }
  
  public boolean removeAnnotation(final AnnotationReference annotationReference) {
    throw new UnsupportedOperationException("It is not possible to remove an annotation.");
  }
  
  public void setUpperBounds(final Iterable<? extends TypeReference> upperBounds) {
    ConditionUtils.checkIterable(upperBounds, "upperBounds");
    ConditionUtils.checkInferredTypeReferences("parameter type", ((TypeReference[])Conversions.unwrapArray(upperBounds, TypeReference.class)));
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
