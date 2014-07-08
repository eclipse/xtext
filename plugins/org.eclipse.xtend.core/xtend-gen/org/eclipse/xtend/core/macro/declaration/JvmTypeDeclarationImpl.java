/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class JvmTypeDeclarationImpl<T extends JvmDeclaredType> extends JvmMemberDeclarationImpl<T> {
  public Iterable<? extends MemberDeclaration> getDeclaredMembers() {
    T _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember, MemberDeclaration> _function = new Function1<JvmMember, MemberDeclaration>() {
      public MemberDeclaration apply(final JvmMember it) {
        CompilationUnitImpl _compilationUnit = JvmTypeDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toMemberDeclaration(it);
      }
    };
    List<MemberDeclaration> _map = ListExtensions.<JvmMember, MemberDeclaration>map(_members, _function);
    return ImmutableList.<MemberDeclaration>copyOf(_map);
  }
  
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    return _delegate.getSimpleName();
  }
  
  public String getQualifiedName() {
    T _delegate = this.getDelegate();
    return _delegate.getQualifiedName('.');
  }
  
  public boolean isAssignableFrom(final Type otherType) {
    boolean _equals = Objects.equal(otherType, null);
    if (_equals) {
      return false;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider = _compilationUnit.getTypeReferenceProvider();
    final TypeReference thisTypeRef = _typeReferenceProvider.newTypeReference(((Type) this));
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider_1 = _compilationUnit_1.getTypeReferenceProvider();
    final TypeReference thatTypeRef = _typeReferenceProvider_1.newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }
  
  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    T _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    Iterable<JvmConstructor> _filter = Iterables.<JvmConstructor>filter(_members, JvmConstructor.class);
    final Function1<JvmConstructor, Boolean> _function = new Function1<JvmConstructor, Boolean>() {
      public Boolean apply(final JvmConstructor it) {
        CompilationUnitImpl _compilationUnit = JvmTypeDeclarationImpl.this.getCompilationUnit();
        JvmTypeExtensions _typeExtensions = _compilationUnit.getTypeExtensions();
        return Boolean.valueOf(_typeExtensions.isSingleSyntheticDefaultConstructor(it));
      }
    };
    final JvmConstructor constructor = IterableExtensions.<JvmConstructor>findFirst(_filter, _function);
    boolean _notEquals_1 = (!Objects.equal(constructor, null));
    if (_notEquals_1) {
      EcoreUtil.remove(constructor);
    }
    final JvmConstructor newConstructor = TypesFactory.eINSTANCE.createJvmConstructor();
    newConstructor.setVisibility(JvmVisibility.PUBLIC);
    String _simpleName = this.getSimpleName();
    newConstructor.setSimpleName(_simpleName);
    T _delegate_1 = this.getDelegate();
    EList<JvmMember> _members_1 = _delegate_1.getMembers();
    _members_1.add(newConstructor);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(newConstructor);
    final MutableConstructorDeclaration mutableConstructorDeclaration = ((MutableConstructorDeclaration) _memberDeclaration);
    initializer.apply(mutableConstructorDeclaration);
    return mutableConstructorDeclaration;
  }
  
  public MutableFieldDeclaration addField(final String name, final Procedure1<MutableFieldDeclaration> initializer) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    final JvmField newField = TypesFactory.eINSTANCE.createJvmField();
    newField.setSimpleName(name);
    newField.setVisibility(JvmVisibility.PRIVATE);
    T _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    _members.add(newField);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(newField);
    final MutableFieldDeclaration mutableFieldDeclaration = ((MutableFieldDeclaration) _memberDeclaration);
    initializer.apply(mutableFieldDeclaration);
    return mutableFieldDeclaration;
  }
  
  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    final JvmOperation newMethod = TypesFactory.eINSTANCE.createJvmOperation();
    newMethod.setVisibility(JvmVisibility.PUBLIC);
    newMethod.setSimpleName(name);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider = _compilationUnit_1.getTypeReferenceProvider();
    TypeReference _primitiveVoid = _typeReferenceProvider.getPrimitiveVoid();
    JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(_primitiveVoid);
    newMethod.setReturnType(_jvmTypeReference);
    T _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    _members.add(newMethod);
    CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
    MemberDeclaration _memberDeclaration = _compilationUnit_2.toMemberDeclaration(newMethod);
    final MutableMethodDeclaration mutableMethodDeclaration = ((MutableMethodDeclaration) _memberDeclaration);
    initializer.apply(mutableMethodDeclaration);
    return mutableMethodDeclaration;
  }
  
  public ConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    ConstructorDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      Iterable<? extends ConstructorDeclaration> _declaredConstructors = this.getDeclaredConstructors();
      final Function1<ConstructorDeclaration, Boolean> _function = new Function1<ConstructorDeclaration, Boolean>() {
        public Boolean apply(final ConstructorDeclaration constructor) {
          Iterable<? extends ParameterDeclaration> _parameters = constructor.getParameters();
          final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
            public TypeReference apply(final ParameterDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
          List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
          List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
          return Boolean.valueOf(Objects.equal(_list, _list_1));
        }
      };
      _xblockexpression = IterableExtensions.findFirst(_declaredConstructors, _function);
    }
    return _xblockexpression;
  }
  
  public FieldDeclaration findDeclaredField(final String name) {
    Iterable<? extends FieldDeclaration> _declaredFields = this.getDeclaredFields();
    final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
      public Boolean apply(final FieldDeclaration field) {
        String _simpleName = field.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredFields, _function);
  }
  
  public MethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    MethodDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      Iterable<? extends MethodDeclaration> _declaredMethods = this.getDeclaredMethods();
      final Function1<MethodDeclaration, Boolean> _function = new Function1<MethodDeclaration, Boolean>() {
        public Boolean apply(final MethodDeclaration method) {
          boolean _and = false;
          String _simpleName = method.getSimpleName();
          boolean _equals = Objects.equal(_simpleName, name);
          if (!_equals) {
            _and = false;
          } else {
            Iterable<? extends ParameterDeclaration> _parameters = method.getParameters();
            final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
              public TypeReference apply(final ParameterDeclaration it) {
                return it.getType();
              }
            };
            Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
            List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
            List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
            boolean _equals_1 = Objects.equal(_list, _list_1);
            _and = _equals_1;
          }
          return Boolean.valueOf(_and);
        }
      };
      _xblockexpression = IterableExtensions.findFirst(_declaredMethods, _function);
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends MethodDeclaration> getDeclaredMethods() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MethodDeclaration>filter(_declaredMembers, MethodDeclaration.class);
  }
  
  public Iterable<? extends FieldDeclaration> getDeclaredFields() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<FieldDeclaration>filter(_declaredMembers, FieldDeclaration.class);
  }
  
  public Iterable<? extends ClassDeclaration> getDeclaredClasses() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<ClassDeclaration>filter(_declaredMembers, ClassDeclaration.class);
  }
  
  public Iterable<? extends ConstructorDeclaration> getDeclaredConstructors() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<ConstructorDeclaration>filter(_declaredMembers, ConstructorDeclaration.class);
  }
  
  public Iterable<? extends InterfaceDeclaration> getDeclaredInterfaces() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<InterfaceDeclaration>filter(_declaredMembers, InterfaceDeclaration.class);
  }
  
  public void setSimpleName(final String name) {
    throw new UnsupportedOperationException("The type cannot be renamed.");
  }
  
  public void remove() {
    throw new UnsupportedOperationException("The type cannot be removed.");
  }
}
