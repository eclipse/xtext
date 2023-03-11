/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class XtendAnnotationTargetImpl<T extends XtendAnnotationTarget> extends XtendNamedElementImpl<T> implements AnnotationTarget {
  @Override
  public Iterable<? extends AnnotationReference> getAnnotations() {
    final Function1<XAnnotation, AnnotationReference> _function = (XAnnotation it) -> {
      return this.getCompilationUnit().toAnnotationReference(it);
    };
    return ImmutableList.<AnnotationReference>copyOf(ListExtensions.<XAnnotation, AnnotationReference>map(this.getDelegate().getAnnotations(), _function));
  }

  @Override
  public AnnotationReference findAnnotation(final Type annotationType) {
    final Function1<AnnotationReference, Boolean> _function = (AnnotationReference it) -> {
      AnnotationTypeDeclaration _annotationTypeDeclaration = it.getAnnotationTypeDeclaration();
      return Boolean.valueOf(Objects.equal(_annotationTypeDeclaration, annotationType));
    };
    return IterableExtensions.findFirst(this.getAnnotations(), _function);
  }
}
