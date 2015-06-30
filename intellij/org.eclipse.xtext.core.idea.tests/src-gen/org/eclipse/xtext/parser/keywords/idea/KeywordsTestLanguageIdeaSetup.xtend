package org.eclipse.xtext.parser.keywords.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class KeywordsTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new KeywordsTestLanguageStandaloneSetupIdea().createInjector
	}

}
