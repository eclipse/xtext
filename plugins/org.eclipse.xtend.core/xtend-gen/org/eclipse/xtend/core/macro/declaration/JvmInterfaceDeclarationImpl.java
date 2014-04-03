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
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmInterfaceDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements InterfaceDeclaration {
  public Iterable<? extends TypeReference> getExtendedInterfaces() {
    List<TypeReference> _xblockexpression = null;
    {
      JvmGenericType _delegate = this.getDelegate();
      EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
      final Function1<JvmTypeReference, Boolean> _function = new Function1<JvmTypeReference, Boolean>() {
        public Boolean apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          return Boolean.valueOf(((JvmGenericType) _type).isInterface());
        }
      };
      final Iterable<JvmTypeReference> filtered = IterableExtensions.<JvmTypeReference>filter(_superTypes, _function);
      final Function1<JvmTypeReference, TypeReference> _function_1 = new Function1<JvmTypeReference, TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = JvmInterfaceDeclarationImpl.this.getCompilationUnit();
          return _compilationUnit.toTypeReference(it);
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.<JvmTypeReference, TypeReference>map(filtered, _function_1);
      _xblockexpression = IterableExtensions.<TypeReference>toList(_map);
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter, TypeParameterDeclaration> _function = new Function1<JvmTypeParameter, TypeParameterDeclaration>() {
      public TypeParameterDeclaration apply(final JvmTypeParameter it) {
        CompilationUnitImpl _compilationUnit = JvmInterfaceDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeParameterDeclaration(it);
      }
    };
    return ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(_typeParameters, _function);
  }
  
  public boolean isStrictFloatingPoint() {
    JvmGenericType _delegate = this.getDelegate();
    return _delegate.isStrictFloatingPoint();
  }
  
  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    final MutableMethodDeclaration result = super.addMethod(name, initializer);
    result.setAbstract(true);
    return result;
  }
  
  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The interface \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any constructors.");
    throw new UnsupportedOperationException(_plus_1);
  }
}
