/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtendClassDeclarationImpl extends XtendTypeDeclarationImpl<XtendClass> implements ClassDeclaration {
  public Iterable<? extends TypeReference> getImplementedInterfaces() {
    XtendClass _delegate = this.getDelegate();
    EList<JvmTypeReference> _implements = _delegate.getImplements();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
      public TypeReference apply(final JvmTypeReference it) {
        CompilationUnitImpl _compilationUnit = XtendClassDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<JvmTypeReference, TypeReference>map(_implements, _function);
  }
  
  public TypeReference getExtendedClass() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendClass _delegate = this.getDelegate();
    JvmTypeReference _extends = _delegate.getExtends();
    return _compilationUnit.toTypeReference(_extends);
  }
  
  public boolean isAbstract() {
    XtendClass _delegate = this.getDelegate();
    return _delegate.isAbstract();
  }
  
  public boolean isFinal() {
    XtendClass _delegate = this.getDelegate();
    return _delegate.isFinal();
  }
  
  public boolean isStatic() {
    return true;
  }
  
  public boolean isStrictFloatingPoint() {
    return false;
  }
  
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    XtendClass _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,XtendTypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,XtendTypeParameterDeclarationImpl>() {
      public XtendTypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
        CompilationUnitImpl _compilationUnit = XtendClassDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toXtendTypeParameterDeclaration(it);
      }
    };
    return ListExtensions.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>map(_typeParameters, _function);
  }
}
