/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;

@SuppressWarnings("all")
public class XtendEnumerationValueDeclarationImpl extends XtendMemberDeclarationImpl<XtendEnumLiteral> implements EnumerationValueDeclaration {
  @Override
  public String getSimpleName() {
    return this.getDelegate().getName();
  }

  @Override
  public EnumerationTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((EnumerationTypeDeclaration) _declaringType);
  }
}
