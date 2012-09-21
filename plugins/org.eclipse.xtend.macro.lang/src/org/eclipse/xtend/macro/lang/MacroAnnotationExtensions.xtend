/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 
package org.eclipse.xtend.macro.lang

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation
import org.eclipse.xtend.macro.lang.macro.Processor
import org.eclipse.xtend.macro.lang.macro.Registrator
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.diagnostics.Severity

class MacroAnnotationExtensions {
	
	@Inject extension IQualifiedNameProvider
	@Inject extension IJvmModelAssociations
	@Inject extension IResourceValidator
	
	def getFields(MacroAnnotation macro) {
		macro.members.filter(typeof(XtendField))
	}
	
	def String getQualifiedName(MacroAnnotation it) {
		fullyQualifiedName.toString
	}
	
	def Processor getProcessor(MacroAnnotation macro) {
		macro.members.filter(typeof(Processor)).head
	}
	
	def String getProcessorClassName(MacroAnnotation it) {
		qualifiedName+"Processor"
	}
	
	def JvmGenericType getProcessorClass(MacroAnnotation macro) {
		macro.jvmElements.filter(typeof(JvmGenericType)).findFirst[ identifier == macro.processorClassName]
	}
	
	def Registrator getRegistrator(MacroAnnotation macro) {
		macro.members.filter(typeof(Registrator)).head
	}
	
	def String getRegistratorClassName(MacroAnnotation it) {
		qualifiedName+"Registrator"
	}
	
	def JvmGenericType getRegistratorClass(MacroAnnotation macro) {
		macro.jvmElements.filter(typeof(JvmGenericType)).findFirst[ identifier == macro.registratorClassName]
	}
	
	def boolean hasErrors(MacroAnnotation macro) {
		val issues = macro.eResource.validate(CheckMode::ALL, CancelIndicator::NullImpl)
		return !issues.filter[severity == Severity::ERROR].empty
	}
}