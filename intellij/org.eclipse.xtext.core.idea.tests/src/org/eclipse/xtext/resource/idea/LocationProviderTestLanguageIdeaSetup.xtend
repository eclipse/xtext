package org.eclipse.xtext.resource.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class LocationProviderTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new LocationProviderTestLanguageStandaloneSetupIdea().createInjector
	}

}
