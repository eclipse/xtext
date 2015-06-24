package org.eclipse.xtext.testlanguages.indent.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class IndentationAwareTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new IndentationAwareTestLanguageStandaloneSetupIdea().createInjector
	}

}
