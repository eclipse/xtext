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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class JvmTypeDeclarationImpl<T extends JvmDeclaredType> extends JvmMemberDeclarationImpl<T> {
  public Iterable<? extends MemberDeclaration> getDeclaredMembers() {
    final Function1<JvmMember, MemberDeclaration> _function = (JvmMember it) -> {
      return this.getCompilationUnit().toMemberDeclaration(it);
    };
    return ImmutableList.<MemberDeclaration>copyOf(ListExtensions.<JvmMember, MemberDeclaration>map(this.getDelegate().getMembers(), _function));
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getSimpleName();
  }

  public String getQualifiedName() {
    return this.getDelegate().getQualifiedName('.');
  }

  public boolean isAssignableFrom(final Type otherType) {
    if ((otherType == null)) {
      return false;
    }
    final TypeReference thisTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(((Type) this));
    final TypeReference thatTypeRef = this.getCompilationUnit().getTypeReferenceProvider().newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }

  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    this.checkMutable();
    Preconditions.checkArgument((initializer != null), "initializer cannot be null");
    final Function1<JvmConstructor, Boolean> _function = (JvmConstructor it) -> {
      return Boolean.valueOf(this.getCompilationUnit().getTypeExtensions().isSingleSyntheticDefaultConstructor(it));
    };
    final JvmConstructor constructor = IterableExtensions.<JvmConstructor>findFirst(Iterables.<JvmConstructor>filter(this.getDelegate().getMembers(), JvmConstructor.class), _function);
    if ((constructor != null)) {
      MemberDeclaration _memberDeclaration = this.getCompilationUnit().toMemberDeclaration(constructor);
      final MutableConstructorDeclaration mutableConstructorDeclaration = ((MutableConstructorDeclaration) _memberDeclaration);
      mutableConstructorDeclaration.remove();
    }
    final JvmConstructor newConstructor = TypesFactory.eINSTANCE.createJvmConstructor();
    newConstructor.setVisibility(JvmVisibility.PUBLIC);
    newConstructor.setSimpleName(this.getSimpleName());
    this.getDelegate().getMembers().add(newConstructor);
    MemberDeclaration _memberDeclaration_1 = this.getCompilationUnit().toMemberDeclaration(newConstructor);
    final MutableConstructorDeclaration mutableConstructorDeclaration_1 = ((MutableConstructorDeclaration) _memberDeclaration_1);
    initializer.apply(mutableConstructorDeclaration_1);
    return mutableConstructorDeclaration_1;
  }

  public MutableFieldDeclaration addField(final String name, final Procedure1<MutableFieldDeclaration> initializer) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    Preconditions.checkArgument((initializer != null), "initializer cannot be null");
    final JvmField newField = TypesFactory.eINSTANCE.createJvmField();
    newField.setSimpleName(name);
    newField.setVisibility(JvmVisibility.PRIVATE);
    this.getDelegate().getMembers().add(newField);
    MemberDeclaration _memberDeclaration = this.getCompilationUnit().toMemberDeclaration(newField);
    final MutableFieldDeclaration mutableFieldDeclaration = ((MutableFieldDeclaration) _memberDeclaration);
    initializer.apply(mutableFieldDeclaration);
    return mutableFieldDeclaration;
  }

  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    Preconditions.checkArgument((initializer != null), "initializer cannot be null");
    final JvmOperation newMethod = TypesFactory.eINSTANCE.createJvmOperation();
    newMethod.setVisibility(JvmVisibility.PUBLIC);
    newMethod.setSimpleName(name);
    newMethod.setReturnType(this.getCompilationUnit().toJvmTypeReference(this.getCompilationUnit().getTypeReferenceProvider().getPrimitiveVoid()));
    this.getDelegate().getMembers().add(newMethod);
    MemberDeclaration _memberDeclaration = this.getCompilationUnit().toMemberDeclaration(newMethod);
    final MutableMethodDeclaration mutableMethodDeclaration = ((MutableMethodDeclaration) _memberDeclaration);
    initializer.apply(mutableMethodDeclaration);
    return mutableMethodDeclaration;
  }

  public ConstructorDeclaration findDeclaredConstructor(final TypeReference... parameterTypes) {
    ConstructorDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      final Function1<ConstructorDeclaration, Boolean> _function = (ConstructorDeclaration constructor) -> {
        final Function1<ParameterDeclaration, TypeReference> _function_1 = (ParameterDeclaration it) -> {
          return it.getType();
        };
        List<TypeReference> _list = IterableExtensions.<TypeReference>toList(IterableExtensions.map(constructor.getParameters(), _function_1));
        List<TypeReference> _list_1 = IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes)));
        return Boolean.valueOf(Objects.equal(_list, _list_1));
      };
      _xblockexpression = IterableExtensions.findFirst(this.getDeclaredConstructors(), _function);
    }
    return _xblockexpression;
  }

  public FieldDeclaration findDeclaredField(final String name) {
    final Function1<FieldDeclaration, Boolean> _function = (FieldDeclaration field) -> {
      String _simpleName = field.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredFields(), _function);
  }

  public TypeDeclaration findDeclaredType(final String name) {
    final Function1<TypeDeclaration, Boolean> _function = (TypeDeclaration type) -> {
      String _simpleName = type.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    return IterableExtensions.findFirst(this.getDeclaredTypes(), _function);
  }

  public MethodDeclaration findDeclaredMethod(final String name, final TypeReference... parameterTypes) {
    MethodDeclaration _xblockexpression = null;
    {
      ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(parameterTypes)), "parameterTypes");
      final Function1<MethodDeclaration, Boolean> _function = (MethodDeclaration method) -> {
        return Boolean.valueOf((Objects.equal(method.getSimpleName(), name) && Objects.equal(IterableExtensions.<TypeReference>toList(IterableExtensions.map(method.getParameters(), ((Function1<ParameterDeclaration, TypeReference>) (ParameterDeclaration it) -> {
          return it.getType();
        }))), IterableExtensions.<TypeReference>toList(((Iterable<TypeReference>)Conversions.doWrapArray(parameterTypes))))));
      };
      _xblockexpression = IterableExtensions.findFirst(this.getDeclaredMethods(), _function);
    }
    return _xblockexpression;
  }

  public Iterable<? extends MethodDeclaration> getDeclaredMethods() {
    return Iterables.<MethodDeclaration>filter(this.getDeclaredMembers(), MethodDeclaration.class);
  }

  public Iterable<? extends FieldDeclaration> getDeclaredFields() {
    return Iterables.<FieldDeclaration>filter(this.getDeclaredMembers(), FieldDeclaration.class);
  }

  public Iterable<? extends ClassDeclaration> getDeclaredClasses() {
    return Iterables.<ClassDeclaration>filter(this.getDeclaredMembers(), ClassDeclaration.class);
  }

  public Iterable<? extends ConstructorDeclaration> getDeclaredConstructors() {
    return Iterables.<ConstructorDeclaration>filter(this.getDeclaredMembers(), ConstructorDeclaration.class);
  }

  public Iterable<? extends InterfaceDeclaration> getDeclaredInterfaces() {
    return Iterables.<InterfaceDeclaration>filter(this.getDeclaredMembers(), InterfaceDeclaration.class);
  }

  public Iterable<? extends TypeDeclaration> getDeclaredTypes() {
    return Iterables.<TypeDeclaration>filter(this.getDeclaredMembers(), TypeDeclaration.class);
  }

  public Iterable<? extends AnnotationTypeDeclaration> getDeclaredAnnotationTypes() {
    return Iterables.<AnnotationTypeDeclaration>filter(this.getDeclaredMembers(), AnnotationTypeDeclaration.class);
  }

  public Iterable<? extends EnumerationTypeDeclaration> getDeclaredEnumerationTypes() {
    return Iterables.<EnumerationTypeDeclaration>filter(this.getDeclaredMembers(), EnumerationTypeDeclaration.class);
  }

  @Override
  public void setSimpleName(final String name) {
    throw new UnsupportedOperationException("The type cannot be renamed.");
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("The type cannot be removed.");
  }
}
