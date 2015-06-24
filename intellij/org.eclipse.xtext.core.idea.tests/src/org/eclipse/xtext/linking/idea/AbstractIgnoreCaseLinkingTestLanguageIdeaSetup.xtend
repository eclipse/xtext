package org.eclipse.xtext.linking.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class AbstractIgnoreCaseLinkingTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea().createInjector
	}

}
