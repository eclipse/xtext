package org.eclipse.xtext.idea.tests.parsing

import org.eclipse.emf.ecore.EObject

interface ModelChecker {
	
	def <T extends EObject> T checkModel(String code, boolean validate)
	
}