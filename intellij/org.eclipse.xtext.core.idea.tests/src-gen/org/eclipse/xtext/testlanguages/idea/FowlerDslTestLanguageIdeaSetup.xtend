package org.eclipse.xtext.testlanguages.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class FowlerDslTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new FowlerDslTestLanguageStandaloneSetupIdea().createInjector
	}

}
