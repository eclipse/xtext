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
import com.google.common.collect.Iterables;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmAnnotationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmAnnotationType> implements AnnotationTypeDeclaration {
  @Override
  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any constructors.");
    throw new UnsupportedOperationException(_plus_1);
  }

  @Override
  public MutableFieldDeclaration addField(final String name, final Procedure1<MutableFieldDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any fields.");
    throw new UnsupportedOperationException(_plus_1);
  }

  @Override
  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any methods.");
    throw new UnsupportedOperationException(_plus_1);
  }

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
    final Function1<JvmMember, MemberDeclaration> _function = (JvmMember it) -> {
      return this.getCompilationUnit().toMemberDeclaration(it);
    };
    return Iterables.<AnnotationTypeElementDeclaration>filter(ListExtensions.<JvmMember, MemberDeclaration>map(this.getDelegate().getMembers(), _function), AnnotationTypeElementDeclaration.class);
  }
}
