package org.eclipse.xtext.parser.terminalrules.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class XtextTerminalsTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new XtextTerminalsTestLanguageStandaloneSetupIdea().createInjector
	}

}
