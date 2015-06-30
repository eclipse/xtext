package org.eclipse.xtext.parsetree.impl.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class CommentAssociationTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new CommentAssociationTestLanguageStandaloneSetupIdea().createInjector
	}

}
