/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtendAnnotationTypeDeclarationImpl extends XtendTypeDeclarationImpl<XtendAnnotationType> implements AnnotationTypeDeclaration {
  public AnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(final String name) {
    Iterable<? extends AnnotationTypeElementDeclaration> _declaredAnnotationTypeElements = this.getDeclaredAnnotationTypeElements();
    final Function1<AnnotationTypeElementDeclaration,Boolean> _function = new Function1<AnnotationTypeElementDeclaration,Boolean>() {
      public Boolean apply(final AnnotationTypeElementDeclaration it) {
        String _simpleName = it.getSimpleName();
        boolean _equals = Objects.equal(_simpleName, name);
        return Boolean.valueOf(_equals);
      }
    };
    AnnotationTypeElementDeclaration _findFirst = IterableExtensions.findFirst(_declaredAnnotationTypeElements, _function);
    return _findFirst;
  }
  
  public Iterable<? extends AnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements() {
    XtendAnnotationType _delegate = this.getDelegate();
    EList<XtendMember> _members = _delegate.getMembers();
    final Function1<XtendMember,MemberDeclaration> _function = new Function1<XtendMember,MemberDeclaration>() {
      public MemberDeclaration apply(final XtendMember it) {
        CompilationUnitImpl _compilationUnit = XtendAnnotationTypeDeclarationImpl.this.getCompilationUnit();
        MemberDeclaration _xtendMemberDeclaration = _compilationUnit.toXtendMemberDeclaration(it);
        return _xtendMemberDeclaration;
      }
    };
    List<MemberDeclaration> _map = ListExtensions.<XtendMember, MemberDeclaration>map(_members, _function);
    Iterable<AnnotationTypeElementDeclaration> _filter = Iterables.<AnnotationTypeElementDeclaration>filter(_map, AnnotationTypeElementDeclaration.class);
    return _filter;
  }
}
