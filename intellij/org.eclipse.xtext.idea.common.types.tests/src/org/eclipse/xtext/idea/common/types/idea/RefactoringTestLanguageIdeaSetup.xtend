package org.eclipse.xtext.idea.common.types.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class RefactoringTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new RefactoringTestLanguageStandaloneSetupIdea().createInjector
	}

}
