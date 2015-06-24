package org.eclipse.xtext.parser.assignments.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class AssignmentsTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new AssignmentsTestLanguageStandaloneSetupIdea().createInjector
	}

}
