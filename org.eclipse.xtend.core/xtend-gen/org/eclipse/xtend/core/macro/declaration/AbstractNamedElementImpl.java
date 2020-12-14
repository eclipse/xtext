/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;

@SuppressWarnings("all")
public abstract class AbstractNamedElementImpl<T extends EObject> extends AbstractElementImpl<T> implements NamedElement {
  @Override
  public String toString() {
    String _name = this.getClass().getName();
    String _plus = (_name + "[");
    String _simpleName = this.getSimpleName();
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "]");
  }
}
