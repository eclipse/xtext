package org.eclipse.xtext.serializer.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class SyntacticSequencerTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new SyntacticSequencerTestLanguageStandaloneSetupIdea().createInjector
	}

}
