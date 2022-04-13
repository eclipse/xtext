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
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;

@SuppressWarnings("all")
public class JvmEnumerationValueDeclarationImpl extends JvmMemberDeclarationImpl<JvmEnumerationLiteral> implements EnumerationValueDeclaration {
  @Override
  public void setVisibility(final Visibility visibility) {
    throw new UnsupportedOperationException("It is not possible to change visibility of enumeration value.");
  }

  @Override
  public EnumerationTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((EnumerationTypeDeclaration) _declaringType);
  }
}
