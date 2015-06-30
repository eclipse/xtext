package org.eclipse.xtext.testlanguages.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ActionTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ActionTestLanguageStandaloneSetupIdea().createInjector
	}

}
