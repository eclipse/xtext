package org.eclipse.xtext.purexbase.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class PureXbaseIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new PureXbaseStandaloneSetupIdea().createInjector
	}

}
