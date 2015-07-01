package org.eclipse.xtext.parser.datatyperules.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class DatatypeRulesTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new DatatypeRulesTestLanguageStandaloneSetupIdea().createInjector
	}

}
