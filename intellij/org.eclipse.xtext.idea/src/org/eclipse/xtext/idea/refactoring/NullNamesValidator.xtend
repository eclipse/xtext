package org.eclipse.xtext.idea.refactoring

import com.intellij.lang.refactoring.NamesValidator
import com.intellij.openapi.project.Project

class NullNamesValidator implements NamesValidator {
	
	override isIdentifier(String name, Project project) {
		name != null
	}
	
	override isKeyword(String name, Project project) {
		false
	}
	
}