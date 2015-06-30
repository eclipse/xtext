package org.eclipse.xtext.resource.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class Bug385636IdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new Bug385636StandaloneSetupIdea().createInjector
	}

}
