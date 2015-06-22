package org.eclipse.xtext.xbase.annotations.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class XbaseWithAnnotationsIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new XbaseWithAnnotationsStandaloneSetupIdea().createInjector
	}

}
