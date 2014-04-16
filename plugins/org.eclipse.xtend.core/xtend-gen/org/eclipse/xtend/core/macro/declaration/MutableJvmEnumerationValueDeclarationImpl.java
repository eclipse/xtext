/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmEnumerationValueDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationValueDeclaration;

@SuppressWarnings("all")
public class MutableJvmEnumerationValueDeclarationImpl extends JvmEnumerationValueDeclarationImpl implements MutableEnumerationValueDeclaration {
  public MutableEnumerationTypeDeclaration getDeclaringType() {
    EnumerationTypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableEnumerationTypeDeclaration) _declaringType);
  }
}
