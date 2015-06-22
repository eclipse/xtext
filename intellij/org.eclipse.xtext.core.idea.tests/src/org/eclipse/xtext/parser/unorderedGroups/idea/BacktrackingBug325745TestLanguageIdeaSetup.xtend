package org.eclipse.xtext.parser.unorderedGroups.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class BacktrackingBug325745TestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new BacktrackingBug325745TestLanguageStandaloneSetupIdea().createInjector
	}

}
