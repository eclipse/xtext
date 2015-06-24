package org.eclipse.xtext.formatting2.internal.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class FormatterTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new FormatterTestLanguageStandaloneSetupIdea().createInjector
	}

}
