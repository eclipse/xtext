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
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmEnumerationTypeDeclarationImpl;
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
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;

@SuppressWarnings("all")
public class MutableJvmEnumerationTypeDeclarationImpl extends JvmEnumerationTypeDeclarationImpl implements MutableEnumerationTypeDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmEnumerationType _delegate = this.getDelegate();
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
  public Iterable<? extends MutableEnumerationValueDeclaration> getDeclaredValues() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableEnumerationValueDeclaration>filter(_declaredMembers, MutableEnumerationValueDeclaration.class);
  }
  
  @Override
  public MutableEnumerationValueDeclaration findDeclaredValue(final String name) {
    Iterable<? extends MutableEnumerationValueDeclaration> _declaredValues = this.getDeclaredValues();
    final Function1<MutableEnumerationValueDeclaration, Boolean> _function = new Function1<MutableEnumerationValueDeclaration, Boolean>() {
      @Override
      public Boolean apply(final MutableEnumerationValueDeclaration value) {
        String _simpleName = value.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredValues, _function);
  }
  
  @Override
  public MutableEnumerationValueDeclaration addValue(final String name, final Procedure1<MutableEnumerationValueDeclaration> initializer) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    final JvmEnumerationLiteral jvmLiteral = TypesFactory.eINSTANCE.createJvmEnumerationLiteral();
    jvmLiteral.setSimpleName(name);
    jvmLiteral.setVisibility(JvmVisibility.PUBLIC);
    JvmEnumerationType _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    _members.add(jvmLiteral);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(jvmLiteral);
    final MutableEnumerationValueDeclaration mutableEnumerationValueDeclaration = ((MutableEnumerationValueDeclaration) _memberDeclaration);
    initializer.apply(mutableEnumerationValueDeclaration);
    return mutableEnumerationValueDeclaration;
  }
}
