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
import org.eclipse.xtend.core.macro.declaration.SourceTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.lib.macro.declaration.SourceClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class SourceClassDeclarationImpl extends SourceTypeDeclarationImpl<XtendClass> implements SourceClassDeclaration {
  public List<TypeReference> getImplementedInterfaces() {
    XtendClass _delegate = this.getDelegate();
    EList<JvmTypeReference> _implements = _delegate.getImplements();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = SourceClassDeclarationImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_implements, _function);
    return _map;
  }
  
  public TypeReference getSuperclass() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendClass _delegate = this.getDelegate();
    JvmTypeReference _extends = _delegate.getExtends();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_extends);
    return _typeReference;
  }
  
  public boolean isAbstract() {
    XtendClass _delegate = this.getDelegate();
    boolean _isAbstract = _delegate.isAbstract();
    return _isAbstract;
  }
  
  public boolean isFinal() {
    return false;
  }
  
  public boolean isStatic() {
    return false;
  }
  
  public List<SourceTypeParameterDeclaration> getTypeParameters() {
    XtendClass _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,SourceTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,SourceTypeParameterDeclaration>() {
        public SourceTypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = SourceClassDeclarationImpl.this.getCompilationUnit();
          SourceTypeParameterDeclaration _sourceTypeParameterDeclaration = _compilationUnit.toSourceTypeParameterDeclaration(it);
          return _sourceTypeParameterDeclaration;
        }
      };
    List<SourceTypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, SourceTypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public Visibility getVisibility() {
    return Visibility.PUBLIC;
  }
  
  public List<SourceMemberDeclaration> getMembers() {
    XtendClass _delegate = this.getDelegate();
    EList<XtendMember> _members = _delegate.getMembers();
    final Function1<XtendMember,SourceMemberDeclaration> _function = new Function1<XtendMember,SourceMemberDeclaration>() {
        public SourceMemberDeclaration apply(final XtendMember it) {
          CompilationUnitImpl _compilationUnit = SourceClassDeclarationImpl.this.getCompilationUnit();
          SourceMemberDeclaration _sourceMemberDeclaration = _compilationUnit.toSourceMemberDeclaration(it);
          return _sourceMemberDeclaration;
        }
      };
    return ListExtensions.<XtendMember, SourceMemberDeclaration>map(_members, _function);
  }
}
