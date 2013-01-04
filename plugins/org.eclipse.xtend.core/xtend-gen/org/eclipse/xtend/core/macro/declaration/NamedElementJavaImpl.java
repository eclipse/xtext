/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

@SuppressWarnings("all")
public abstract class NamedElementJavaImpl<T extends JvmIdentifiableElement> extends AbstractDeclarationImpl<T> implements NamedElement {
  public String getName() {
    JvmIdentifiableElement _delegate = this.getDelegate();
    String _simpleName = _delegate.getSimpleName();
    return _simpleName;
  }
}
