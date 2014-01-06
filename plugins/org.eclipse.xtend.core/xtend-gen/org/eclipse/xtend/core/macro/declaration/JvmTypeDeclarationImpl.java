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
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
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
public abstract class JvmTypeDeclarationImpl<T extends JvmDeclaredType> extends JvmMemberDeclarationImpl<T> implements MutableTypeDeclaration {
  public Iterable<? extends MutableMemberDeclaration> getDeclaredMembers() {
    T _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember,MutableMemberDeclaration> _function = new Function1<JvmMember,MutableMemberDeclaration>() {
      public MutableMemberDeclaration apply(final JvmMember it) {
        CompilationUnitImpl _compilationUnit = JvmTypeDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toMemberDeclaration(it);
      }
    };
    List<MutableMemberDeclaration> _map = ListExtensions.<JvmMember, MutableMemberDeclaration>map(_members, _function);
    return ImmutableList.<MutableMemberDeclaration>copyOf(_map);
  }
  
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    return _delegate.getSimpleName();
  }
  
  public String getQualifiedName() {
    T _delegate = this.getDelegate();
    return _delegate.getIdentifier();
  }
  
  public boolean isAssignableFrom(final Type otherType) {
    boolean _equals = Objects.equal(otherType, null);
    if (_equals) {
      return false;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider = _compilationUnit.getTypeReferenceProvider();
    final TypeReference thisTypeRef = _typeReferenceProvider.newTypeReference(this);
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
    final Function1<JvmConstructor,Boolean> _function = new Function1<JvmConstructor,Boolean>() {
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
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(newConstructor);
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
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(newField);
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
    MutableMemberDeclaration _memberDeclaration = _compilationUnit_2.toMemberDeclaration(newMethod);
    final MutableMethodDeclaration mutableMethodDeclaration = ((MutableMethodDeclaration) _memberDeclaration);
    initializer.apply(mutableMethodDeclaration);
    return mutableMethodDeclaration;
  }
  
  public MutableConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    MutableConstructorDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      Iterable<? extends MutableConstructorDeclaration> _declaredConstructors = this.getDeclaredConstructors();
      final Function1<MutableConstructorDeclaration,Boolean> _function = new Function1<MutableConstructorDeclaration,Boolean>() {
        public Boolean apply(final MutableConstructorDeclaration constructor) {
          Iterable<? extends MutableParameterDeclaration> _parameters = constructor.getParameters();
          final Function1<MutableParameterDeclaration,TypeReference> _function = new Function1<MutableParameterDeclaration,TypeReference>() {
            public TypeReference apply(final MutableParameterDeclaration it) {
              return it.getType();
            }
          };
          Iterable<TypeReference> _map = IterableExtensions.map(_parameters, _function);
          List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
          List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
          return Boolean.valueOf(Objects.equal(_list, _list_1));
        }
      };
      _xblockexpression = (IterableExtensions.findFirst(_declaredConstructors, _function));
    }
    return _xblockexpression;
  }
  
  public MutableFieldDeclaration findDeclaredField(final String name) {
    Iterable<? extends MutableFieldDeclaration> _declaredFields = this.getDeclaredFields();
    final Function1<MutableFieldDeclaration,Boolean> _function = new Function1<MutableFieldDeclaration,Boolean>() {
      public Boolean apply(final MutableFieldDeclaration field) {
        String _simpleName = field.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredFields, _function);
  }
  
  public MutableMethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    MutableMethodDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      Iterable<? extends MutableMethodDeclaration> _declaredMethods = this.getDeclaredMethods();
      final Function1<MutableMethodDeclaration,Boolean> _function = new Function1<MutableMethodDeclaration,Boolean>() {
        public Boolean apply(final MutableMethodDeclaration method) {
          boolean _and = false;
          String _simpleName = method.getSimpleName();
          boolean _equals = Objects.equal(_simpleName, name);
          if (!_equals) {
            _and = false;
          } else {
            Iterable<? extends MutableParameterDeclaration> _parameters = method.getParameters();
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
      _xblockexpression = (IterableExtensions.findFirst(_declaredMethods, _function));
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends MutableMethodDeclaration> getDeclaredMethods() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableMethodDeclaration>filter(_declaredMembers, MutableMethodDeclaration.class);
  }
  
  public Iterable<? extends MutableFieldDeclaration> getDeclaredFields() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableFieldDeclaration>filter(_declaredMembers, MutableFieldDeclaration.class);
  }
  
  public Iterable<? extends MutableClassDeclaration> getDeclaredClasses() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableClassDeclaration>filter(_declaredMembers, MutableClassDeclaration.class);
  }
  
  public Iterable<? extends MutableConstructorDeclaration> getDeclaredConstructors() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableConstructorDeclaration>filter(_declaredMembers, MutableConstructorDeclaration.class);
  }
  
  public Iterable<? extends MutableInterfaceDeclaration> getDeclaredInterfaces() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableInterfaceDeclaration>filter(_declaredMembers, MutableInterfaceDeclaration.class);
  }
  
  public void setSimpleName(final String name) {
    throw new UnsupportedOperationException("The type cannot be renamed.");
  }
}
