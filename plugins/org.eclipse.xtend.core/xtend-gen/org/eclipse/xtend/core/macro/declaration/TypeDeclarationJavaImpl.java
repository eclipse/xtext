/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.MemberDeclarationJavaImpl;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class TypeDeclarationJavaImpl<T extends JvmDeclaredType> extends MemberDeclarationJavaImpl<T> implements TypeDeclaration {
  public List<? extends MemberDeclaration> getMembers() {
    JvmDeclaredType _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember,MemberDeclaration> _function = new Function1<JvmMember,MemberDeclaration>() {
        public MemberDeclaration apply(final JvmMember it) {
          CompilationUnitImpl _compilationUnit = TypeDeclarationJavaImpl.this.getCompilationUnit();
          MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(it);
          return _memberDeclaration;
        }
      };
    List<MemberDeclaration> _map = ListExtensions.<JvmMember, MemberDeclaration>map(_members, _function);
    return _map;
  }
  
  public String getPackageName() {
    JvmDeclaredType _delegate = this.getDelegate();
    String _packageName = _delegate.getPackageName();
    return _packageName;
  }
  
  public String getSimpleName() {
    JvmMember _delegate = this.getDelegate();
    String _simpleName = _delegate.getSimpleName();
    return _simpleName;
  }
  
  public String getName() {
    JvmMember _delegate = this.getDelegate();
    String _identifier = _delegate.getIdentifier();
    return _identifier;
  }
}
