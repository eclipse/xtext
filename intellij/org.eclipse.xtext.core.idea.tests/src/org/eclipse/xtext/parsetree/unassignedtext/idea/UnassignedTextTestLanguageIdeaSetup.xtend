package org.eclipse.xtext.parsetree.unassignedtext.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class UnassignedTextTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new UnassignedTextTestLanguageStandaloneSetupIdea().createInjector
	}

}
