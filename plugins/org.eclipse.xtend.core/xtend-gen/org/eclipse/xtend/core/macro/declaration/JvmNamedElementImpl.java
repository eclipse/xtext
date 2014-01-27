/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmElementImpl;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

@SuppressWarnings("all")
public abstract class JvmNamedElementImpl<T extends JvmIdentifiableElement> extends JvmElementImpl<T> {
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    return _delegate.getSimpleName();
  }
  
  public String toString() {
    Class<? extends JvmNamedElementImpl> _class = this.getClass();
    String _name = _class.getName();
    String _plus = (_name + "[");
    String _simpleName = this.getSimpleName();
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "]");
  }
}
