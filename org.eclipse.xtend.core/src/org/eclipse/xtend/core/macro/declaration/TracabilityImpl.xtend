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
import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtend.lib.macro.services.Tracability

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class TracabilityImpl implements Tracability {
	
	CompilationUnitImpl unit
	
	new (CompilationUnitImpl unit) {
		this.unit = unit
	}
	
	override getPrimaryGeneratedJavaElement(Element source) {
		if (isSource(source)) {
			val derivedElement = unit.jvmModelAssociations.getJvmElements((source as AbstractElementImpl<?>).delegate).head
			if (derivedElement !== null) {
				return unit.toJvmElement(derivedElement)
			}
		} else if (isGenerated(source)) {
			return source
		}
		return null
	}
	
	override getPrimarySourceElement(Element target) {
		if (isGenerated(target)) {
			val sourceElement = unit.jvmModelAssociations.getSourceElements((target as AbstractElementImpl<?>).delegate).head
			return unit.toXtendElement(sourceElement)
		} else if (isSource(target)) {
			return target
		}
	}
	
	override isExternal(Element element) {
		!isSource(element) && !isGenerated(element)
	}
	
	override isGenerated(Element element) {
		switch element {
			JvmElementImpl<?> :{
				return element.delegate.eResource == unit.xtendFile.eResource
			}
			JvmTypeParameterDeclarationImpl :{
				return element.delegate.eResource == unit.xtendFile.eResource
			}
			default:
				false
		}
	}
	
	override isSource(Element element) {
		switch element {
			XtendNamedElementImpl<?>: true
			XtendAnnotationReferenceImpl: true
			Expression : true
			TypeReferenceImpl case element.source !== null : true
			default :false
		}
	}
	
	override isThePrimaryGeneratedJavaElement(Element target) {
		val source = target.primarySourceElement
		if (source === null)
			return false;
		source.getPrimaryGeneratedJavaElement == target
	}
	
}