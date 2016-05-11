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
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
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
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;

@SuppressWarnings("all")
public class MutableJvmClassDeclarationImpl extends JvmClassDeclarationImpl implements MutableClassDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmGenericType _delegate = this.getDelegate();
    _readAndWriteTracking.markReadAccess(_delegate);
  }
  
  @Override
  public MutableMethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    MethodDeclaration _findDeclaredMethod = super.findDeclaredMethod(name, parameterTypes);
    return ((MutableMethodDeclaration) _findDeclaredMethod);
  }
  
  @Override
  public MutableFieldDeclaration findDeclaredField(final String name) {
    FieldDeclaration _findDeclaredField = super.findDeclaredField(name);
    return ((MutableFieldDeclaration) _findDeclaredField);
  }
  
  @Override
  public MutableTypeDeclaration findDeclaredType(final String name) {
    TypeDeclaration _findDeclaredType = super.findDeclaredType(name);
    return ((MutableTypeDeclaration) _findDeclaredType);
  }
  
  @Override
  public MutableConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    ConstructorDeclaration _findDeclaredConstructor = super.findDeclaredConstructor(parameterTypes);
    return ((MutableConstructorDeclaration) _findDeclaredConstructor);
  }
  
  @Override
  public Iterable<? extends MutableMethodDeclaration> getDeclaredMethods() {
    Iterable<? extends MethodDeclaration> _declaredMethods = super.getDeclaredMethods();
    return ((Iterable<? extends MutableMethodDeclaration>) _declaredMethods);
  }
  
  @Override
  public Iterable<? extends MutableFieldDeclaration> getDeclaredFields() {
    Iterable<? extends FieldDeclaration> _declaredFields = super.getDeclaredFields();
    return ((Iterable<? extends MutableFieldDeclaration>) _declaredFields);
  }
  
  @Override
  public Iterable<? extends MutableClassDeclaration> getDeclaredClasses() {
    Iterable<? extends ClassDeclaration> _declaredClasses = super.getDeclaredClasses();
    return ((Iterable<? extends MutableClassDeclaration>) _declaredClasses);
  }
  
  @Override
  public Iterable<? extends MutableConstructorDeclaration> getDeclaredConstructors() {
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = super.getDeclaredConstructors();
    return ((Iterable<? extends MutableConstructorDeclaration>) _declaredConstructors);
  }
  
  @Override
  public Iterable<? extends MutableInterfaceDeclaration> getDeclaredInterfaces() {
    Iterable<? extends InterfaceDeclaration> _declaredInterfaces = super.getDeclaredInterfaces();
    return ((Iterable<? extends MutableInterfaceDeclaration>) _declaredInterfaces);
  }
  
  @Override
  public Iterable<? extends MutableAnnotationTypeDeclaration> getDeclaredAnnotationTypes() {
    Iterable<? extends AnnotationTypeDeclaration> _declaredAnnotationTypes = super.getDeclaredAnnotationTypes();
    return ((Iterable<? extends MutableAnnotationTypeDeclaration>) _declaredAnnotationTypes);
  }
  
  @Override
  public Iterable<? extends MutableEnumerationTypeDeclaration> getDeclaredEnumerationTypes() {
    Iterable<? extends EnumerationTypeDeclaration> _declaredEnumerationTypes = super.getDeclaredEnumerationTypes();
    return ((Iterable<? extends MutableEnumerationTypeDeclaration>) _declaredEnumerationTypes);
  }
  
  @Override
  public Iterable<? extends MutableTypeDeclaration> getDeclaredTypes() {
    Iterable<? extends TypeDeclaration> _declaredTypes = super.getDeclaredTypes();
    return ((Iterable<? extends MutableTypeDeclaration>) _declaredTypes);
  }
  
  @Override
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
  
  @Override
  public Iterable<? extends MutableMemberDeclaration> getDeclaredMembers() {
    Iterable<? extends MemberDeclaration> _declaredMembers = super.getDeclaredMembers();
    return ((Iterable<? extends MutableMemberDeclaration>) _declaredMembers);
  }
  
  @Override
  public Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters() {
    Iterable<? extends TypeParameterDeclaration> _typeParameters = super.getTypeParameters();
    return ((Iterable<? extends MutableTypeParameterDeclaration>) _typeParameters);
  }
  
  @Override
  public void setStrictFloatingPoint(final boolean isStrictFloatingPoint) {
    this.checkMutable();
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setStrictFloatingPoint(isStrictFloatingPoint);
  }
  
  @Override
  public void setAbstract(final boolean isAbstract) {
    this.checkMutable();
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setAbstract(isAbstract);
  }
  
  @Override
  public void setFinal(final boolean isFinal) {
    this.checkMutable();
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  @Override
  public void setStatic(final boolean isStatic) {
    this.checkMutable();
    JvmGenericType _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  @Override
  public void setExtendedClass(final TypeReference superclass) {
    this.checkMutable();
    ConditionUtils.checkInferredTypeReferences("extended class", superclass);
    JvmTypeReference _xifexpression = null;
    boolean _notEquals = (!Objects.equal(superclass, null));
    if (_notEquals) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      _xifexpression = _compilationUnit.toJvmTypeReference(superclass);
    } else {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      TypeReferences _typeReferences = _compilationUnit_1.getTypeReferences();
      CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
      XtendFile _xtendFile = _compilationUnit_2.getXtendFile();
      _xifexpression = _typeReferences.getTypeForName(Object.class, _xtendFile);
    }
    final JvmTypeReference newTypeRef = _xifexpression;
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<JvmTypeReference, Boolean> _function = new Function1<JvmTypeReference, Boolean>() {
      @Override
      public Boolean apply(final JvmTypeReference it) {
        return Boolean.valueOf(((it.getType() instanceof JvmGenericType) && (!((JvmGenericType) it.getType()).isInterface())));
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
  
  @Override
  public void setImplementedInterfaces(final Iterable<? extends TypeReference> superInterfaces) {
    this.checkMutable();
    ConditionUtils.checkIterable(superInterfaces, "superIntefaces");
    ConditionUtils.checkInferredTypeReferences("implemented interface", ((TypeReference[])Conversions.unwrapArray(superInterfaces, TypeReference.class)));
    JvmGenericType _delegate = this.getDelegate();
    EList<JvmTypeReference> _superTypes = _delegate.getSuperTypes();
    final Function1<JvmTypeReference, Boolean> _function = new Function1<JvmTypeReference, Boolean>() {
      @Override
      public Boolean apply(final JvmTypeReference it) {
        return Boolean.valueOf(((it.getType() instanceof JvmGenericType) && ((JvmGenericType) it.getType()).isInterface()));
      }
    };
    final Iterable<JvmTypeReference> oldInterfaces = IterableExtensions.<JvmTypeReference>filter(_superTypes, _function);
    JvmGenericType _delegate_1 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_1 = _delegate_1.getSuperTypes();
    CollectionExtensions.<JvmTypeReference>removeAll(_superTypes_1, oldInterfaces);
    JvmGenericType _delegate_2 = this.getDelegate();
    EList<JvmTypeReference> _superTypes_2 = _delegate_2.getSuperTypes();
    final Function1<TypeReference, JvmTypeReference> _function_1 = new Function1<TypeReference, JvmTypeReference>() {
      @Override
      public JvmTypeReference apply(final TypeReference it) {
        CompilationUnitImpl _compilationUnit = MutableJvmClassDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toJvmTypeReference(it);
      }
    };
    Iterable<JvmTypeReference> _map = IterableExtensions.map(superInterfaces, _function_1);
    Iterables.<JvmTypeReference>addAll(_superTypes_2, _map);
  }
  
  @Override
  public MutableTypeParameterDeclaration addTypeParameter(final String name, final TypeReference... upperBounds) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(upperBounds)), "upperBounds");
    ConditionUtils.checkInferredTypeReferences("parameter type", upperBounds);
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
