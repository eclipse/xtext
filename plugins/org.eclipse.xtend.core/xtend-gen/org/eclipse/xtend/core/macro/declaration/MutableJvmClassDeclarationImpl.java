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
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmClassDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
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

@SuppressWarnings("all")
public class MutableJvmClassDeclarationImpl extends JvmClassDeclarationImpl implements MutableClassDeclaration {
  public MutableMethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    MethodDeclaration _findDeclaredMethod = super.findDeclaredMethod(name, parameterTypes);
    return ((MutableMethodDeclaration) _findDeclaredMethod);
  }
  
  public MutableFieldDeclaration findDeclaredField(final String name) {
    FieldDeclaration _findDeclaredField = super.findDeclaredField(name);
    return ((MutableFieldDeclaration) _findDeclaredField);
  }
  
  public MutableConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    ConstructorDeclaration _findDeclaredConstructor = super.findDeclaredConstructor(parameterTypes);
    return ((MutableConstructorDeclaration) _findDeclaredConstructor);
  }
  
  public Iterable<? extends MutableMethodDeclaration> getDeclaredMethods() {
    Iterable<? extends MethodDeclaration> _declaredMethods = super.getDeclaredMethods();
    return ((Iterable<? extends MutableMethodDeclaration>) _declaredMethods);
  }
  
  public Iterable<? extends MutableFieldDeclaration> getDeclaredFields() {
    Iterable<? extends FieldDeclaration> _declaredFields = super.getDeclaredFields();
    return ((Iterable<? extends MutableFieldDeclaration>) _declaredFields);
  }
  
  public Iterable<? extends MutableClassDeclaration> getDeclaredClasses() {
    Iterable<? extends ClassDeclaration> _declaredClasses = super.getDeclaredClasses();
    return ((Iterable<? extends MutableClassDeclaration>) _declaredClasses);
  }
  
  public Iterable<? extends MutableConstructorDeclaration> getDeclaredConstructors() {
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = super.getDeclaredConstructors();
    return ((Iterable<? extends MutableConstructorDeclaration>) _declaredConstructors);
  }
  
  public Iterable<? extends MutableInterfaceDeclaration> getDeclaredInterfaces() {
    Iterable<? extends InterfaceDeclaration> _declaredInterfaces = super.getDeclaredInterfaces();
    return ((Iterable<? extends MutableInterfaceDeclaration>) _declaredInterfaces);
  }
  
  public MutableAnnotationReference findAnnotation(final Type annotationType) {
    AnnotationReference _findAnnotation = super.findAnnotation(annotationType);
    return ((MutableAnnotationReference) _findAnnotation);
  }
  
  public Iterable<? extends MutableAnnotationReference> getAnnotations() {
    return this.<MutableAnnotationReference>getAnnotations(MutableAnnotationReference.class);
  }
  
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
  
  public Iterable<? extends MutableMemberDeclaration> getDeclaredMembers() {
    return this.<MutableMemberDeclaration>getDeclaredMembers(MutableMemberDeclaration.class);
  }
  
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    Iterable<? extends TypeParameterDeclaration> _typeParameters = super.getTypeParameters();
    return ((Iterable<? extends MutableTypeParameterDeclaration>) _typeParameters);
  }
  
  public void setStrictFloatingPoint(final boolean isStrictFloatingPoint) {
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setStrictFloatingPoint(isStrictFloatingPoint);
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
    JvmTypeReference _xifexpression = null;
    boolean _notEquals = (!Objects.equal(superclass, null));
    if (_notEquals) {
      JvmTypeReference _xblockexpression = null;
      {
        boolean _isInferred = superclass.isInferred();
        if (_isInferred) {
          throw new IllegalArgumentException("Cannot use and inferred type as extended class.");
        }
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        _xblockexpression = (_compilationUnit.toJvmTypeReference(superclass));
      }
      _xifexpression = _xblockexpression;
    } else {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      TypeReferences _typeReferences = _compilationUnit.getTypeReferences();
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      XtendFile _xtendFile = _compilationUnit_1.getXtendFile();
      _xifexpression = _typeReferences.getTypeForName(Object.class, _xtendFile);
    }
    final JvmTypeReference newTypeRef = _xifexpression;
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
          _and = _not;
        }
        return Boolean.valueOf(_and);
      }
    };
    final JvmTypeReference oldType = IterableExtensions.<JvmTypeReference>findFirst(_superTypes, _function);
    boolean _notEquals_1 = (!Objects.equal(oldType, null));
    if (_notEquals_1) {
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
          _and = _isInterface;
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
    final Function1<TypeReference,JvmTypeReference> _function_1 = new Function1<TypeReference,JvmTypeReference>() {
      public JvmTypeReference apply(final TypeReference it) {
        JvmTypeReference _xblockexpression = null;
        {
          boolean _isInferred = it.isInferred();
          if (_isInferred) {
            throw new IllegalArgumentException("Cannot use and inferred type as implemented interface.");
          }
          CompilationUnitImpl _compilationUnit = MutableJvmClassDeclarationImpl.this.getCompilationUnit();
          _xblockexpression = (_compilationUnit.toJvmTypeReference(it));
        }
        return _xblockexpression;
      }
    };
    Iterable<JvmTypeReference> _map = IterableExtensions.map(superInterfaces, _function_1);
    Iterables.<JvmTypeReference>addAll(_superTypes_2, _map);
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
    TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(param);
    return ((MutableTypeParameterDeclaration) _typeParameterDeclaration);
  }
}
