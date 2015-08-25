package org.eclipse.xtext.xtext.generator

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.annotations.Accessors

@FinalFieldsConstructor
class MweIssues implements Issues {
	@Accessors val XtextGenerator owner
	@Accessors val org.eclipse.emf.mwe.core.issues.Issues delegate
	
	override addError(String message) {
		delegate.addError(owner, message)
	}
	
	override addError(String message, Object source) {
		delegate.addError(owner, message, source)
	}
	
	override addWarning(String message) {
		delegate.addWarning(owner, message)
	}
	
	override addWarning(String message, Object source) {
		delegate.addWarning(owner, message, source)
	}
	
}