package org.eclipse.xtext.validation.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ConcreteSyntaxValidationTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ConcreteSyntaxValidationTestLanguageStandaloneSetupIdea().createInjector
	}

}
