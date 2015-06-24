package org.eclipse.xtext.xtext.ecoreInference.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class MultiValueFeatureTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new MultiValueFeatureTestLanguageStandaloneSetupIdea().createInjector
	}

}
