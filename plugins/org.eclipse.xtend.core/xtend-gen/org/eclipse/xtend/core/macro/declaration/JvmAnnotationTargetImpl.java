/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmAnnotationTargetImpl<T extends JvmAnnotationTarget> extends JvmNamedElementImpl<T> implements MutableAnnotationTarget {
  public Iterable<? extends MutableAnnotationReference> getAnnotations() {
    T _delegate = this.getDelegate();
    EList<JvmAnnotationReference> _annotations = _delegate.getAnnotations();
    final Function1<JvmAnnotationReference,MutableAnnotationReference> _function = new Function1<JvmAnnotationReference,MutableAnnotationReference>() {
      public MutableAnnotationReference apply(final JvmAnnotationReference it) {
        CompilationUnitImpl _compilationUnit = JvmAnnotationTargetImpl.this.getCompilationUnit();
        MutableAnnotationReference _annotationReference = _compilationUnit.toAnnotationReference(it);
        return _annotationReference;
      }
    };
    List<MutableAnnotationReference> _map = ListExtensions.<JvmAnnotationReference, MutableAnnotationReference>map(_annotations, _function);
    ImmutableList<MutableAnnotationReference> _copyOf = ImmutableList.<MutableAnnotationReference>copyOf(_map);
    return _copyOf;
  }
  
  public MutableAnnotationReference addAnnotation(final Type annotationType) {
    boolean _matched = false;
    if (!_matched) {
      if (annotationType instanceof JvmAnnotationTypeDeclarationImpl) {
        _matched=true;
        final JvmAnnotationReference result = TypesFactory.eINSTANCE.createJvmAnnotationReference();
        JvmAnnotationType _delegate = ((JvmAnnotationTypeDeclarationImpl)annotationType).getDelegate();
        result.setAnnotation(_delegate);
        T _delegate_1 = this.getDelegate();
        EList<JvmAnnotationReference> _annotations = _delegate_1.getAnnotations();
        _annotations.add(result);
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        return _compilationUnit.toAnnotationReference(result);
      }
    }
    IllegalArgumentException _illegalArgumentException = new IllegalArgumentException((("" + annotationType) + " is not an annotation type."));
    throw _illegalArgumentException;
  }
  
  public MutableAnnotationReference findAnnotation(final Type annotationType) {
    Iterable<? extends MutableAnnotationReference> _annotations = this.getAnnotations();
    final Function1<MutableAnnotationReference,Boolean> _function = new Function1<MutableAnnotationReference,Boolean>() {
      public Boolean apply(final MutableAnnotationReference it) {
        AnnotationTypeDeclaration _annotationTypeDeclaration = it.getAnnotationTypeDeclaration();
        boolean _equals = Objects.equal(_annotationTypeDeclaration, annotationType);
        return Boolean.valueOf(_equals);
      }
    };
    MutableAnnotationReference _findFirst = IterableExtensions.findFirst(_annotations, _function);
    return _findFirst;
  }
}
