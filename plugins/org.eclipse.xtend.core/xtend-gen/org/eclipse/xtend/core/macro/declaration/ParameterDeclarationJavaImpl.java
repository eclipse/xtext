/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.NamedElementJavaImpl;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class ParameterDeclarationJavaImpl extends NamedElementJavaImpl<JvmFormalParameter> implements ParameterDeclaration {
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmFormalParameter _delegate = this.getDelegate();
    JvmTypeReference _parameterType = _delegate.getParameterType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_parameterType);
    return _typeReference;
  }
}
