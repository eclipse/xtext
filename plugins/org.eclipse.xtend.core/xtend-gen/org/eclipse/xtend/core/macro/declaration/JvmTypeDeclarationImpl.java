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
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmTypeDeclarationImpl<T extends JvmDeclaredType> extends JvmMemberDeclarationImpl<T> implements MutableTypeDeclaration {
  public List<? extends MutableMemberDeclaration> getMembers() {
    T _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember,MutableMemberDeclaration> _function = new Function1<JvmMember,MutableMemberDeclaration>() {
        public MutableMemberDeclaration apply(final JvmMember it) {
          CompilationUnitImpl _compilationUnit = JvmTypeDeclarationImpl.this.getCompilationUnit();
          MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(it);
          return ((MutableMemberDeclaration) _memberDeclaration);
        }
      };
    List<MutableMemberDeclaration> _map = ListExtensions.<JvmMember, MutableMemberDeclaration>map(_members, _function);
    return _map;
  }
  
  public String getPackageName() {
    T _delegate = this.getDelegate();
    String _packageName = _delegate.getPackageName();
    return _packageName;
  }
  
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    String _simpleName = _delegate.getSimpleName();
    return _simpleName;
  }
  
  public String getName() {
    T _delegate = this.getDelegate();
    String _identifier = _delegate.getIdentifier();
    return _identifier;
  }
  
  public void setPackageName(final String packageName) {
    T _delegate = this.getDelegate();
    _delegate.setPackageName(packageName);
  }
  
  public void setSimpleName(final String simpleName) {
    T _delegate = this.getDelegate();
    _delegate.setSimpleName(simpleName);
  }
  
  public void setName(final String name) {
    final int idx = name.lastIndexOf(".");
    int _minus = (-1);
    boolean _equals = (idx == _minus);
    if (_equals) {
      T _delegate = this.getDelegate();
      _delegate.setPackageName(null);
      T _delegate_1 = this.getDelegate();
      _delegate_1.setSimpleName(name);
    } else {
      T _delegate_2 = this.getDelegate();
      int _minus_1 = (idx - 1);
      String _substring = name.substring(0, _minus_1);
      _delegate_2.setPackageName(_substring);
      T _delegate_3 = this.getDelegate();
      String _substring_1 = name.substring(idx);
      _delegate_3.setSimpleName(_substring_1);
    }
  }
}
