package org.eclipse.xtext.parser.unorderedGroups.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class ExUnorderedGroupsTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new ExUnorderedGroupsTestLanguageStandaloneSetupIdea().createInjector
	}

}
