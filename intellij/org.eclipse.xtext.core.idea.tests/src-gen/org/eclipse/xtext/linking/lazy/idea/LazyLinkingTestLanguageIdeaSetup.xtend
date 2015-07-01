package org.eclipse.xtext.linking.lazy.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class LazyLinkingTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new LazyLinkingTestLanguageStandaloneSetupIdea().createInjector
	}

}
