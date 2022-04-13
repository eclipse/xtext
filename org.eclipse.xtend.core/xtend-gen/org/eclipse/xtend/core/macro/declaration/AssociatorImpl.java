/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MutableElement;
import org.eclipse.xtend.lib.macro.services.Associator;

@SuppressWarnings("all")
public class AssociatorImpl implements Associator {
  private CompilationUnitImpl unit;

  public AssociatorImpl(final CompilationUnitImpl unit) {
    this.unit = unit;
  }

  @Override
  public void setPrimarySourceElement(final MutableElement javaElement, final Element sourceElement) {
    final Element primarySourceElement = this.unit.getTracability().getPrimarySourceElement(sourceElement);
    EObject _switchResult = null;
    boolean _matched = false;
    if (primarySourceElement instanceof TypeReferenceImpl) {
      _matched=true;
      _switchResult = ((TypeReferenceImpl)primarySourceElement).getSource();
    }
    if (!_matched) {
      if (primarySourceElement instanceof AbstractElementImpl) {
        _matched=true;
        _switchResult = ((AbstractElementImpl<?>)primarySourceElement).getDelegate();
      }
    }
    final EObject delegate = _switchResult;
    this.unit.getJvmModelAssociator().associate(delegate, ((AbstractElementImpl<?>) javaElement).getDelegate());
  }
}
