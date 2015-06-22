package org.eclipse.xtext.idea.sdomain.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class SDomainIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new SDomainStandaloneSetupIdea().createInjector
	}

}
