package org.eclipse.xtext.grammarinheritance.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class BaseInheritanceTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new BaseInheritanceTestLanguageStandaloneSetupIdea().createInjector
	}

}
