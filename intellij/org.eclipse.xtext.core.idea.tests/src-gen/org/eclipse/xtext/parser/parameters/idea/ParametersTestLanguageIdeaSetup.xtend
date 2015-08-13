package org.eclipse.xtext.parser.parameters.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ParametersTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ParametersTestLanguageStandaloneSetupIdea().createInjector
	}

}
