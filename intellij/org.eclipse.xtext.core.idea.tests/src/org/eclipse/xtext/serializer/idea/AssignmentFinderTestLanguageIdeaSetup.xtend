package org.eclipse.xtext.serializer.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class AssignmentFinderTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new AssignmentFinderTestLanguageStandaloneSetupIdea().createInjector
	}

}
