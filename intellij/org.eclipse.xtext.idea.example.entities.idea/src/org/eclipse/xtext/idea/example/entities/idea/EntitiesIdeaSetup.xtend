package org.eclipse.xtext.idea.example.entities.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EntitiesIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EntitiesStandaloneSetupIdea().createInjector
	}

}
