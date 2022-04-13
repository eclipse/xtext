/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;

@SuppressWarnings("all")
public class MutableJvmAnnotationTypeElementDeclarationImpl extends JvmAnnotationTypeElementDeclarationImpl implements MutableAnnotationTypeElementDeclaration {
  @Override
  public void markAsRead() {
    this.checkMutable();
    this.getCompilationUnit().getReadAndWriteTracking().markReadAccess(this.getDelegate());
  }

  @Override
  public MutableTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableTypeDeclaration) _declaringType);
  }
}
