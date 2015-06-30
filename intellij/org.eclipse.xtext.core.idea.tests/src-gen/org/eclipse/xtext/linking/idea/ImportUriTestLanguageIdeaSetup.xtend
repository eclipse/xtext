package org.eclipse.xtext.linking.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ImportUriTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ImportUriTestLanguageStandaloneSetupIdea().createInjector
	}

}
