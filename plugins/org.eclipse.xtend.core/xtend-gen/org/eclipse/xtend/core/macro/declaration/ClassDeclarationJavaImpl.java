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
import org.eclipse.xtend.core.macro.declaration.TypeDeclarationJavaImpl;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ClassDeclarationJavaImpl extends TypeDeclarationJavaImpl<JvmGenericType> implements ClassDeclaration {
  public List<TypeReference> getImplementedInterfaces() {
    List<TypeReference> _xblockexpression = null;
    {
      JvmGenericType _delegate = this.getDelegate();
      EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
      final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
          public Boolean apply(final JvmTypeReference it) {
            JvmType _type = it.getType();
            boolean _isInterface = ((JvmGenericType) _type).isInterface();
            return Boolean.valueOf(_isInterface);
          }
        };
      final Iterable<JvmTypeReference> filtered = IterableExtensions.<JvmTypeReference>filter(_superTypes, _function);
      final Function1<JvmTypeReference,TypeReference> _function_1 = new Function1<JvmTypeReference,TypeReference>() {
          public TypeReference apply(final JvmTypeReference it) {
            CompilationUnitImpl _compilationUnit = ClassDeclarationJavaImpl.this.getCompilationUnit();
            TypeReference _typeReference = _compilationUnit.toTypeReference(it);
            return _typeReference;
          }
        };
      Iterable<TypeReference> _map = IterableExtensions.<JvmTypeReference, TypeReference>map(filtered, _function_1);
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public TypeReference getSuperclass() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
        public Boolean apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          boolean _isInterface = ((JvmGenericType) _type).isInterface();
          return Boolean.valueOf(_isInterface);
        }
      };
    JvmTypeReference _findFirst = IterableExtensions.<JvmTypeReference>findFirst(_superTypes, _function);
    TypeReference _typeReference = _compilationUnit.toTypeReference(_findFirst);
    return _typeReference;
  }
  
  public boolean isAbstract() {
    JvmGenericType _delegate = this.getDelegate();
    boolean _isAbstract = _delegate.isAbstract();
    return _isAbstract;
  }
  
  public boolean isFinal() {
    JvmGenericType _delegate = this.getDelegate();
    boolean _isFinal = _delegate.isFinal();
    return _isFinal;
  }
  
  public boolean isStatic() {
    JvmGenericType _delegate = this.getDelegate();
    boolean _isStatic = _delegate.isStatic();
    return _isStatic;
  }
  
  public List<TypeParameterDeclaration> getTypeParameters() {
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,TypeParameterDeclaration> _function = new Function1<JvmTypeParameter,TypeParameterDeclaration>() {
        public TypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = ClassDeclarationJavaImpl.this.getCompilationUnit();
          TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
          return _typeParameterDeclaration;
        }
      };
    List<TypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
}
