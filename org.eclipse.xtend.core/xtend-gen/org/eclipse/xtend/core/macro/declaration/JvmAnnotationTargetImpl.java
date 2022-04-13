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
import com.google.common.collect.ImmutableList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmAnnotationTargetImpl<T extends JvmAnnotationTarget> extends JvmNamedElementImpl<T> {
  public Iterable<? extends AnnotationReference> getAnnotations() {
    final Function1<JvmAnnotationReference, AnnotationReference> _function = (JvmAnnotationReference it) -> {
      return this.getCompilationUnit().toAnnotationReference(it);
    };
    return ImmutableList.<AnnotationReference>copyOf(ListExtensions.<JvmAnnotationReference, AnnotationReference>map(this.getDelegate().getAnnotations(), _function));
  }

  public AnnotationReference addAnnotation(final AnnotationReference annotationReference) {
    AnnotationReference _xblockexpression = null;
    {
      this.checkMutable();
      Preconditions.checkArgument((annotationReference != null), "annotationReference cannot be null");
      AnnotationReference _xifexpression = null;
      if ((annotationReference instanceof JvmAnnotationReferenceImpl)) {
        AnnotationReference _xblockexpression_1 = null;
        {
          final JvmAnnotationReference jvmAnnotationReference = EcoreUtil2.<JvmAnnotationReference>cloneWithProxies(((JvmAnnotationReferenceImpl)annotationReference).getDelegate());
          EList<JvmAnnotationReference> _annotations = this.getDelegate().getAnnotations();
          _annotations.add(jvmAnnotationReference);
          _xblockexpression_1 = this.getCompilationUnit().toAnnotationReference(jvmAnnotationReference);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(annotationReference);
        _builder.append(" is not annotation reference");
        throw new IllegalArgumentException(_builder.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public boolean removeAnnotation(final AnnotationReference annotationReference) {
    this.checkMutable();
    if ((annotationReference instanceof JvmAnnotationReferenceImpl)) {
      return this.getDelegate().getAnnotations().remove(((JvmAnnotationReferenceImpl)annotationReference).getDelegate());
    }
    return false;
  }

  public AnnotationReference findAnnotation(final Type annotationType) {
    final Function1<AnnotationReference, Boolean> _function = (AnnotationReference it) -> {
      AnnotationTypeDeclaration _annotationTypeDeclaration = it.getAnnotationTypeDeclaration();
      return Boolean.valueOf(Objects.equal(_annotationTypeDeclaration, annotationType));
    };
    return IterableExtensions.findFirst(this.getAnnotations(), _function);
  }
}
