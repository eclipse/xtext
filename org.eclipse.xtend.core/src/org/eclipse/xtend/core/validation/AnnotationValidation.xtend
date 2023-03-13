/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.annotations.validation.AnnotationValueValidator
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AnnotationValidation extends AbstractDeclarativeValidator {
	
	@Inject
	AnnotationValueValidator annotationValueValidator;
	
	override protected getEPackages() {
		newArrayList(XtendPackage.eINSTANCE, XbasePackage.eINSTANCE, XAnnotationsPackage.eINSTANCE)
	}
	
	@Check 
	def checkAnnotation(XtendAnnotationType it) {
		for (it : members.filter(XtendField)) {
			if (!isValidAnnotationValueType(type)) {
				error('''Invalid type «type.simpleName» for the annotation attribute «name»; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof''',
					it,
					XTEND_FIELD__TYPE,
					IssueCodes.INVALID_ANNOTATION_VALUE_TYPE
				)
			}
			if(initialValue !== null) {
				annotationValueValidator.validateAnnotationValue(initialValue, this)
			}
		}
	}
	
	def boolean isValidAnnotationValueType(JvmTypeReference reference) {
		val toCheck = switch reference {
			JvmGenericArrayTypeReference : 
				reference.componentType
			default : reference
		}
		if (toCheck === null)
			return true;
		if (toCheck.type instanceof JvmPrimitiveType) 
			return true
		if (toCheck.type instanceof JvmEnumerationType)
			return true
		if (toCheck.type instanceof JvmAnnotationType)
			return true
		if (toCheck.type.qualifiedName == 'java.lang.String' 
			|| toCheck.type.qualifiedName == 'java.lang.Class') 
			return true
		return false
	}

}