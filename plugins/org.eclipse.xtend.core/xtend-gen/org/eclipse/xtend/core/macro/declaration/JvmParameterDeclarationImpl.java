/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTargetImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class JvmParameterDeclarationImpl extends JvmAnnotationTargetImpl<JvmFormalParameter> implements MutableParameterDeclaration {
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmFormalParameter _delegate = this.getDelegate();
    JvmTypeReference _parameterType = _delegate.getParameterType();
    return _compilationUnit.toTypeReference(_parameterType);
  }
  
  public MutableExecutableDeclaration getDeclaringExecutable() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmFormalParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    MutableMemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(((JvmMember) _eContainer));
    return ((MutableExecutableDeclaration) _memberDeclaration);
  }
  
  public void setSimpleName(final String name) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    JvmFormalParameter _delegate = this.getDelegate();
    _delegate.setName(name);
  }
}
