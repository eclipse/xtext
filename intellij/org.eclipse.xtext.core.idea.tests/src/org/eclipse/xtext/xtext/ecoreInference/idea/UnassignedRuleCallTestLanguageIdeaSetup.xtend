package org.eclipse.xtext.xtext.ecoreInference.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class UnassignedRuleCallTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new UnassignedRuleCallTestLanguageStandaloneSetupIdea().createInjector
	}

}
