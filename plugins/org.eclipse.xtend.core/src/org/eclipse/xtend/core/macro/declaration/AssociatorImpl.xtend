/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtend.lib.macro.services.Associator

class AssociatorImpl implements Associator {
	
	CompilationUnitImpl unit
	
	new (CompilationUnitImpl unit) {
		this.unit = unit
	}
	
	override setPrimarySourceElement(MutableNamedElement secondaryElement, NamedElement primaryElement) {
		val sourceElement = unit.tracability.getPrimarySourceElement(primaryElement)
		unit.jvmAssociator.associate((sourceElement as XtendNamedElementImpl<?>).delegate, (secondaryElement as JvmNamedElementImpl<?>).delegate)
	}
}