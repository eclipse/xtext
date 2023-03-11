/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationValueDeclaration;

@SuppressWarnings("all")
public class MutableJvmEnumerationValueDeclarationImpl extends JvmEnumerationValueDeclarationImpl implements MutableEnumerationValueDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
  }

  @Override
  public MutableEnumerationTypeDeclaration getDeclaringType() {
    EnumerationTypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableEnumerationTypeDeclaration) _declaringType);
  }
}
