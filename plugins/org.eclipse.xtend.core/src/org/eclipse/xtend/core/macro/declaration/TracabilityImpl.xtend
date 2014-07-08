/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.core.xtend.XtendMember
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.xtend.lib.macro.services.Tracability
import org.eclipse.xtext.common.types.JvmIdentifiableElement

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class TracabilityImpl implements Tracability {
	
	CompilationUnitImpl unit
	
	new (CompilationUnitImpl unit) {
		this.unit = unit
	}
	
	override isExternal(NamedElement element) {
		!isSource(element) && !isGenerated(element)
	}

	override isGenerated(NamedElement element) {
		switch element {
			JvmNamedElementImpl<? extends JvmIdentifiableElement>: {
				return element.delegate.eResource == unit.xtendFile.eResource
			}
			default:
				false
		}
	}

	override isSource(NamedElement element) {
		element instanceof XtendNamedElementImpl<?>
	}

	override getPrimaryGeneratedJavaElement(NamedElement source) {
		if (isSource(source)) {
			val derivedElement = unit.jvmAssociations.getJvmElements((source as XtendNamedElementImpl<?>).delegate).filter(
				JvmIdentifiableElement).head
			if (derivedElement !== null) {
				return unit.toNamedElement(derivedElement)
			}
		} else if (isGenerated(source)) {
			return source
		}
		return null
	}
	
	override getPrimarySourceElement(NamedElement target) {
		if (isGenerated(target)) {
			val sourceElement = unit.jvmAssociations.getSourceElements((target as JvmNamedElementImpl<?>).delegate).head
			if (sourceElement instanceof XtendMember) {
				return unit.toXtendMemberDeclaration(sourceElement)
			} else if (sourceElement instanceof XtendParameter) {
				return unit.toXtendParameterDeclaration(sourceElement)
			}
		} else if (isSource(target)) {
			return target
		}
	}

	override isThePrimaryGeneratedJavaElement(NamedElement target) {
		val source = target.primarySourceElement
		if (source === null)
			return false;
		source.getPrimaryGeneratedJavaElement == target
	}
}