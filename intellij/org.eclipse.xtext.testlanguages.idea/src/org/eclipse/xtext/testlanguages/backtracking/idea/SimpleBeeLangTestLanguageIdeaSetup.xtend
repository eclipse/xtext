package org.eclipse.xtext.testlanguages.backtracking.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class SimpleBeeLangTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new SimpleBeeLangTestLanguageStandaloneSetupIdea().createInjector
	}

}
