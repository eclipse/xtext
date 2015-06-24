package org.eclipse.xtext.formatting2.regionaccess.internal.idea

import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

class RegionAccessTestLanguageIdeaSetup implements ISetup {

	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized
		new RegionAccessTestLanguageStandaloneSetupIdea().createInjector
	}

}
