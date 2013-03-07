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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public abstract class XtendTypeDeclarationImpl<T extends XtendTypeDeclaration> extends XtendMemberDeclarationImpl<T> implements TypeDeclaration {
  public String getPackageName() {
    T _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    return ((XtendFile) _eContainer).getPackage();
  }
  
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    String _name = _delegate.getName();
    return _name;
  }
  
  public String getName() {
    String _xifexpression = null;
    String _packageName = this.getPackageName();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_packageName, null);
    if (_notEquals) {
      String _packageName_1 = this.getPackageName();
      String _plus = (_packageName_1 + ".");
      String _simpleName = this.getSimpleName();
      String _plus_1 = (_plus + _simpleName);
      _xifexpression = _plus_1;
    } else {
      String _simpleName_1 = this.getSimpleName();
      _xifexpression = _simpleName_1;
    }
    return _xifexpression;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
  
  public List<? extends MemberDeclaration> getMembers() {
    T _delegate = this.getDelegate();
    EList<XtendMember> _members = _delegate.getMembers();
    final Function1<XtendMember,MemberDeclaration> _function = new Function1<XtendMember,MemberDeclaration>() {
        public MemberDeclaration apply(final XtendMember it) {
          CompilationUnitImpl _compilationUnit = XtendTypeDeclarationImpl.this.getCompilationUnit();
          MemberDeclaration _xtendMemberDeclaration = _compilationUnit.toXtendMemberDeclaration(it);
          return _xtendMemberDeclaration;
        }
      };
    return ListExtensions.<XtendMember, MemberDeclaration>map(_members, _function);
  }
  
  public boolean isAssignableFrom(final Type otherType) {
    boolean _equals = ObjectExtensions.operator_equals(otherType, null);
    if (_equals) {
      return false;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider = _compilationUnit.getTypeReferenceProvider();
    final TypeReference thisTypeRef = _typeReferenceProvider.newTypeReference(this);
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider_1 = _compilationUnit_1.getTypeReferenceProvider();
    final TypeReference thatTypeRef = _typeReferenceProvider_1.newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }
}
