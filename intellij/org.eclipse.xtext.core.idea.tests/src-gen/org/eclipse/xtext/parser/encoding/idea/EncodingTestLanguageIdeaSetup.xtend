package org.eclipse.xtext.parser.encoding.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class EncodingTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new EncodingTestLanguageStandaloneSetupIdea().createInjector
	}

}
