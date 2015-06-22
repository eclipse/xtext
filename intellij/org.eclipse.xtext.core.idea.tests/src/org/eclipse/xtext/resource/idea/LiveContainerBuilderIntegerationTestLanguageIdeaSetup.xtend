package org.eclipse.xtext.resource.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class LiveContainerBuilderIntegerationTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new LiveContainerBuilderIntegerationTestLanguageStandaloneSetupIdea().createInjector
	}

}
