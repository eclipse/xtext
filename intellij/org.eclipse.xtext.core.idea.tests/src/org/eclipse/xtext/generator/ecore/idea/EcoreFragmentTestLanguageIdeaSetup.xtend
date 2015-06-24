package org.eclipse.xtext.generator.ecore.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EcoreFragmentTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EcoreFragmentTestLanguageStandaloneSetupIdea().createInjector
	}

}
