package org.eclipse.xtext.parser.antlr.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class Bug289524ExTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new Bug289524ExTestLanguageStandaloneSetupIdea().createInjector
	}

}
