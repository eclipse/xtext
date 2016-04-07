/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationTargetImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Modifier;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendAnnotationTargetImpl<T> implements MemberDeclaration {
  @Override
  public String getDocComment() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    IEObjectDocumentationProvider _documentationProvider = _compilationUnit.getDocumentationProvider();
    T _delegate = this.getDelegate();
    return _documentationProvider.getDocumentation(_delegate);
  }
  
  @Override
  public TypeDeclaration getDeclaringType() {
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    T _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (container instanceof XtendTypeDeclaration) {
      _matched=true;
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      _switchResult = _compilationUnit.toXtendTypeDeclaration(((XtendTypeDeclaration)container));
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  @Override
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
  
  @Override
  public Set<Modifier> getModifiers() {
    T _delegate = this.getDelegate();
    EList<String> _modifiers = _delegate.getModifiers();
    final Function1<String, Modifier> _function = new Function1<String, Modifier>() {
      @Override
      public Modifier apply(final String it) {
        String _upperCase = it.toUpperCase();
        return Modifier.valueOf(_upperCase);
      }
    };
    List<Modifier> _map = ListExtensions.<String, Modifier>map(_modifiers, _function);
    return IterableExtensions.<Modifier>toSet(_map);
  }
  
  @Override
  public boolean isDeprecated() {
    T _delegate = this.getDelegate();
    EList<XAnnotation> _annotations = _delegate.getAnnotations();
    final Function1<XAnnotation, Boolean> _function = new Function1<XAnnotation, Boolean>() {
      @Override
      public Boolean apply(final XAnnotation it) {
        String _name = Deprecated.class.getName();
        JvmType _annotationType = it.getAnnotationType();
        String _identifier = null;
        if (_annotationType!=null) {
          _identifier=_annotationType.getIdentifier();
        }
        return Boolean.valueOf(Objects.equal(_name, _identifier));
      }
    };
    return IterableExtensions.<XAnnotation>exists(_annotations, _function);
  }
}
