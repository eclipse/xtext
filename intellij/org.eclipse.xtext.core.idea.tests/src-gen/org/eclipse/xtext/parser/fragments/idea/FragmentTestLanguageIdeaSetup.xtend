package org.eclipse.xtext.parser.fragments.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class FragmentTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new FragmentTestLanguageStandaloneSetupIdea().createInjector
	}

}
