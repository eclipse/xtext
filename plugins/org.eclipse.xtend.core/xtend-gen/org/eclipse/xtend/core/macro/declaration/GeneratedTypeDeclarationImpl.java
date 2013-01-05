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
import org.eclipse.xtend.core.macro.declaration.GeneratedMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.GeneratedMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class GeneratedTypeDeclarationImpl<T extends JvmDeclaredType> extends GeneratedMemberDeclarationImpl<T> implements GeneratedTypeDeclaration {
  public List<GeneratedMemberDeclaration> getMembers() {
    JvmDeclaredType _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember,GeneratedMemberDeclaration> _function = new Function1<JvmMember,GeneratedMemberDeclaration>() {
        public GeneratedMemberDeclaration apply(final JvmMember it) {
          CompilationUnitImpl _compilationUnit = GeneratedTypeDeclarationImpl.this.getCompilationUnit();
          MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(it);
          return ((GeneratedMemberDeclaration) _memberDeclaration);
        }
      };
    List<GeneratedMemberDeclaration> _map = ListExtensions.<JvmMember, GeneratedMemberDeclaration>map(_members, _function);
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
