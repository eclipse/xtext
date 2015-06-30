package org.eclipse.xtext.parser.assignments.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class Bug287184TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new Bug287184TestLanguageStandaloneSetupIdea().createInjector
	}

}
