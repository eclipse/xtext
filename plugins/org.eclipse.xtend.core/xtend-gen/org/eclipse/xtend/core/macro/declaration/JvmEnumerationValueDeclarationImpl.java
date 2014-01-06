/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;

@SuppressWarnings("all")
public class JvmEnumerationValueDeclarationImpl extends JvmMemberDeclarationImpl<JvmEnumerationLiteral> implements MutableEnumerationValueDeclaration {
  public void setVisibility(final Visibility visibility) {
    throw new UnsupportedOperationException("It is not possible to change visibility of enumeration value.");
  }
  
  public MutableEnumerationTypeDeclaration getDeclaringType() {
    MutableTypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableEnumerationTypeDeclaration) _declaringType);
  }
}
