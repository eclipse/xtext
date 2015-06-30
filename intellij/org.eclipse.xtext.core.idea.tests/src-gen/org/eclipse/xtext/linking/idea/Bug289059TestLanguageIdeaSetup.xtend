package org.eclipse.xtext.linking.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class Bug289059TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new Bug289059TestLanguageStandaloneSetupIdea().createInjector
	}

}
