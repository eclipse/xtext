/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.presentation

import com.google.inject.Inject
import javax.swing.Icon
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import org.eclipse.xtext.xbase.validation.UIStrings

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendItemPresentationProvider extends XtendJvmItemPresentationProvider {

	@Inject
	UIStrings uiStrings

	@Inject
	extension IXtendJvmAssociations

	@Inject OperatorMapping operatorMapping
	
	def dispatch Icon image(XtendTypeDeclaration element) {
		element.inferredType.image
	}
	
	def dispatch Icon image(XtendFunction element) {
		element.directlyInferredOperation.image
	}
	
	def dispatch Icon image(XtendConstructor element) {
		element.inferredConstructor.image
	}
	
	def dispatch Icon image(XtendField element) {
		element.jvmField.image
	}
	
	def dispatch Icon image(XtendEnumLiteral element) {
		element.jvmField.image
	}

	def dispatch String text(XtendFile element) {
		element.eResource.URI.trimFileExtension.lastSegment
	}

	def dispatch String text(XtendClass element) {
		element.name + if (element.typeParameters.empty)
			""
		else
			uiStrings.typeParameters(element.typeParameters)
	}

	def dispatch String text(XtendInterface element) {
		element.name + if (element.typeParameters.empty)
			""
		else
			uiStrings.typeParameters(element.typeParameters)
	}

	def dispatch String text(AnonymousClass element) {
		element.inferredType.text
	}

	def dispatch text(XtendConstructor element) {
		"new" + uiStrings.parameters(element.inferredConstructor)
	}

	def dispatch text(XtendFunction element) {
		val simpleName = element.name
		if (simpleName !== null) {
			val qnName = QualifiedName.create(simpleName)
			val operator = operatorMapping.getOperator(qnName)
			if (operator !== null) {
				return signature(operator.firstSegment, element.directlyInferredOperation) + ' (' + simpleName + ')'
			}
		}
		return signature(element.name, element.directlyInferredOperation)
	}

	def dispatch text(XtendField element) {
		if (element.name === null && element.extension)
			return uiStrings.referenceToString(element.type, "extension")
		val fieldType = element.displayedType
		if (fieldType !== null) {
			val type = uiStrings.referenceToString(fieldType, "")
			if (type.length != 0) {
				return element.name + " : " + type
			}
		}
		element.name
	}

	def dispatch text(XtendEnumLiteral element) {
		element.name
	}
	
	def dispatch text(XtendParameter element) {
		 element.parameterType.simpleName + " " + element.name
	}

	protected def JvmTypeReference getDisplayedType(XtendField field) {
		val jvmField = field.jvmField
		if (jvmField !== null) {
			return jvmField.getType
		} else {
			val i = field.jvmElements.iterator
			if (i.hasNext) {
				val next = i.next
				if (next instanceof JvmOperation)
					return next.getReturnType
			}
		}
		null
	}
	
}