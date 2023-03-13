/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class MutableJvmTypeParameterDeclarationImpl extends JvmTypeParameterDeclarationImpl implements MutableAnnotationTarget, MutableTypeParameterDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
  }

  @Override
  public MutableTypeParameterDeclarator getTypeParameterDeclarator() {
    TypeParameterDeclarator _typeParameterDeclarator = super.getTypeParameterDeclarator();
    return ((MutableTypeParameterDeclarator) _typeParameterDeclarator);
  }

  @Override
  public void setSimpleName(final String name) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    JvmTypeParameter _delegate = this.getDelegate();
    _delegate.setName(name);
  }

  @Override
  public void remove() {
    this.checkMutable();
    Resource _eResource = this.getDelegate().eResource();
    boolean _tripleNotEquals = (_eResource != null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("This element has already been removed: ");
    JvmTypeParameter _delegate = this.getDelegate();
    _builder.append(_delegate);
    Preconditions.checkState(_tripleNotEquals, _builder);
    this.getCompilationUnit().getJvmModelAssociator().removeAllAssociation(this.getDelegate());
    EcoreUtil.remove(this.getDelegate());
    Resource _eResource_1 = this.getDelegate().eResource();
    boolean _tripleEquals = (_eResource_1 == null);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Couldn\'t remove: ");
    JvmTypeParameter _delegate_1 = this.getDelegate();
    _builder_1.append(_delegate_1);
    Preconditions.checkState(_tripleEquals, _builder_1);
  }

  @Override
  public AnnotationReference addAnnotation(final AnnotationReference annotationReference) {
    throw new UnsupportedOperationException("It is not possible to add an annotation.");
  }

  @Override
  public boolean removeAnnotation(final AnnotationReference annotationReference) {
    throw new UnsupportedOperationException("It is not possible to remove an annotation.");
  }

  @Override
  public void setUpperBounds(final Iterable<? extends TypeReference> upperBounds) {
    this.checkMutable();
    ConditionUtils.checkIterable(upperBounds, "upperBounds");
    ConditionUtils.checkInferredTypeReferences("parameter type", ((TypeReference[])Conversions.unwrapArray(upperBounds, TypeReference.class)));
    this.getDelegate().getConstraints().clear();
    for (final TypeReference upper : upperBounds) {
      {
        final JvmTypeReference typeRef = this.getCompilationUnit().toJvmTypeReference(upper);
        final JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
        jvmUpperBound.setTypeReference(typeRef);
        this.getDelegate().getConstraints().add(jvmUpperBound);
      }
    }
  }

  protected final void checkMutable() {
    ActiveAnnotationContexts.AnnotationCallback _lastPhase = this.getCompilationUnit().getLastPhase();
    boolean _notEquals = (!Objects.equal(_lastPhase, ActiveAnnotationContexts.AnnotationCallback.INFERENCE));
    if (_notEquals) {
      throw new IllegalStateException("Element cannot be modified outside the transformation phase");
    }
  }
}
