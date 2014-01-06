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
import org.eclipse.xtend.core.macro.declaration.JvmTypeDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JvmEnumerationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmEnumerationType> implements MutableEnumerationTypeDeclaration {
  public Iterable<? extends MutableEnumerationValueDeclaration> getDeclaredValues() {
    Iterable<? extends MutableMemberDeclaration> _declaredMembers = this.getDeclaredMembers();
    return Iterables.<MutableEnumerationValueDeclaration>filter(_declaredMembers, MutableEnumerationValueDeclaration.class);
  }
  
  public MutableEnumerationValueDeclaration addValue(final String name, final Procedure1<MutableEnumerationValueDeclaration> initializer) {
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
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(jvmLiteral);
    final MutableEnumerationValueDeclaration mutableEnumerationValueDeclaration = ((MutableEnumerationValueDeclaration) _memberDeclaration);
    initializer.apply(mutableEnumerationValueDeclaration);
    return mutableEnumerationValueDeclaration;
  }
  
  public MutableEnumerationValueDeclaration findDeclaredValue(final String name) {
    Iterable<? extends MutableEnumerationValueDeclaration> _declaredValues = this.getDeclaredValues();
    final Function1<MutableEnumerationValueDeclaration,Boolean> _function = new Function1<MutableEnumerationValueDeclaration,Boolean>() {
      public Boolean apply(final MutableEnumerationValueDeclaration value) {
        String _simpleName = value.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    return IterableExtensions.findFirst(_declaredValues, _function);
  }
}
