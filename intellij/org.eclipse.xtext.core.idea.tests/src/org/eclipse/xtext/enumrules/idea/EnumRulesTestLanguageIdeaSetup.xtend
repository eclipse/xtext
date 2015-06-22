package org.eclipse.xtext.enumrules.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EnumRulesTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EnumRulesTestLanguageStandaloneSetupIdea().createInjector
	}

}
