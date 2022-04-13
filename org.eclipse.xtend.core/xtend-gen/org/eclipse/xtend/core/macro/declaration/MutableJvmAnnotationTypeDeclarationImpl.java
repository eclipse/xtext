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
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class MutableJvmAnnotationTypeDeclarationImpl extends JvmAnnotationTypeDeclarationImpl implements MutableAnnotationTypeDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
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
  public MutableAnnotationTypeElementDeclaration addAnnotationTypeElement(final String name, final Procedure1<MutableAnnotationTypeElementDeclaration> initializer) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    Preconditions.checkArgument((initializer != null), "initializer cannot be null");
    final JvmOperation newAnnotationElement = TypesFactory.eINSTANCE.createJvmOperation();
    newAnnotationElement.setSimpleName(name);
    newAnnotationElement.setVisibility(JvmVisibility.PUBLIC);
    this.getDelegate().getMembers().add(newAnnotationElement);
    MemberDeclaration _memberDeclaration = this.getCompilationUnit().toMemberDeclaration(newAnnotationElement);
    final MutableAnnotationTypeElementDeclaration mutableAnnotationTypeElementDeclaration = ((MutableAnnotationTypeElementDeclaration) _memberDeclaration);
    initializer.apply(mutableAnnotationTypeElementDeclaration);
    return mutableAnnotationTypeElementDeclaration;
  }

  @Override
  public MutableAnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(final String name) {
    final Function1<MutableAnnotationTypeElementDeclaration, Boolean> _function = (MutableAnnotationTypeElementDeclaration it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredAnnotationTypeElements(), _function);
  }

  @Override
  public Iterable<? extends MutableAnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements() {
    final Function1<JvmMember, MemberDeclaration> _function = (JvmMember it) -> {
      return this.getCompilationUnit().toMemberDeclaration(it);
    };
    return Iterables.<MutableAnnotationTypeElementDeclaration>filter(ListExtensions.<JvmMember, MemberDeclaration>map(this.getDelegate().getMembers(), _function), MutableAnnotationTypeElementDeclaration.class);
  }
}
