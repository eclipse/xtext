package org.eclipse.xtext.resource.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EObjectAtOffsetTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EObjectAtOffsetTestLanguageStandaloneSetupIdea().createInjector
	}

}
