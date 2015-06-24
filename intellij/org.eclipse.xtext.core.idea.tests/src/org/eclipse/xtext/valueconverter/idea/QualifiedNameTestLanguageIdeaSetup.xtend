package org.eclipse.xtext.valueconverter.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class QualifiedNameTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new QualifiedNameTestLanguageStandaloneSetupIdea().createInjector
	}

}
