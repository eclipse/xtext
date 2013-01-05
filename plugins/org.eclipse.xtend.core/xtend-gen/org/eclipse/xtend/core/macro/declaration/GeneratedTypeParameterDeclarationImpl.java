/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.TypeParameterDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeParameterDeclarator;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;

@SuppressWarnings("all")
public class GeneratedTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements GeneratedTypeParameterDeclaration {
  public GeneratedTypeParameterDeclarator getTypeParameterDeclarator() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmTypeParameter _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(((JvmExecutable) _eContainer));
    return ((GeneratedTypeParameterDeclarator) _memberDeclaration);
  }
}
