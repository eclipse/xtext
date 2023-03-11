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
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Modifier;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendAnnotationTargetImpl<T> implements MemberDeclaration {
  @Override
  public String getDocComment() {
    return this.getCompilationUnit().getDocumentationProvider().getDocumentation(this.getDelegate());
  }

  @Override
  public TypeDeclaration getDeclaringType() {
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    EObject _eContainer = this.getDelegate().eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (container instanceof XtendTypeDeclaration) {
      _matched=true;
      _switchResult = this.getCompilationUnit().toXtendTypeDeclaration(((XtendTypeDeclaration)container));
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }

  @Override
  public Visibility getVisibility() {
    return this.getCompilationUnit().toVisibility(this.getDelegate().getVisibility());
  }

  @Override
  public Set<Modifier> getModifiers() {
    final Function1<String, Modifier> _function = (String it) -> {
      return Modifier.valueOf(it.toUpperCase());
    };
    return IterableExtensions.<Modifier>toSet(ListExtensions.<String, Modifier>map(this.getDelegate().getModifiers(), _function));
  }

  @Override
  public boolean isDeprecated() {
    final Function1<XAnnotation, Boolean> _function = (XAnnotation it) -> {
      String _name = Deprecated.class.getName();
      JvmType _annotationType = it.getAnnotationType();
      String _identifier = null;
      if (_annotationType!=null) {
        _identifier=_annotationType.getIdentifier();
      }
      return Boolean.valueOf(Objects.equal(_name, _identifier));
    };
    return IterableExtensions.<XAnnotation>exists(this.getDelegate().getAnnotations(), _function);
  }
}
