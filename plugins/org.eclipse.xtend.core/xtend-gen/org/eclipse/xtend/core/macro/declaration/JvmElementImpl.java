/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;

@SuppressWarnings("all")
public abstract class JvmElementImpl<T extends EObject> extends AbstractElementImpl<T> {
  public void remove() {
    T _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    boolean _equals = Objects.equal(_eContainer, null);
    if (_equals) {
      return;
    }
    T _delegate_1 = this.getDelegate();
    EcoreUtil.remove(_delegate_1);
    T _delegate_2 = this.getDelegate();
    EObject _eContainer_1 = _delegate_2.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer_1, null));
    if (_notEquals) {
      T _delegate_3 = this.getDelegate();
      String _string = _delegate_3.toString();
      String _plus = ("Couldn\'t remove " + _string);
      throw new IllegalStateException(_plus);
    }
  }
}
