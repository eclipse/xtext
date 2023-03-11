/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendTypeParameterDeclarationImpl extends AbstractElementImpl<JvmTypeParameter> implements TypeParameterDeclaration {
  @Override
  public Iterable<? extends TypeReference> getUpperBounds() {
    final Function1<JvmUpperBound, TypeReference> _function = (JvmUpperBound it) -> {
      return this.getCompilationUnit().toTypeReference(it.getTypeReference());
    };
    return IterableExtensions.<TypeReference>toList(IterableExtensions.<JvmUpperBound, TypeReference>map(Iterables.<JvmUpperBound>filter(this.getDelegate().getConstraints(), JvmUpperBound.class), _function));
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getName();
  }

  @Override
  public String getQualifiedName() {
    return this.getSimpleName();
  }

  @Override
  public TypeParameterDeclarator getTypeParameterDeclarator() {
    TypeParameterDeclarator _xblockexpression = null;
    {
      final EObject eContainer = this.getDelegate().eContainer();
      MemberDeclaration _xtendMemberDeclaration = this.getCompilationUnit().toXtendMemberDeclaration(((XtendMember) eContainer));
      _xblockexpression = ((TypeParameterDeclarator) _xtendMemberDeclaration);
    }
    return _xblockexpression;
  }

  @Override
  public Iterable<? extends AnnotationReference> getAnnotations() {
    return CollectionLiterals.<AnnotationReference>emptyList();
  }

  @Override
  public AnnotationReference findAnnotation(final Type annotationType) {
    return null;
  }

  @Override
  public boolean isAssignableFrom(final Type otherType) {
    if ((otherType == null)) {
      return false;
    }
    final TypeReference thisTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(this);
    final TypeReference thatTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }
}
