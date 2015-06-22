package org.eclipse.xtext.parsetree.reconstr.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class SerializationBug269362TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new SerializationBug269362TestLanguageStandaloneSetupIdea().createInjector
	}

}
