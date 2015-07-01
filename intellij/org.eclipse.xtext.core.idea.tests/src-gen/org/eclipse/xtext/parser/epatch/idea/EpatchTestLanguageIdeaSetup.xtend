package org.eclipse.xtext.parser.epatch.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EpatchTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EpatchTestLanguageStandaloneSetupIdea().createInjector
	}

}
