/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtext.common.types.JvmFormalParameter;

@SuppressWarnings("all")
public class MutableJvmParameterDeclarationImpl extends JvmParameterDeclarationImpl implements MutableParameterDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
  }

  @Override
  public MutableExecutableDeclaration getDeclaringExecutable() {
    ExecutableDeclaration _declaringExecutable = super.getDeclaringExecutable();
    return ((MutableExecutableDeclaration) _declaringExecutable);
  }

  @Override
  public void setSimpleName(final String name) {
    this.checkMutable();
    ConditionUtils.checkJavaIdentifier(name, "name");
    JvmFormalParameter _delegate = this.getDelegate();
    _delegate.setName(name);
  }
}
