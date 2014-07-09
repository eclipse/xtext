/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmParameterDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.validation.ReadAndWriteTracking;

@SuppressWarnings("all")
public class MutableJvmParameterDeclarationImpl extends JvmParameterDeclarationImpl implements MutableParameterDeclaration {
  public void markAsRead() {
    this.checkMutable();
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    ReadAndWriteTracking _readAndWriteTracking = _compilationUnit.getReadAndWriteTracking();
    JvmFormalParameter _delegate = this.getDelegate();
    _readAndWriteTracking.markReadAccess(_delegate);
  }
  
  public MutableExecutableDeclaration getDeclaringExecutable() {
    ExecutableDeclaration _declaringExecutable = super.getDeclaringExecutable();
    return ((MutableExecutableDeclaration) _declaringExecutable);
  }
  
  public void setSimpleName(final String name) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    JvmFormalParameter _delegate = this.getDelegate();
    _delegate.setName(name);
  }
}
