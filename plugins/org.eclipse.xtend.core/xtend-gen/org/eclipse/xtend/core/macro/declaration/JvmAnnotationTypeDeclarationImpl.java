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
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmAnnotationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmAnnotationType> implements MutableAnnotationTypeDeclaration {
  public MutableConstructorDeclaration addConstructor(final Procedure1<MutableConstructorDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any constructors.");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  public MutableFieldDeclaration addField(final String name, final Procedure1<MutableFieldDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any fields.");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  public MutableMethodDeclaration addMethod(final String name, final Procedure1<MutableMethodDeclaration> initializer) {
    String _simpleName = this.getSimpleName();
    String _plus = ("The annotation \'" + _simpleName);
    String _plus_1 = (_plus + "\' cannot declare any methods.");
    throw new UnsupportedOperationException(_plus_1);
  }
  
  public MutableAnnotationTypeElementDeclaration addAnnotationTypeElement(final String name, final Procedure1<MutableAnnotationTypeElementDeclaration> initializer) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    boolean _notEquals = (!Objects.equal(initializer, null));
    Preconditions.checkArgument(_notEquals, "initializer cannot be null");
    final JvmOperation newAnnotationElement = TypesFactory.eINSTANCE.createJvmOperation();
    newAnnotationElement.setSimpleName(name);
    newAnnotationElement.setVisibility(JvmVisibility.PUBLIC);
    JvmAnnotationType _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    _members.add(newAnnotationElement);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(newAnnotationElement);
    final MutableAnnotationTypeElementDeclaration mutableAnnotationTypeElementDeclaration = ((MutableAnnotationTypeElementDeclaration) _memberDeclaration);
    initializer.apply(mutableAnnotationTypeElementDeclaration);
    return mutableAnnotationTypeElementDeclaration;
  }
  
  public MutableAnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(final String name) {
    Iterable<? extends MutableAnnotationTypeElementDeclaration> _declaredAnnotationTypeElements = this.getDeclaredAnnotationTypeElements();
    final Function1<MutableAnnotationTypeElementDeclaration,Boolean> _function = new Function1<MutableAnnotationTypeElementDeclaration,Boolean>() {
      public Boolean apply(final MutableAnnotationTypeElementDeclaration it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredAnnotationTypeElements, _function);
  }
  
  public Iterable<? extends MutableAnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements() {
    JvmAnnotationType _delegate = this.getDelegate();
    EList<JvmMember> _members = _delegate.getMembers();
    final Function1<JvmMember,MutableMemberDeclaration> _function = new Function1<JvmMember,MutableMemberDeclaration>() {
      public MutableMemberDeclaration apply(final JvmMember it) {
        CompilationUnitImpl _compilationUnit = JvmAnnotationTypeDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toMemberDeclaration(it);
      }
    };
    List<MutableMemberDeclaration> _map = ListExtensions.<JvmMember, MutableMemberDeclaration>map(_members, _function);
    return Iterables.<MutableAnnotationTypeElementDeclaration>filter(_map, MutableAnnotationTypeElementDeclaration.class);
  }
}
