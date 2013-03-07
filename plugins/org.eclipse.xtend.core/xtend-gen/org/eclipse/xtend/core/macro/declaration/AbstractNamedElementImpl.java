/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;

@SuppressWarnings("all")
public abstract class AbstractNamedElementImpl<T extends EObject> extends AbstractDeclarationImpl<T> implements NamedElement {
  public String toString() {
    Class<? extends AbstractNamedElementImpl> _class = this.getClass();
    String _name = _class.getName();
    String _plus = (_name + "[");
    String _name_1 = this.getName();
    String _plus_1 = (_plus + _name_1);
    String _plus_2 = (_plus_1 + "]");
    return _plus_2;
  }
}
