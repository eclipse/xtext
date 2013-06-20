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
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

@SuppressWarnings("all")
public abstract class JvmNamedElementImpl<T extends JvmIdentifiableElement> extends AbstractElementImpl<T> implements MutableNamedElement {
  public String getSimpleName() {
    T _delegate = this.getDelegate();
    String _simpleName = _delegate.getSimpleName();
    return _simpleName;
  }
  
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
      IllegalStateException _illegalStateException = new IllegalStateException(_plus);
      throw _illegalStateException;
    }
  }
  
  public String toString() {
    Class<? extends JvmNamedElementImpl> _class = this.getClass();
    String _name = _class.getName();
    String _plus = (_name + "[");
    String _simpleName = this.getSimpleName();
    String _plus_1 = (_plus + _simpleName);
    String _plus_2 = (_plus_1 + "]");
    return _plus_2;
  }
}
