package org.eclipse.xtext.parser.unorderedGroups.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class UnorderedGroupsTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new UnorderedGroupsTestLanguageStandaloneSetupIdea().createInjector
	}

}
