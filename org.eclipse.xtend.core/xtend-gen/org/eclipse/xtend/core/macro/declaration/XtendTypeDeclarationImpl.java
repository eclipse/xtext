/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class XtendTypeDeclarationImpl<T extends XtendTypeDeclaration> extends XtendMemberDeclarationImpl<T> implements TypeDeclaration {
  public String getPackageName() {
    return EcoreUtil2.<XtendFile>getContainerOfType(this.getDelegate(), XtendFile.class).getPackage();
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getName();
  }

  @Override
  public String getQualifiedName() {
    return this.getQualifiedName(this.getDelegate());
  }

  private String getQualifiedName(final XtendTypeDeclaration decl) {
    boolean _isAnonymous = decl.isAnonymous();
    if (_isAnonymous) {
      return null;
    }
    final EObject container = decl.eContainer();
    if ((container instanceof XtendFile)) {
      final String package_ = ((XtendFile)container).getPackage();
      if ((package_ == null)) {
        return decl.getName();
      }
      String _name = decl.getName();
      return ((package_ + ".") + _name);
    }
    if ((container instanceof XtendTypeDeclaration)) {
      final String containerName = this.getQualifiedName(((XtendTypeDeclaration)container));
      if ((containerName == null)) {
        return null;
      }
      String _name_1 = decl.getName();
      return ((containerName + ".") + _name_1);
    }
    return null;
  }

  @Override
  public Visibility getVisibility() {
    return this.getCompilationUnit().toVisibility(this.getDelegate().getVisibility());
  }

  @Override
  public Iterable<? extends MemberDeclaration> getDeclaredMembers() {
    final Function1<XtendMember, MemberDeclaration> _function = (XtendMember it) -> {
      return this.getCompilationUnit().toXtendMemberDeclaration(it);
    };
    return ListExtensions.<XtendMember, MemberDeclaration>map(this.getDelegate().getMembers(), _function);
  }

  @Override
  public boolean isAssignableFrom(final Type otherType) {
    if ((otherType == null)) {
      return false;
    }
    final TypeReference thisTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(this);
    final TypeReference thatTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }

  @Override
  public ConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    final Function1<ConstructorDeclaration, Boolean> _function = (ConstructorDeclaration constructor) -> {
      final Function1<ParameterDeclaration, TypeReference> _function_1 = (ParameterDeclaration it) -> {
        return it.getType();
      };
      List<TypeReference> _list = IterableExtensions.<TypeReference>toList(IterableExtensions.map(constructor.getParameters(), _function_1));
      List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
      return Boolean.valueOf(Objects.equal(_list, _list_1));
    };
    return IterableExtensions.findFirst(this.getDeclaredConstructors(), _function);
  }

  @Override
  public FieldDeclaration findDeclaredField(final String name) {
    final Function1<FieldDeclaration, Boolean> _function = (FieldDeclaration field) -> {
      String _simpleName = field.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredFields(), _function);
  }

  @Override
  public TypeDeclaration findDeclaredType(final String name) {
    final Function1<TypeDeclaration, Boolean> _function = (TypeDeclaration type) -> {
      String _simpleName = type.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredTypes(), _function);
  }

  @Override
  public MethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    final Function1<MethodDeclaration, Boolean> _function = (MethodDeclaration method) -> {
      return Boolean.valueOf((Objects.equal(method.getSimpleName(), name) && Objects.equal(IterableExtensions.<TypeReference>toList(IterableExtensions.map(method.getParameters(), ((Function1<ParameterDeclaration, TypeReference>) (ParameterDeclaration it) -> {
        return it.getType();
      }))), IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes))))));
    };
    return IterableExtensions.findFirst(this.getDeclaredMethods(), _function);
  }

  @Override
  public Iterable<? extends MethodDeclaration> getDeclaredMethods() {
    return Iterables.<MethodDeclaration>filter(this.getDeclaredMembers(), MethodDeclaration.class);
  }

  @Override
  public Iterable<? extends FieldDeclaration> getDeclaredFields() {
    return Iterables.<FieldDeclaration>filter(this.getDeclaredMembers(), FieldDeclaration.class);
  }

  @Override
  public Iterable<? extends ClassDeclaration> getDeclaredClasses() {
    return Iterables.<ClassDeclaration>filter(this.getDeclaredMembers(), ClassDeclaration.class);
  }

  @Override
  public Iterable<? extends ConstructorDeclaration> getDeclaredConstructors() {
    return Iterables.<ConstructorDeclaration>filter(this.getDeclaredMembers(), ConstructorDeclaration.class);
  }

  @Override
  public Iterable<? extends InterfaceDeclaration> getDeclaredInterfaces() {
    return Iterables.<InterfaceDeclaration>filter(this.getDeclaredMembers(), InterfaceDeclaration.class);
  }

  @Override
  public Iterable<? extends AnnotationTypeDeclaration> getDeclaredAnnotationTypes() {
    return Iterables.<AnnotationTypeDeclaration>filter(this.getDeclaredMembers(), AnnotationTypeDeclaration.class);
  }

  @Override
  public Iterable<? extends EnumerationTypeDeclaration> getDeclaredEnumerationTypes() {
    return Iterables.<EnumerationTypeDeclaration>filter(this.getDeclaredMembers(), EnumerationTypeDeclaration.class);
  }

  @Override
  public Iterable<? extends TypeDeclaration> getDeclaredTypes() {
    return Iterables.<TypeDeclaration>filter(this.getDeclaredMembers(), TypeDeclaration.class);
  }
}
