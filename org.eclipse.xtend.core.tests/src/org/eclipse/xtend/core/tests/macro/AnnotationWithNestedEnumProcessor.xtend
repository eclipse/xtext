/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.macro

import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class AnnotationWithNestedEnumProcessor extends AbstractClassProcessor {

	override doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {
		context.registerInterface(annotatedClass.interfaceName)
	}

	def getInterfaceName(ClassDeclaration annotatedClass) {
		annotatedClass.qualifiedName + "Interface"
	}

	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
		val interfaceType = findInterface(annotatedClass.interfaceName)
		interfaceType.primarySourceElement = annotatedClass
		try {
			val value = annotatedClass.findAnnotation(AnnotationWithNestedEnum.findTypeGlobally).getEnumValue("value")
			val ref = AnnotationWithNestedEnum.newAnnotationReference [
				setEnumValue("value", value)
			]
			interfaceType.addAnnotation(ref)
		} catch (Exception exc) {
			addError(annotatedClass, "failed: " + exc.message)
		}
	}

}
