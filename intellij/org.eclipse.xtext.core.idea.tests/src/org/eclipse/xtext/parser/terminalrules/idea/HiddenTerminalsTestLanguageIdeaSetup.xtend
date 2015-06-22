package org.eclipse.xtext.parser.terminalrules.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class HiddenTerminalsTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new HiddenTerminalsTestLanguageStandaloneSetupIdea().createInjector
	}

}
