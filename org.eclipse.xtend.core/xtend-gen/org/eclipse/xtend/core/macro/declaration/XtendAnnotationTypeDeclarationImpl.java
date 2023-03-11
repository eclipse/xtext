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
import com.google.common.collect.Iterables;
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
  @Override
  public AnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(final String name) {
    final Function1<AnnotationTypeElementDeclaration, Boolean> _function = (AnnotationTypeElementDeclaration it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredAnnotationTypeElements(), _function);
  }

  @Override
  public Iterable<? extends AnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements() {
    final Function1<XtendMember, MemberDeclaration> _function = (XtendMember it) -> {
      return this.getCompilationUnit().toXtendMemberDeclaration(it);
    };
    return Iterables.<AnnotationTypeElementDeclaration>filter(ListExtensions.<XtendMember, MemberDeclaration>map(this.getDelegate().getMembers(), _function), AnnotationTypeElementDeclaration.class);
  }
}
