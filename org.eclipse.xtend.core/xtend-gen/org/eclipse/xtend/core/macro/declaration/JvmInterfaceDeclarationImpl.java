/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Preconditions;
import java.util.List;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmInterfaceDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements InterfaceDeclaration {
  @Override
  public Iterable<? extends TypeReference> getExtendedInterfaces() {
    List<TypeReference> _xblockexpression = null;
    {
      final Function1<JvmTypeReference, Boolean> _function = (JvmTypeReference it) -> {
        JvmType _type = it.getType();
        return Boolean.valueOf(((JvmGenericType) _type).isInterface());
      };
      final Iterable<JvmTypeReference> filtered = IterableExtensions.<JvmTypeReference>filter(this.getDelegate().getSuperTypes(), _function);
      final Function1<JvmTypeReference, TypeReference> _function_1 = (JvmTypeReference it) -> {
        return this.getCompilationUnit().toTypeReference(it);
      };
      _xblockexpression = IterableExtensions.<TypeReference>toList(IterableExtensions.<JvmTypeReference, TypeReference>map(filtered, _function_1));
    }
    return _xblockexpression;
  }

  @Override
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    final Function1<JvmTypeParameter, TypeParameterDeclaration> _function = (JvmTypeParameter it) -> {
      return this.getCompilationUnit().toTypeParameterDeclaration(it);
    };
    return ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(this.getDelegate().getTypeParameters(), _function);
  }

  @Override
  public boolean isStrictFloatingPoint() {
    return this.getDelegate().isStrictFloatingPoint();
  }

  @Override
  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    Preconditions.checkArgument((initializer != null), "initializer cannot be null");
    final JvmOperation newMethod = TypesFactory.eINSTANCE.createJvmOperation();
    newMethod.setVisibility(JvmVisibility.PUBLIC);
    newMethod.setSimpleName(name);
    newMethod.setReturnType(this.getCompilationUnit().toJvmTypeReference(this.getCompilationUnit().getTypeReferenceProvider().getPrimitiveVoid()));
    newMethod.setAbstract(true);
    this.getDelegate().getMembers().add(newMethod);
    MemberDeclaration _memberDeclaration = this.getCompilationUnit().toMemberDeclaration(newMethod);
    final MutableMethodDeclaration mutableMethodDeclaration = ((MutableMethodDeclaration) _memberDeclaration);
    initializer.apply(mutableMethodDeclaration);
    return mutableMethodDeclaration;
  }

  @Override
  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The interface \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any constructors.");
    throw new UnsupportedOperationException(_plus_1);
  }
}
