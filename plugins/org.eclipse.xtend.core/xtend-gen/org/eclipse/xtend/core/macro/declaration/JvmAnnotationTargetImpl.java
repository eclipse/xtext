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
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
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
    T _delegate = this.getDelegate();
    EList<JvmAnnotationReference> _annotations = _delegate.getAnnotations();
    final Function1<JvmAnnotationReference, AnnotationReference> _function = new Function1<JvmAnnotationReference, AnnotationReference>() {
      public AnnotationReference apply(final JvmAnnotationReference it) {
        CompilationUnitImpl _compilationUnit = JvmAnnotationTargetImpl.this.getCompilationUnit();
        return _compilationUnit.toAnnotationReference(it);
      }
    };
    List<AnnotationReference> _map = ListExtensions.<JvmAnnotationReference, AnnotationReference>map(_annotations, _function);
    return ImmutableList.<AnnotationReference>copyOf(_map);
  }
  
  public AnnotationReference addAnnotation(final AnnotationReference annotationReference) {
    AnnotationReference _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(annotationReference, null));
      Preconditions.checkArgument(_notEquals, "annotationReference cannot be null");
      AnnotationReference _xifexpression = null;
      if ((annotationReference instanceof JvmAnnotationReferenceImpl)) {
        AnnotationReference _xblockexpression_1 = null;
        {
          JvmAnnotationReference _delegate = ((JvmAnnotationReferenceImpl)annotationReference).getDelegate();
          final JvmAnnotationReference jvmAnnotationReference = EcoreUtil2.<JvmAnnotationReference>cloneWithProxies(_delegate);
          T _delegate_1 = this.getDelegate();
          EList<JvmAnnotationReference> _annotations = _delegate_1.getAnnotations();
          _annotations.add(jvmAnnotationReference);
          CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
          _xblockexpression_1 = _compilationUnit.toAnnotationReference(jvmAnnotationReference);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(annotationReference, "");
        _builder.append(" is not annotation reference");
        throw new IllegalArgumentException(_builder.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean removeAnnotation(final AnnotationReference annotationReference) {
    if ((annotationReference instanceof JvmAnnotationReferenceImpl)) {
      T _delegate = this.getDelegate();
      EList<JvmAnnotationReference> _annotations = _delegate.getAnnotations();
      JvmAnnotationReference _delegate_1 = ((JvmAnnotationReferenceImpl)annotationReference).getDelegate();
      return _annotations.remove(_delegate_1);
    }
    return false;
  }
  
  public AnnotationReference findAnnotation(final Type annotationType) {
    Iterable<? extends AnnotationReference> _annotations = this.getAnnotations();
    final Function1<AnnotationReference, Boolean> _function = new Function1<AnnotationReference, Boolean>() {
      public Boolean apply(final AnnotationReference it) {
        AnnotationTypeDeclaration _annotationTypeDeclaration = it.getAnnotationTypeDeclaration();
        return Boolean.valueOf(Objects.equal(_annotationTypeDeclaration, annotationType));
      }
    };
    return IterableExtensions.findFirst(_annotations, _function);
  }
}
