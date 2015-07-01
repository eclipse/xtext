package org.eclipse.xtext.metamodelreferencing.tests.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class MetamodelRefTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new MetamodelRefTestLanguageStandaloneSetupIdea().createInjector
	}

}
