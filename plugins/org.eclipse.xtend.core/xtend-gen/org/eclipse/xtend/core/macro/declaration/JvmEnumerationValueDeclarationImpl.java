/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;

@SuppressWarnings("all")
public class JvmEnumerationValueDeclarationImpl extends JvmMemberDeclarationImpl<JvmEnumerationLiteral> implements EnumerationValueDeclaration {
  public void setVisibility(final Visibility visibility) {
    throw new UnsupportedOperationException("It is not possible to change visibility of enumeration value.");
  }
  
  public EnumerationTypeDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((EnumerationTypeDeclaration) _declaringType);
  }
}
