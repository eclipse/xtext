package org.eclipse.xtext.parser.parameters.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class NoParametersTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new NoParametersTestLanguageStandaloneSetupIdea().createInjector
	}

}
