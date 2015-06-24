package org.eclipse.xtext.metamodelreferencing.tests.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class MultiGenMMTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new MultiGenMMTestLanguageStandaloneSetupIdea().createInjector
	}

}
