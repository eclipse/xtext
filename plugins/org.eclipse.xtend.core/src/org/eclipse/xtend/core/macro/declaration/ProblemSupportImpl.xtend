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
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.xtext.diagnostics.Severity

class ProblemSupportImpl implements ProblemSupport {
	
	CompilationUnitImpl compilationUnit
	new (CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}
	
	private def checkCanceled() {
		compilationUnit.checkCanceled
	}
	
	override addError(Element element, String message) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.errors.add(new EObjectDiagnosticImpl(Severity::ERROR, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override addInfo(Element element, String message) {
		checkCanceled
//		val resAndObj = getResourceAndEObject(element)
//		resAndObj.key.errors.add(new EObjectDiagnosticImpl(Severity::INFO, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override addWarning(Element element, String message) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.warnings.add(new EObjectDiagnosticImpl(Severity::WARNING, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override getProblems(Element element) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		val resource = resAndObj.key
		val issues = (resource.errors + resource.warnings).filter(typeof(EObjectDiagnosticImpl))
		
		val result = issues.filter[diag | diag.problematicObject == resAndObj.value ].map[ diag |
			new ProblemImpl(diag.code, diag.message, translateSeverity(diag.severity)) as Problem
		]
		return result.toList
	}
	
	def EStructuralFeature getSignificantFeature(EObject obj) {
		return switch obj {
			XtendTypeDeclaration : XtendPackage::eINSTANCE.xtendTypeDeclaration_Name
			XtendField : XtendPackage::eINSTANCE.xtendField_Name
			XtendFunction : XtendPackage::eINSTANCE.xtendFunction_Name
			// FIXME: find something appropriate for constructors
			//XtendConstructor : XtendPackage::eINSTANCE.xtendConstructor_Name
			JvmFormalParameter : TypesPackage::eINSTANCE.jvmFormalParameter_Name
		}
	}
	
	def private getResourceAndEObject(Element element) {
		checkCanceled
		switch element {
			XtendNamedElementImpl<? extends EObject>: {
				val resource = element.delegate.eResource
				val eobject = element.delegate
				return resource -> eobject
			}
			JvmNamedElementImpl<JvmIdentifiableElement> : {
				val resource = element.delegate.eResource
				if (resource == compilationUnit.xtendFile.eResource) {
					val eobject = compilationUnit.jvmAssociations.getPrimarySourceElement(element.delegate)
					return resource -> eobject
				}
			} 
		}
		throw new IllegalArgumentException("You can only add issues on locally declared elements.")
	}
	
	def private Problem$Severity translateSeverity(Severity severity) {
		switch (severity) {
			case Severity::ERROR : Problem$Severity::ERROR
			case Severity::WARNING : Problem$Severity::WARNING
			case Severity::INFO : Problem$Severity::INFO
			case Severity::IGNORE : Problem$Severity::IGNORE
		}
	}
}


class ProblemImpl implements Problem {
	
	String id
	String message
	Problem$Severity severity	
	
	new(String id,
	String message,
	Problem$Severity severity) {
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