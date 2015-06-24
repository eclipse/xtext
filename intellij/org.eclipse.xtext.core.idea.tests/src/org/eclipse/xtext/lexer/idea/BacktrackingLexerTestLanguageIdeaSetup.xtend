package org.eclipse.xtext.lexer.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class BacktrackingLexerTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new BacktrackingLexerTestLanguageStandaloneSetupIdea().createInjector
	}

}
