package org.eclipse.xtext.parser.fragments.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class FragmentTestLanguageExIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new FragmentTestLanguageExStandaloneSetupIdea().createInjector
	}

}
