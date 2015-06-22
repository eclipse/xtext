package org.eclipse.xtext.parser.indentation.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class IndentationAwareTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new IndentationAwareTestLanguageStandaloneSetupIdea().createInjector
	}

}
