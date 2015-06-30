package org.eclipse.xtext.parsetree.transientvalues.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class TransientValuesTestIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new TransientValuesTestStandaloneSetupIdea().createInjector
	}

}
