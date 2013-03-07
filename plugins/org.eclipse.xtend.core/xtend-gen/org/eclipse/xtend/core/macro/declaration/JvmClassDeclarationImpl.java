/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmClassDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements MutableClassDeclaration {
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
            CompilationUnitImpl _compilationUnit = JvmClassDeclarationImpl.this.getCompilationUnit();
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
  
  public List<? extends TypeParameterDeclaration> getTypeParameters() {
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,MutableTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,MutableTypeParameterDeclaration>() {
        public MutableTypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = JvmClassDeclarationImpl.this.getCompilationUnit();
          MutableTypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
          return _typeParameterDeclaration;
        }
      };
    List<MutableTypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, MutableTypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public void setAbstract(final boolean isAbstract) {
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setAbstract(isAbstract);
  }
  
  public void setFinal(final boolean isFinal) {
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  public void setStatic(final boolean isStatic) {
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  public void setSuperclass(final TypeReference superclass) {
    final List<TypeReference> interfaces = this.getImplementedInterfaces();
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    _superTypes.clear();
    JvmGenericType _delegate_1 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_1 = _delegate_1.getSuperTypes();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(superclass);
    _superTypes_1.add(_jvmTypeReference);
    final Procedure1<TypeReference> _function = new Procedure1<TypeReference>() {
        public void apply(final TypeReference it) {
          JvmGenericType _delegate = JvmClassDeclarationImpl.this.getDelegate();
          EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
          CompilationUnitImpl _compilationUnit = JvmClassDeclarationImpl.this.getCompilationUnit();
          JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(it);
          _superTypes.add(_jvmTypeReference);
        }
      };
    IterableExtensions.<TypeReference>forEach(interfaces, _function);
  }
  
  public void setImplementedInterfaces(final List<? extends TypeReference> superInterfaces) {
    final TypeReference superClass = this.getSuperclass();
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    _superTypes.clear();
    JvmGenericType _delegate_1 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_1 = _delegate_1.getSuperTypes();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(superClass);
    _superTypes_1.add(_jvmTypeReference);
    final Procedure1<TypeReference> _function = new Procedure1<TypeReference>() {
        public void apply(final TypeReference it) {
          JvmGenericType _delegate = JvmClassDeclarationImpl.this.getDelegate();
          EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
          CompilationUnitImpl _compilationUnit = JvmClassDeclarationImpl.this.getCompilationUnit();
          JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(it);
          _superTypes.add(_jvmTypeReference);
        }
      };
    IterableExtensions.forEach(superInterfaces, _function);
  }
  
  public MutableFieldDeclaration findField(final String name) {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    Iterable<MutableFieldDeclaration> _filter = Iterables.<MutableFieldDeclaration>filter(_declaredMembers, MutableFieldDeclaration.class);
    final Function1<MutableFieldDeclaration,Boolean> _function = new Function1<MutableFieldDeclaration,Boolean>() {
        public Boolean apply(final MutableFieldDeclaration it) {
          String _name = it.getName();
          boolean _equals = ObjectExtensions.operator_equals(_name, name);
          return Boolean.valueOf(_equals);
        }
      };
    MutableFieldDeclaration _findFirst = IterableExtensions.<MutableFieldDeclaration>findFirst(_filter, _function);
    return _findFirst;
  }
  
  public MutableMethodDeclaration findMethod(final String name, final TypeReference[] parameterTypes) {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    Iterable<MutableMethodDeclaration> _filter = Iterables.<MutableMethodDeclaration>filter(_declaredMembers, MutableMethodDeclaration.class);
    final Function1<MutableMethodDeclaration,Boolean> _function = new Function1<MutableMethodDeclaration,Boolean>() {
        public Boolean apply(final MutableMethodDeclaration it) {
          boolean _and = false;
          String _name = it.getName();
          boolean _equals = ObjectExtensions.operator_equals(_name, name);
          if (!_equals) {
            _and = false;
          } else {
            List<MutableParameterDeclaration> _parameters = it.getParameters();
            final Function1<MutableParameterDeclaration,TypeReference> _function = new Function1<MutableParameterDeclaration,TypeReference>() {
                public TypeReference apply(final MutableParameterDeclaration it) {
                  TypeReference _type = it.getType();
                  return _type;
                }
              };
            List<TypeReference> _map = ListExtensions.<MutableParameterDeclaration, TypeReference>map(_parameters, _function);
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
            List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
            boolean _equals_1 = ObjectExtensions.operator_equals(_list, _list_1);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    MutableMethodDeclaration _findFirst = IterableExtensions.<MutableMethodDeclaration>findFirst(_filter, _function);
    return _findFirst;
  }
}
