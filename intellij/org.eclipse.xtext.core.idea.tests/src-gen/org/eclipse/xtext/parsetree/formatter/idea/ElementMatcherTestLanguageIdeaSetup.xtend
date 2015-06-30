package org.eclipse.xtext.parsetree.formatter.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ElementMatcherTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ElementMatcherTestLanguageStandaloneSetupIdea().createInjector
	}

}
