/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmElementImpl;
import org.eclipse.xtend.core.macro.declaration.TracabilityImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.lib.macro.declaration.Element;
import org.eclipse.xtend.lib.macro.declaration.MutableElement;
import org.eclipse.xtend.lib.macro.services.Associator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;

@SuppressWarnings("all")
public class AssociatorImpl implements Associator {
  private CompilationUnitImpl unit;
  
  public AssociatorImpl(final CompilationUnitImpl unit) {
    this.unit = unit;
  }
  
  @Override
  public void setPrimarySourceElement(final MutableElement javaElement, final Element sourceElement) {
    TracabilityImpl _tracability = this.unit.getTracability();
    final Element primarySourceElement = _tracability.getPrimarySourceElement(sourceElement);
    EObject _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (primarySourceElement instanceof TypeReferenceImpl) {
        _matched=true;
        _switchResult = ((TypeReferenceImpl)primarySourceElement).getSource();
      }
    }
    if (!_matched) {
      if (primarySourceElement instanceof AbstractElementImpl) {
        _matched=true;
        _switchResult = ((AbstractElementImpl<?>)primarySourceElement).getDelegate();
      }
    }
    final EObject delegate = _switchResult;
    IJvmModelAssociator _jvmModelAssociator = this.unit.getJvmModelAssociator();
    EObject _delegate = ((JvmElementImpl<?>) javaElement).getDelegate();
    _jvmModelAssociator.associate(delegate, _delegate);
  }
}
