/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public abstract class JvmNamedElementImpl<T extends JvmIdentifiableElement> extends AbstractDeclarationImpl<T> implements MutableNamedElement {
  public String getName() {
    T _delegate = this.getDelegate();
    String _simpleName = _delegate.getSimpleName();
    return _simpleName;
  }
  
  public void remove() {
    T _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    boolean _equals = ObjectExtensions.operator_equals(_eContainer, null);
    if (_equals) {
      return;
    }
    T _delegate_1 = this.getDelegate();
    EObject _eContainer_1 = _delegate_1.eContainer();
    EList<EObject> _eContents = _eContainer_1.eContents();
    T _delegate_2 = this.getDelegate();
    _eContents.remove(_delegate_2);
    T _delegate_3 = this.getDelegate();
    EObject _eContainer_2 = _delegate_3.eContainer();
    boolean _notEquals = ObjectExtensions.operator_notEquals(_eContainer_2, null);
    if (_notEquals) {
      T _delegate_4 = this.getDelegate();
      String _string = _delegate_4.toString();
      String _plus = ("Couldn\'t remove " + _string);
      IllegalStateException _illegalStateException = new IllegalStateException(_plus);
      throw _illegalStateException;
    }
  }
  
  public String toString() {
    Class<? extends JvmNamedElementImpl> _class = this.getClass();
    String _name = _class.getName();
    String _plus = (_name + "[");
    String _name_1 = this.getName();
    String _plus_1 = (_plus + _name_1);
    String _plus_2 = (_plus_1 + "]");
    return _plus_2;
  }
}
