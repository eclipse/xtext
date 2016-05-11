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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class XtendTypeDeclarationImpl<T extends XtendTypeDeclaration> extends XtendMemberDeclarationImpl<T> implements TypeDeclaration {
  public String getPackageName() {
    T _delegate = this.getDelegate();
    XtendFile _containerOfType = EcoreUtil2.<XtendFile>getContainerOfType(_delegate, XtendFile.class);
    return _containerOfType.getPackage();
  }
  
  @Override
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    return _delegate.getName();
  }
  
  @Override
  public String getQualifiedName() {
    T _delegate = this.getDelegate();
    return this.getQualifiedName(_delegate);
  }
  
  private String getQualifiedName(final XtendTypeDeclaration decl) {
    boolean _isAnonymous = decl.isAnonymous();
    if (_isAnonymous) {
      return null;
    }
    final EObject container = decl.eContainer();
    if ((container instanceof XtendFile)) {
      final String package_ = ((XtendFile)container).getPackage();
      boolean _equals = Objects.equal(package_, null);
      if (_equals) {
        return decl.getName();
      }
      String _name = decl.getName();
      return ((package_ + ".") + _name);
    }
    if ((container instanceof XtendTypeDeclaration)) {
      final String containerName = this.getQualifiedName(((XtendTypeDeclaration)container));
      boolean _equals_1 = Objects.equal(containerName, null);
      if (_equals_1) {
        return null;
      }
      String _name_1 = decl.getName();
      return ((containerName + ".") + _name_1);
    }
    return null;
  }
  
  @Override
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
  
  @Override
  public Iterable<? extends MemberDeclaration> getDeclaredMembers() {
    T _delegate = this.getDelegate();
    EList<XtendMember> _members = _delegate.getMembers();
    final Function1<XtendMember, MemberDeclaration> _function = new Function1<XtendMember, MemberDeclaration>() {
      @Override
      public MemberDeclaration apply(final XtendMember it) {
        CompilationUnitImpl _compilationUnit = XtendTypeDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toXtendMemberDeclaration(it);
      }
    };
    return ListExtensions.<XtendMember, MemberDeclaration>map(_members, _function);
  }
  
  @Override
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
  
  @Override
  public ConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    Iterable<? extends ConstructorDeclaration> _declaredConstructors = this.getDeclaredConstructors();
    final Function1<ConstructorDeclaration, Boolean> _function = new Function1<ConstructorDeclaration, Boolean>() {
      @Override
      public Boolean apply(final ConstructorDeclaration constructor) {
        Iterable<? extends ParameterDeclaration> _parameters = constructor.getParameters();
        final Function1<ParameterDeclaration, TypeReference> _function = new Function1<ParameterDeclaration, TypeReference>() {
          @Override
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
    return IterableExtensions.findFirst(_declaredConstructors, _function);
  }
  
  @Override
  public FieldDeclaration findDeclaredField(final String name) {
    Iterable<? extends FieldDeclaration> _declaredFields = this.getDeclaredFields();
    final Function1<FieldDeclaration, Boolean> _function = new Function1<FieldDeclaration, Boolean>() {
      @Override
      public Boolean apply(final FieldDeclaration field) {
        String _simpleName = field.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredFields, _function);
  }
  
  @Override
  public TypeDeclaration findDeclaredType(final String name) {
    Iterable<? extends TypeDeclaration> _declaredTypes = this.getDeclaredTypes();
    final Function1<TypeDeclaration, Boolean> _function = new Function1<TypeDeclaration, Boolean>() {
      @Override
      public Boolean apply(final TypeDeclaration type) {
        String _simpleName = type.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredTypes, _function);
  }
  
  @Override
  public MethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    Iterable<? extends MethodDeclaration> _declaredMethods = this.getDeclaredMethods();
    final Function1<MethodDeclaration, Boolean> _function = new Function1<MethodDeclaration, Boolean>() {
      @Override
      public Boolean apply(final MethodDeclaration method) {
        return Boolean.valueOf((Objects.equal(method.getSimpleName(), name) && Objects.equal(IterableExtensions.<TypeReference>toList(IterableExtensions.map(method.getParameters(), new Function1<ParameterDeclaration, TypeReference>() {
          @Override
          public TypeReference apply(final ParameterDeclaration it) {
            return it.getType();
          }
        })), IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes))))));
      }
    };
    return IterableExtensions.findFirst(_declaredMethods, _function);
  }
  
  @Override
  public Iterable<? extends MethodDeclaration> getDeclaredMethods() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MethodDeclaration>filter(_declaredMembers, MethodDeclaration.class);
  }
  
  @Override
  public Iterable<? extends FieldDeclaration> getDeclaredFields() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<FieldDeclaration>filter(_declaredMembers, FieldDeclaration.class);
  }
  
  @Override
  public Iterable<? extends ClassDeclaration> getDeclaredClasses() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<ClassDeclaration>filter(_declaredMembers, ClassDeclaration.class);
  }
  
  @Override
  public Iterable<? extends ConstructorDeclaration> getDeclaredConstructors() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<ConstructorDeclaration>filter(_declaredMembers, ConstructorDeclaration.class);
  }
  
  @Override
  public Iterable<? extends InterfaceDeclaration> getDeclaredInterfaces() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<InterfaceDeclaration>filter(_declaredMembers, InterfaceDeclaration.class);
  }
  
  @Override
  public Iterable<? extends AnnotationTypeDeclaration> getDeclaredAnnotationTypes() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<AnnotationTypeDeclaration>filter(_declaredMembers, AnnotationTypeDeclaration.class);
  }
  
  @Override
  public Iterable<? extends EnumerationTypeDeclaration> getDeclaredEnumerationTypes() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<EnumerationTypeDeclaration>filter(_declaredMembers, EnumerationTypeDeclaration.class);
  }
  
  @Override
  public Iterable<? extends TypeDeclaration> getDeclaredTypes() {
    Iterable<? extends MemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<TypeDeclaration>filter(_declaredMembers, TypeDeclaration.class);
  }
}
