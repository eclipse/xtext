/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.Element
import org.eclipse.xtend.lib.macro.declaration.MutableElement
import org.eclipse.xtend.lib.macro.services.Associator

class AssociatorImpl implements Associator {
	
	CompilationUnitImpl unit
	
	new (CompilationUnitImpl unit) {
		this.unit = unit
	}
	
	override setPrimarySourceElement(MutableElement javaElement, Element sourceElement) {
		val primarySourceElement = unit.tracability.getPrimarySourceElement(sourceElement)
		val delegate = switch primarySourceElement {
			TypeReferenceImpl: primarySourceElement.source
			AbstractElementImpl<?>: primarySourceElement.delegate
		}
		unit.jvmModelAssociator.associate(delegate, (javaElement as AbstractElementImpl<?>).delegate)
	}
	
}