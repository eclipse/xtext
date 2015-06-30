package org.eclipse.xtext.serializer.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class SequencerTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new SequencerTestLanguageStandaloneSetupIdea().createInjector
	}

}
