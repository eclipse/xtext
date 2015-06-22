package org.eclipse.xtext.parsetree.reconstr.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class Bug302128TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new Bug302128TestLanguageStandaloneSetupIdea().createInjector
	}

}
