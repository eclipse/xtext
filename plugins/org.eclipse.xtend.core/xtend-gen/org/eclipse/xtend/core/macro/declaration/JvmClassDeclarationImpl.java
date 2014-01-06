/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JvmClassDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements MutableClassDeclaration {
  public Iterable<? extends TypeReference> getImplementedInterfaces() {
    List<TypeReference> _xblockexpression = null;
    {
      JvmGenericType _delegate = this.getDelegate();
      EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
      final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
        public Boolean apply(final JvmTypeReference it) {
          JvmType _type = it.getType();
          return Boolean.valueOf(((JvmGenericType) _type).isInterface());
        }
      };
      final Iterable<JvmTypeReference> filtered = IterableExtensions.<JvmTypeReference>filter(_superTypes, _function);
      final Function1<JvmTypeReference,TypeReference> _function_1 = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = JvmClassDeclarationImpl.this.getCompilationUnit();
          return _compilationUnit.toTypeReference(it);
        }
      };
      Iterable<TypeReference> _map = IterableExtensions.<JvmTypeReference, TypeReference>map(filtered, _function_1);
      _xblockexpression = (IterableExtensions.<TypeReference>toList(_map));
    }
    return _xblockexpression;
  }
  
  public TypeReference getExtendedClass() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
      public Boolean apply(final JvmTypeReference it) {
        boolean _switchResult = false;
        JvmType _type = it.getType();
        final JvmType it_1 = _type;
        boolean _matched = false;
        if (!_matched) {
          if (it_1 instanceof JvmGenericType) {
            boolean _isInterface = ((JvmGenericType)it_1).isInterface();
            boolean _not = (!_isInterface);
            if (_not) {
              _matched=true;
              _switchResult = true;
            }
          }
        }
        if (!_matched) {
          _switchResult = false;
        }
        return Boolean.valueOf(_switchResult);
      }
    };
    JvmTypeReference _findFirst = IterableExtensions.<JvmTypeReference>findFirst(_superTypes, _function);
    return _compilationUnit.toTypeReference(_findFirst);
  }
  
  public boolean isAbstract() {
    JvmGenericType _delegate = this.getDelegate();
    return _delegate.isAbstract();
  }
  
  public boolean isFinal() {
    JvmGenericType _delegate = this.getDelegate();
    return _delegate.isFinal();
  }
  
  public boolean isStatic() {
    JvmGenericType _delegate = this.getDelegate();
    return _delegate.isStatic();
  }
  
  public boolean isStrictFloatingPoint() {
    JvmGenericType _delegate = this.getDelegate();
    return _delegate.isStrictFloatingPoint();
  }
  
  public void setStrictFloatingPoint(final boolean isStrictFloatingPoint) {
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setStrictFloatingPoint(isStrictFloatingPoint);
  }
  
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,MutableTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,MutableTypeParameterDeclaration>() {
      public MutableTypeParameterDeclaration apply(final JvmTypeParameter it) {
        CompilationUnitImpl _compilationUnit = JvmClassDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeParameterDeclaration(it);
      }
    };
    return ListExtensions.<JvmTypeParameter, MutableTypeParameterDeclaration>map(_typeParameters, _function);
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
  
  public void setExtendedClass(final TypeReference superclass) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (superclass instanceof TypeReferenceImpl) {
        _matched=true;
        LightweightTypeReference _delegate = ((TypeReferenceImpl)superclass).getDelegate();
        _switchResult = _delegate.toJavaCompliantTypeReference();
      }
    }
    if (!_matched) {
      if (Objects.equal(superclass,null)) {
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        TypeReferences _typeReferences = _compilationUnit.getTypeReferences();
        CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
        XtendFile _xtendFile = _compilationUnit_1.getXtendFile();
        _switchResult = _typeReferences.getTypeForName(Object.class, _xtendFile);
      }
    }
    final JvmTypeReference newTypeRef = _switchResult;
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
      public Boolean apply(final JvmTypeReference it) {
        boolean _and = false;
        JvmType _type = it.getType();
        if (!(_type instanceof JvmGenericType)) {
          _and = false;
        } else {
          JvmType _type_1 = it.getType();
          boolean _isInterface = ((JvmGenericType) _type_1).isInterface();
          boolean _not = (!_isInterface);
          _and = ((_type instanceof JvmGenericType) && _not);
        }
        return Boolean.valueOf(_and);
      }
    };
    final JvmTypeReference oldType = IterableExtensions.<JvmTypeReference>findFirst(_superTypes, _function);
    boolean _notEquals = (!Objects.equal(oldType, null));
    if (_notEquals) {
      JvmGenericType _delegate_1 = this.getDelegate();
      EList<JvmTypeReference> _superTypes_1 = _delegate_1.getSuperTypes();
      _superTypes_1.remove(oldType);
    }
    JvmGenericType _delegate_2 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_2 = _delegate_2.getSuperTypes();
    _superTypes_2.add(newTypeRef);
  }
  
  public void setImplementedInterfaces(final Iterable<? extends TypeReference> superInterfaces) {
    ConditionUtils.checkIterable(superInterfaces, "superIntefaces");
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<JvmTypeReference,Boolean> _function = new Function1<JvmTypeReference,Boolean>() {
      public Boolean apply(final JvmTypeReference it) {
        boolean _and = false;
        JvmType _type = it.getType();
        if (!(_type instanceof JvmGenericType)) {
          _and = false;
        } else {
          JvmType _type_1 = it.getType();
          boolean _isInterface = ((JvmGenericType) _type_1).isInterface();
          _and = ((_type instanceof JvmGenericType) && _isInterface);
        }
        return Boolean.valueOf(_and);
      }
    };
    final Iterable<JvmTypeReference> oldInterfaces = IterableExtensions.<JvmTypeReference>filter(_superTypes, _function);
    JvmGenericType _delegate_1 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_1 = _delegate_1.getSuperTypes();
    CollectionExtensions.<JvmTypeReference>removeAll(_superTypes_1, oldInterfaces);
    JvmGenericType _delegate_2 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_2 = _delegate_2.getSuperTypes();
    Iterable<TypeReferenceImpl> _filter = Iterables.<TypeReferenceImpl>filter(superInterfaces, TypeReferenceImpl.class);
    final Function1<TypeReferenceImpl,JvmTypeReference> _function_1 = new Function1<TypeReferenceImpl,JvmTypeReference>() {
      public JvmTypeReference apply(final TypeReferenceImpl it) {
        LightweightTypeReference _delegate = it.getDelegate();
        return _delegate.toJavaCompliantTypeReference();
      }
    };
    Iterable<JvmTypeReference> _map = IterableExtensions.<TypeReferenceImpl, JvmTypeReference>map(_filter, _function_1);
    Iterables.<JvmTypeReference>addAll(_superTypes_2, _map);
  }
  
  public MutableFieldDeclaration findDeclaredField(final String name) {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    Iterable<MutableFieldDeclaration> _filter = Iterables.<MutableFieldDeclaration>filter(_declaredMembers, MutableFieldDeclaration.class);
    final Function1<MutableFieldDeclaration,Boolean> _function = new Function1<MutableFieldDeclaration,Boolean>() {
      public Boolean apply(final MutableFieldDeclaration it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.<MutableFieldDeclaration>findFirst(_filter, _function);
  }
  
  public MutableMethodDeclaration findDeclaredMethod(final String name, final TypeReference[] parameterTypes) {
    MutableMethodDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
      Iterable<MutableMethodDeclaration> _filter = Iterables.<MutableMethodDeclaration>filter(_declaredMembers, MutableMethodDeclaration.class);
      final Function1<MutableMethodDeclaration,Boolean> _function = new Function1<MutableMethodDeclaration,Boolean>() {
        public Boolean apply(final MutableMethodDeclaration it) {
          boolean _and = false;
          String _simpleName = it.getSimpleName();
          boolean _equals = Objects.equal(_simpleName, name);
          if (!_equals) {
            _and = false;
          } else {
            Iterable<? extends MutableParameterDeclaration> _parameters = it.getParameters();
            final Function1<MutableParameterDeclaration,TypeReference> _function = new Function1<MutableParameterDeclaration,TypeReference>() {
              public TypeReference apply(final MutableParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
            List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
            boolean _equals_1 = Objects.equal(_list, _list_1);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = (IterableExtensions.<MutableMethodDeclaration>findFirst(_filter, _function));
    }
    return _xblockexpression;
  }
  
  public MutableTypeParameterDeclaration addTypeParameter(final String name, final TypeReference... upperBounds) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(upperBounds)), "upperBounds");
    final JvmTypeParameter param = TypesFactory.eINSTANCE.createJvmTypeParameter();
    param.setName(name);
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    _typeParameters.add(param);
    for (final TypeReference upper : upperBounds) {
      {
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        final JvmTypeReference typeRef = _compilationUnit.toJvmTypeReference(upper);
        final JvmUpperBound jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound();
        jvmUpperBound.setTypeReference(typeRef);
        EList<JvmTypeConstraint> _constraints = param.getConstraints();
        _constraints.add(jvmUpperBound);
      }
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.toTypeParameterDeclaration(param);
  }
}
