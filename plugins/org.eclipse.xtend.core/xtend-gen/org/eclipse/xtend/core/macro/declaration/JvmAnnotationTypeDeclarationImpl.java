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
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
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
  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any constructors.");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  public MutableFieldDeclaration addField(final String name, final Procedure1<MutableFieldDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any fields.");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any methods.");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  public AnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(final String name) {
    Iterable<? extends AnnotationTypeElementDeclaration> _declaredAnnotationTypeElements = this.getDeclaredAnnotationTypeElements();
    final Function1<AnnotationTypeElementDeclaration, Boolean> _function = new Function1<AnnotationTypeElementDeclaration, Boolean>() {
      public Boolean apply(final AnnotationTypeElementDeclaration it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredAnnotationTypeElements, _function);
  }
  
  public Iterable<? extends AnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements() {
    JvmAnnotationType _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember, MemberDeclaration> _function = new Function1<JvmMember, MemberDeclaration>() {
      public MemberDeclaration apply(final JvmMember it) {
        CompilationUnitImpl _compilationUnit = JvmAnnotationTypeDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toMemberDeclaration(it);
      }
    };
    List<MemberDeclaration> _map = ListExtensions.<JvmMember, MemberDeclaration>map(_members, _function);
    return Iterables.<AnnotationTypeElementDeclaration>filter(_map, AnnotationTypeElementDeclaration.class);
  }
}
