/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;

@SuppressWarnings("all")
public class XtendEnumerationValueDeclarationImpl extends XtendMemberDeclarationImpl<XtendEnumLiteral> implements EnumerationValueDeclaration {
  public String getSimpleName() {
    XtendEnumLiteral _delegate = this.getDelegate();
    String _name = _delegate.getName();
    return _name;
  }
}
