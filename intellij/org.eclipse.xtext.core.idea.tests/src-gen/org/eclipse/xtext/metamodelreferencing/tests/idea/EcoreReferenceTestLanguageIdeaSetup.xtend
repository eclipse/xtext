package org.eclipse.xtext.metamodelreferencing.tests.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EcoreReferenceTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EcoreReferenceTestLanguageStandaloneSetupIdea().createInjector
	}

}
