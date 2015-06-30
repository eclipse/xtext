package org.eclipse.xtext.parser.antlr.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class Bug299237TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new Bug299237TestLanguageStandaloneSetupIdea().createInjector
	}

}
