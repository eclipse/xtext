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
import java.util.List;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class JvmClassDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements ClassDeclaration {
  @Override
  public Iterable<? extends TypeReference> getImplementedInterfaces() {
    List<TypeReference> _xblockexpression = null;
    {
      final Function1<JvmTypeReference, Boolean> _function = (JvmTypeReference it) -> {
        JvmType _type = it.getType();
        return Boolean.valueOf(((JvmGenericType) _type).isInterface());
      };
      final Iterable<JvmTypeReference> filtered = IterableExtensions.<JvmTypeReference>filter(this.getDelegate().getSuperTypes(), _function);
      final Function1<JvmTypeReference, TypeReference> _function_1 = (JvmTypeReference it) -> {
        return this.getCompilationUnit().toTypeReference(it);
      };
      _xblockexpression = IterableExtensions.<TypeReference>toList(IterableExtensions.<JvmTypeReference, TypeReference>map(filtered, _function_1));
    }
    return _xblockexpression;
  }

  @Override
  public TypeReference getExtendedClass() {
    final Function1<JvmTypeReference, Boolean> _function = (JvmTypeReference it) -> {
      boolean _switchResult = false;
      JvmType _type = it.getType();
      final JvmType it_1 = _type;
      boolean _matched = false;
      if (it_1 instanceof JvmGenericType) {
        boolean _isInterface = ((JvmGenericType)it_1).isInterface();
        boolean _not = (!_isInterface);
        if (_not) {
          _matched=true;
          _switchResult = true;
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      return Boolean.valueOf(_switchResult);
    };
    return this.getCompilationUnit().toTypeReference(
      IterableExtensions.<JvmTypeReference>findFirst(this.getDelegate().getSuperTypes(), _function));
  }

  @Override
  public boolean isAbstract() {
    return this.getDelegate().isAbstract();
  }

  @Override
  public boolean isFinal() {
    return this.getDelegate().isFinal();
  }

  @Override
  public boolean isStatic() {
    return this.getDelegate().isStatic();
  }

  @Override
  public boolean isStrictFloatingPoint() {
    return this.getDelegate().isStrictFloatingPoint();
  }

  @Override
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    final Function1<JvmTypeParameter, TypeParameterDeclaration> _function = (JvmTypeParameter it) -> {
      return this.getCompilationUnit().toTypeParameterDeclaration(it);
    };
    return ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(this.getDelegate().getTypeParameters(), _function);
  }

  @Override
  public FieldDeclaration findDeclaredField(final String name) {
    final Function1<FieldDeclaration, Boolean> _function = (FieldDeclaration it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.<FieldDeclaration>findFirst(Iterables.<FieldDeclaration>filter(this.getDeclaredMembers(), FieldDeclaration.class), _function);
  }

  @Override
  public MethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    MethodDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      final Function1<MethodDeclaration, Boolean> _function = (MethodDeclaration it) -> {
        return Boolean.valueOf((Objects.equal(it.getSimpleName(), name) && Objects.equal(IterableExtensions.<TypeReference>toList(IterableExtensions.map(it.getParameters(), ((Function1<ParameterDeclaration, TypeReference>) (ParameterDeclaration it_1) -> {
          return it_1.getType();
        }))), IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes))))));
      };
      _xblockexpression = IterableExtensions.<MethodDeclaration>findFirst(Iterables.<MethodDeclaration>filter(this.getDeclaredMembers(), MethodDeclaration.class), _function);
    }
    return _xblockexpression;
  }
}
