/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.core.macro.declaration.TracabilityImpl;
import org.eclipse.xtend.core.macro.declaration.XtendNamedElementImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.services.Associator;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;

@SuppressWarnings("all")
public class AssociatorImpl implements Associator {
  private CompilationUnitImpl unit;
  
  public AssociatorImpl(final CompilationUnitImpl unit) {
    this.unit = unit;
  }
  
  public void setPrimarySourceElement(final MutableNamedElement secondaryElement, final NamedElement primaryElement) {
    TracabilityImpl _tracability = this.unit.getTracability();
    final NamedElement sourceElement = _tracability.getPrimarySourceElement(primaryElement);
    IJvmModelAssociator _jvmAssociator = this.unit.getJvmAssociator();
    EObject _delegate = ((XtendNamedElementImpl<?>) sourceElement).getDelegate();
    JvmIdentifiableElement _delegate_1 = ((JvmNamedElementImpl<?>) secondaryElement).getDelegate();
    _jvmAssociator.associate(_delegate, _delegate_1);
  }
}
