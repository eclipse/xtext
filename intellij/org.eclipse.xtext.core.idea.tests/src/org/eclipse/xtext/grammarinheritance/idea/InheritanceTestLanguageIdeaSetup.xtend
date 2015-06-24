package org.eclipse.xtext.grammarinheritance.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class InheritanceTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new InheritanceTestLanguageStandaloneSetupIdea().createInjector
	}

}
