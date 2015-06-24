package org.eclipse.xtext.generator.grammarAccess.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class GrammarAccessTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new GrammarAccessTestLanguageStandaloneSetupIdea().createInjector
	}

}
