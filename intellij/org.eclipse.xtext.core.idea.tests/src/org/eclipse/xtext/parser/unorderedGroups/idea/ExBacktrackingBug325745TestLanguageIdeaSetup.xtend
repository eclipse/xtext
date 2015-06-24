package org.eclipse.xtext.parser.unorderedGroups.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ExBacktrackingBug325745TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ExBacktrackingBug325745TestLanguageStandaloneSetupIdea().createInjector
	}

}
