/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.Element
import org.eclipse.xtend.lib.macro.services.Problem
import org.eclipse.xtend.lib.macro.services.ProblemSupport
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import static org.eclipse.xtend.core.macro.ActiveAnnotationContexts.AnnotationCallback.*
import java.util.List
import java.util.Collections

class ProblemSupportImpl implements ProblemSupport {
	
	CompilationUnitImpl compilationUnit
	val List<()=> void> delayedTasks = newArrayList
	
	new (CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}
	
	private def checkCanceled() {
		compilationUnit.checkCanceled
	}
	
	private def checkValidationAllowed() {
		if (compilationUnit.lastPhase > VALIDATION)
			throw new IllegalStateException("Adding problems is not allowed after the validation phase")
	}
	
	override addError(Element element, String message) {
		checkCanceled
		checkValidationAllowed
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.errors.add(new EObjectDiagnosticImpl(Severity.ERROR, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override addWarning(Element element, String message) {
		checkCanceled
		checkValidationAllowed
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.warnings.add(new EObjectDiagnosticImpl(Severity.WARNING, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override validateLater(()=>void validationCallback) {
		if(compilationUnit.lastPhase < VALIDATION) {
			delayedTasks.add(validationCallback)
		} else {
			validationCallback.apply
		}
	}
	
	def validationPhaseStarted() {
		try {
			delayedTasks.forEach[apply]
		} catch (Throwable t) {
			compilationUnit.handleProcessingError(Collections.singleton(compilationUnit.xtendFile) , compilationUnit.xtendFile.eResource, t)
		} finally {
			delayedTasks.clear
		}
	}
	
	override getProblems(Element element) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		val resource = resAndObj.key
		val issues = (resource.errors + resource.warnings).filter(EObjectDiagnosticImpl)
		
		val result = issues.filter[diag | diag.problematicObject == resAndObj.value ].map[ diag |
			new ProblemImpl(diag.code, diag.message, translateSeverity(diag.severity)) as Problem
		]
		return result.toList
	}
	
	def EStructuralFeature getSignificantFeature(EObject obj) {
		return switch obj {
			XtendTypeDeclaration : XtendPackage.eINSTANCE.xtendTypeDeclaration_Name
			XtendField : XtendPackage.eINSTANCE.xtendField_Name
			XtendFunction : XtendPackage.eINSTANCE.xtendFunction_Name
			// FIXME: find something appropriate for constructors
			//XtendConstructor : XtendPackage.eINSTANCE.xtendConstructor_Name
			JvmFormalParameter : TypesPackage.eINSTANCE.jvmFormalParameter_Name
			XAnnotation : XAnnotationsPackage.eINSTANCE.XAnnotation_AnnotationType
		}
	}
	
	def private Pair<Resource,EObject> getResourceAndEObject(Element element) {
		checkCanceled
		switch element {
			CompilationUnitImpl case element == compilationUnit: {
				return compilationUnit.xtendFile.eResource -> compilationUnit.xtendFile
			}
			AbstractElementImpl<? extends EObject>: {
				val resource = element.delegate.eResource
				if (resource == compilationUnit.xtendFile.eResource) {
					val eobject = compilationUnit.jvmModelAssociations.getPrimarySourceElement(element.delegate)
					if (eobject === null) {
						return resource -> element.delegate
					}
					return resource -> eobject
				}
			} 
		}
		throw new IllegalArgumentException("You can only add issues on locally declared elements.")
	}
	
	def private Problem.Severity translateSeverity(Severity severity) {
		switch (severity) {
			case Severity.ERROR : Problem.Severity.ERROR
			case Severity.WARNING : Problem.Severity.WARNING
			case Severity.INFO : Problem.Severity.INFO
			case Severity.IGNORE : Problem.Severity.IGNORE
		}
	}
}


class ProblemImpl implements Problem {
	
	String id
	String message
	Problem.Severity severity	
	
	new(String id,
	String message,
	Problem.Severity severity) {
		this.id = id
		this.message = message
		this.severity = severity
	}

	override getId() {
		return id
	}
	
	override getMessage() {
		return message
	}
	
	override getSeverity() {
		return severity
	}
	
}