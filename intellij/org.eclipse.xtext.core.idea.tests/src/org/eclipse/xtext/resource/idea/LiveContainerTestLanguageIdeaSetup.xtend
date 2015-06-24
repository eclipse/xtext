package org.eclipse.xtext.resource.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class LiveContainerTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new LiveContainerTestLanguageStandaloneSetupIdea().createInjector
	}

}
