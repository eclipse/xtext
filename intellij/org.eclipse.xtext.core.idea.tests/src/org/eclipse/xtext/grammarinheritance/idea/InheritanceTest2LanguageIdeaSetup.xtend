package org.eclipse.xtext.grammarinheritance.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class InheritanceTest2LanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new InheritanceTest2LanguageStandaloneSetupIdea().createInjector
	}

}
