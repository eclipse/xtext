/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Modifier;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.impl.JvmMemberImplCustom;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public abstract class JvmMemberDeclarationImpl<T extends JvmMember> extends JvmAnnotationTargetImpl<T> implements MemberDeclaration {
  @Override
  public String getDocComment() {
    Adapter _adapter = EcoreUtil.getAdapter(this.getDelegate().eAdapters(), DocumentationAdapter.class);
    final DocumentationAdapter adapter = ((DocumentationAdapter) _adapter);
    String _documentation = null;
    if (adapter!=null) {
      _documentation=adapter.getDocumentation();
    }
    return _documentation;
  }

  public void setDocComment(final String docComment) {
    this.checkMutable();
    Adapter _adapter = EcoreUtil.getAdapter(this.getDelegate().eAdapters(), DocumentationAdapter.class);
    DocumentationAdapter adapter = ((DocumentationAdapter) _adapter);
    if ((adapter == null)) {
      DocumentationAdapter _documentationAdapter = new DocumentationAdapter();
      adapter = _documentationAdapter;
      EList<Adapter> _eAdapters = this.getDelegate().eAdapters();
      _eAdapters.add(adapter);
    }
    adapter.setDocumentation(docComment);
  }

  @Override
  public Visibility getVisibility() {
    return this.getCompilationUnit().toVisibility(this.getDelegate().getVisibility());
  }

  public void setVisibility(final Visibility visibility) {
    this.checkMutable();
    T _delegate = this.getDelegate();
    JvmVisibility _switchResult = null;
    if (visibility != null) {
      switch (visibility) {
        case DEFAULT:
          _switchResult = JvmVisibility.DEFAULT;
          break;
        case PUBLIC:
          _switchResult = JvmVisibility.PUBLIC;
          break;
        case PRIVATE:
          _switchResult = JvmVisibility.PRIVATE;
          break;
        case PROTECTED:
          _switchResult = JvmVisibility.PROTECTED;
          break;
        default:
          break;
      }
    }
    _delegate.setVisibility(_switchResult);
  }

  @Override
  public TypeDeclaration getDeclaringType() {
    return this.getCompilationUnit().toTypeDeclaration(this.getDelegate().getDeclaringType());
  }

  public void setSimpleName(final String name) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    T _delegate = this.getDelegate();
    final T it = _delegate;
    boolean _matched = false;
    if (it instanceof JvmMemberImplCustom) {
      _matched=true;
      ((JvmMemberImplCustom)it).clearIdentifierCache();
    }
    T _delegate_1 = this.getDelegate();
    _delegate_1.setSimpleName(name);
  }

  @Override
  public Set<Modifier> getModifiers() {
    return Collections.<Modifier>unmodifiableSet(CollectionLiterals.<Modifier>newHashSet());
  }

  @Override
  public boolean isDeprecated() {
    return DeprecationUtil.isDeprecatedMember(this.getDelegate());
  }

  public void setDeprecated(final boolean deprecated) {
    this.checkMutable();
    if (deprecated) {
      T _delegate = this.getDelegate();
      _delegate.setDeprecated(true);
      this.addAnnotation(this.getCompilationUnit().getAnnotationReferenceProvider().newAnnotationReference(Deprecated.class));
    } else {
      T _delegate_1 = this.getDelegate();
      _delegate_1.setDeprecated(false);
      final AnnotationReference existingReference = this.findAnnotation(this.getCompilationUnit().getTypeLookup().findTypeGlobally(Deprecated.class));
      if ((existingReference != null)) {
        this.removeAnnotation(existingReference);
      }
    }
  }
}
